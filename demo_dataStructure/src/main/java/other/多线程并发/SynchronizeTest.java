package other.多线程并发;

public class SynchronizeTest {
    public  int count = 0;

    public void addCount() {
        count++;
    }

    public static void main(String[] args) {
        System.err.println("开始创建对象...");
        SynchronizeTest test = new SynchronizeTest();
        System.err.println("结束创建对象...");
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        test.addCount();
                    }
                }

                ;
            }.start();
            System.err.println("结果为：" + test.count);
        }
    }
}
