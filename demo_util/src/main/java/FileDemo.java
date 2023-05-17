import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @ClassName FileDemo
 * @Description TODO
 * @Author yyhuan
 * @Date 2022/12/7 12:51
 * @Version 1.0
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {

        File source = new File("D:\\files\\demo.7z");
        for (int i = 1; i <= 1; i++) {
            File dest = new File("D:\\files\\demo1\\"+ i +".7z");
            channel(source,dest);
        }

    }

    private static void copyFileUsingFileStreams(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }

    private static void channel(File source, File dest) throws IOException {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert inputChannel != null;
            inputChannel.close();
            outputChannel.close();
        }
    }

    private static <inputChannel> void channel1(File source, File dest) throws IOException {
        try (FileChannel inputChannel = new FileInputStream(source).getChannel(); FileChannel outputChannel = new FileOutputStream(dest).getChannel()) {
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void FileUtilsDemo(File source, File dest) throws IOException {
        FileCopyUtils.copy(source, dest);
    }

}
