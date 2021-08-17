package other.Works;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        File file = new File("out");
//        File[] files = file.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File f) {
//                return f.isFile() && f.getName().endsWith(".txt");
//            }
//        });
//        for (File x : files){
//            System.err.println(x.getName());
//        }

        // lambda表达式
        File[] files = file.listFiles(f -> f.isFile() && f.getName().endsWith(".txt"));
        for (File f: files) {
            System.err.println(f.getName());
        }
    }
}
