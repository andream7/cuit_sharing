package com.example.demo.demos.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import scala.Tuple2;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Component
public class SparkStreamingTask implements CommandLineRunner {

    private long totalProcessedLines = 0; // 用于统计总共处理的行数

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=======SparkStreamingTask==========");
        // 创建Spark配置，使用本地模式
        SparkConf sparkConf = new SparkConf().setAppName("SparkStreamingTask").setMaster("local[*]");

        // 创建Spark Streaming上下文，每5秒批处理一次
        JavaStreamingContext streamingContext = new JavaStreamingContext(sparkConf, new Duration(5000));

        // 设置日志级别为 INFO
        streamingContext.sparkContext().setLogLevel("INFO");

        // 监听 HDFS 目录，处理新文件
        JavaDStream<String> hdfsStream = streamingContext.textFileStream("hdfs://192.168.137.128:9000/ratingsdata/");

        // 从数据流中提取 rating 并直接发送
        hdfsStream.foreachRDD(rdd -> {
            if (!rdd.isEmpty()) {
                long rddProcessedLines = rdd.count(); // 统计当前RDD的行数
                totalProcessedLines += rddProcessedLines; // 更新总处理行数

                System.out.println("处理来自HDFS的新RDD");
                System.out.println("本RDD中的行数：" + rddProcessedLines);
                System.out.println("到目前为止总共处理的行数：" + totalProcessedLines);

                rdd.foreachPartition(partition -> {
                    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                        partition.forEachRemaining(line -> {
                            // 打印从 HDFS 读取的每一行数据
                            System.out.println("HDFS数据：" + line);

                            if (line.matches("\\d+,\\d+,\\d+(\\.\\d+)?,\\d+")) {
                                String[] parts = line.split(",");
                                double rating = Double.parseDouble(parts[2]);

                                Map<String, Object> data = new HashMap<>();
                                data.put("rating", rating);
                                try {
                                    String json = new ObjectMapper().writeValueAsString(data);
                                    HttpPost postRequest = new HttpPost("http://localhost:8081/publishData");
                                    postRequest.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

                                    try (CloseableHttpResponse response = httpClient.execute(postRequest)) {
                                        // 处理响应或记录日志
//                                        System.out.println("响应状态：" + response.getStatusLine());
                                    } catch (IOException e) {
                                        // 记录异常
                                        System.err.println("将数据发送到服务器时出错：" + e.getMessage());
                                        e.printStackTrace();
                                    }
                                } catch (JsonProcessingException e) {
                                    // 记录 JSON 转换异常
                                    System.err.println("将数据转换为JSON时出错：" + e.getMessage());
                                    e.printStackTrace();
                                }
                            }
                        });
                    } catch (IOException e) {
                        // 处理 HttpClient 创建或关闭时的异常
                        System.err.println("创建或关闭HttpClient时出错：" + e.getMessage());
                        e.printStackTrace();
                    }
                });
            } else {
                System.out.println("收到空的RDD，HDFS中没有新数据");
            }
        });

        // 启动 Spark Streaming
        streamingContext.start();
        streamingContext.awaitTermination();
    }
}
