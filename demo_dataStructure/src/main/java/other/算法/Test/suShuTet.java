package other.算法.Test;

/**
 * 判断101-200之间素数的个数,并列出结果
 */
public class suShuTet {
    public static void main(String[] args) {
        //计数
        int count = 0;
        for (int i = 101; i <= 200; i++) {
            if (isPrime(i)){
                count++;
                System.err.println(i);
            }
        }
        System.err.println("素数个数为："+ count);
    }

    // 判断某个数是否为素数
    private static boolean isPrime(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) { //此时判断的是为素数的条件,被2能够整除的数一定不为素数
                return false;
            }
        }
        return true;
    }
}
