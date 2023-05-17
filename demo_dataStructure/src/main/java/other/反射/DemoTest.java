package other.反射;

/**
 * <p>
 *
 * </p>
 *
 * @author yyhuana
 * @since 2023/4/28
 */
public class DemoTest {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());


        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };



    }
}
