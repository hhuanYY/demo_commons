package other.Works;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class IO_Copy {
    public static void main(String[] args) throws IOException {
        File file = new File("yyh.txt");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("copyDemo.txt");

        byte[] byt = new byte[1024];
        int len = -1; //每次读取的长度
        while ((len = fis.read(byt)) !=-1){
            fos.write(byt,0,len);
        }
    }
}
