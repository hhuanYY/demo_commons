package other.算法.Test01;

public class WaterFollowNum {
    public static void main(String[] args) {
        int a,b,c;
        for (int i = 101; i < 10000; i++) {
            a = i%10;
            b = i/10%10;
            c = i/100;
            if (a * a * a + b * b * b + c * c * c == i)
                System.err.println(i);
            }
        }
    }

