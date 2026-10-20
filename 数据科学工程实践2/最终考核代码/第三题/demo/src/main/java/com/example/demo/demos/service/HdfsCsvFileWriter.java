package com.example.demo.demos.service;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.FSDataOutputStream;

import java.io.*;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HdfsCsvFileWriter {

//    hdfs://192.168.137.128:9000/robot/data/movies.csv
    private static final String HDFS_URI = "hdfs://192.168.137.128:9000"; // HDFS URI
    private static final String DIRECTORY_PATH = "/ratingsdata"; // HDFS上的目录路径
    private static final String LOCAL_CSV_FILE = "D://工程实践2//工程实践数据//data//ratings.csv"; // 本地CSV文件路径
    private static final int BATCH_SIZE = 5; // 每批次处理的行数
    private static final int DELAY = 10000; // 延迟时间，5秒
    private long lineCounter = 0; // 用于跟踪文件读取位置

    public static void main(String[] args) {
        System.setProperty("HADOOP_USER_NAME","robot");
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        HdfsCsvFileWriter writer = new HdfsCsvFileWriter();
        executor.scheduleWithFixedDelay(writer.new WriteTask(), 0, DELAY, TimeUnit.MILLISECONDS);
    }//这个任务每隔一定时间就会执行一次批量写入操作

    class WriteTask implements Runnable {
        @Override
        public void run() {
            Configuration configuration = new Configuration();
            configuration.set("fs.defaultFS", HDFS_URI);

            // 生成带有时间戳的唯一文件名
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String filePath = DIRECTORY_PATH + "/ratings-" + timestamp + ".csv";
            Path file = new Path(filePath); // 创建Path对象

            try (FileSystem fs = FileSystem.get(configuration);
                 FSDataOutputStream outputStream = fs.create(file);
                 BufferedWriter br = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"))) {

                // 从本地CSV文件中读取指定数量的行
                try (Stream<String> lines = Files.lines(Paths.get(LOCAL_CSV_FILE))) {
                    List<String> batch = lines.skip(lineCounter).limit(BATCH_SIZE).collect(Collectors.toList());
                    lineCounter += batch.size(); // 更新行计数器

                    for (String line : batch) {
                        br.write(line);
                        br.newLine();
                    }
                }

                System.out.println("批量数据成功写入新的HDFS文件: " + file.getName());
            } catch (IOException e) {
                System.out.println("无法将本地CSV文件中的数据写入HDFS: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
