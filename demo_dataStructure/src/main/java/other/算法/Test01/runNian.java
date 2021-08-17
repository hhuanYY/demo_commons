package other.算法.Test01;


import java.util.Scanner;

public class runNian {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true){
            System.err.println("请输入一个年份判断是否为闰年：");
            int year = scan.nextInt();
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                System.err.println(year+"为闰年!");
                System.err.println("关闭程序请输入:-1");
            }else {
                System.err.println(year+"不为闰年!");
            }
            if (year == -1) {
                break;
            }
        }
    }
}
