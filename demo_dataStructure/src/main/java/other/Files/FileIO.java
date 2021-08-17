package other.Files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ProjectName: dataStructure 
 * @ClassName: FileIO
 * @Author: YYH
 * @Description:   文件流  -- 单独使用最慢
 * @CreateDate: 2021/4/25 16:48
 */
public class FileIO {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("G:\\yyh.txt");
        FileOutputStream fos = new FileOutputStream("G:\\copy_yyh.txt");

        // 单个字节传输最慢
        int len = -1;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }
        fis.close();
        fos.close();


        // 优化：使用字节数组传输  (这种方式的传输效果和使用缓存流一样！)
        byte[] bytes = new byte[10 * 1024];
        int index = -1;
        while ((index = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, index);
        }


    }
}
