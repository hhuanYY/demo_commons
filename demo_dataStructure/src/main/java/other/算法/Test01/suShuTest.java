package other.算法.Test01;

/**
 * 找出101-200之间的素数个数,并列出
 */
public class suShuTest {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 101; i <= 200; i++) {
            if (isSuShu(i)){
                count++;
                System.err.print(i+",");
            }
        }
        System.err.println("101-200素数总和为:"+count);
    }

    private static boolean isSuShu(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {  //判断不为素数
                return false;
            }
        }
        return true;  //为素数返回true
    }
}
