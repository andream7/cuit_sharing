import java.io.UnsupportedEncodingException;

public class GB2312{
    public static void main(String[] args){
        System.out.println(str2GB2312("成都信息工程大学计算机学院杨崎１２３４５ＡＢＣＤＥＦＧａｂｃｄｅｆｇ轻轻的我走了，正如我轻轻的来；我轻轻的招手，作别西天的云彩。那河畔的金柳，是夕阳中的新娘；波光里的艳影，成都信息工程大学。"));
    }

    public static StringBuilder str2GB2312(String word){
        StringBuilder builder = new StringBuilder();
        byte[] bs;
        try {
            bs = word.getBytes("gb2312");
            for (int i = 0; i< bs.length; i++){
                String temp = Integer.toHexString(bs[i]);
                temp = temp.substring(6, 8);
                if (i % 2 != 0){
                    builder.append(temp+" ");
                } else {
                    builder.append(temp);
                }
            }
        } catch(UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return builder;
    }
}



