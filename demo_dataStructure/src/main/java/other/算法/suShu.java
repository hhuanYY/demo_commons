package other.算法;

/**
 * 题目：
 * 判断101-200之间素数存在的个数,并输出结果
 */
public class suShu {
    public static void main(String[] args) {
        //统计素数个数
        int count = 0;
        for (int i=2; i<=10; i++){
            if (isPrime(i)){
                count++;
                System.err.println(i);

            }
        }
        System.err.println("一共素数个数为：" + count);
    }

    //判断是否为素数  为素数则true  非素数则false
    private static boolean isPrime(int i) {
        for (int j=2; j<i; j++){
            if (i%j == 0){
                return false;
            }
        }
        return true;
    }
}
