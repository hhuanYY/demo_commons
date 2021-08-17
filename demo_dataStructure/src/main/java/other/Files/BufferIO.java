package other.Files;

import java.io.*;

/**
 * 缓冲流：加速字节方式传输
 */
public class BufferIO {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("G:\\yyh.war");
        FileOutputStream outputStream = new FileOutputStream("G:\\copy_yyh.war");

        // 缓冲流：加速字节方式传输
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        int len;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }
        System.err.println("end!");
    }
}
