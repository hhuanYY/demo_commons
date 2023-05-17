import cn.hutool.crypto.digest.BCrypt;

/**
 * @ClassName TestDemoo
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/3/27 19:02
 * @Version 1.0
 */
public class TestDemo {

    public static void main(String[] args) {
        String hashpw = BCrypt.hashpw("123456");
        System.out.println(hashpw);

        boolean checkpw = BCrypt.checkpw("Yyh125800", "$2a$10$UurHc573260oUVz12sDaPeLsmhZgJTys3/nRZs/RH1nUyqcxXA0X.");
        System.out.println(checkpw);
    }

}
