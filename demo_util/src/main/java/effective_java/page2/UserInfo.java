package effective_java.page2;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName 遇到多个构造器参数时考虑使用构建器
 * @Description 遇到多个构造器参数时考虑使用构建器
 * @Author yyhuan
 * @Date 2023/1/2 17:44
 * @Version 1.0
 */
@Data
public class UserInfo {
    // 必填参数 username/age
    private final String username;
    private final Integer age;

    // 可选参数 address/phone/email/money
    private final String address;
    private final String phone;
    private final String email;
    private final BigDecimal money;

    // 创建静态成员类,用于给每个参数(必填/可选参数赋值)
    public static class User {
        private final String username;
        private final Integer age;

        private String address;
        private String phone;
        private String email;
        private BigDecimal money;

        public User setAddress(String val){
            address = val;
            return this;
        }

        public User setPhone(String val) {
            phone = val;
            return this;
        }

        public User setEmail(String val) {
            email = val;
            return this;
        }

        public User setMoney(BigDecimal val) {
            money = val;
            return this;
        }

        public User(String username, Integer age) {
            this.username = username;
            this.age = age;
        }

        // build()方法用于将赋值过的user对象 再次赋值给userInfo对象, 与userInfo的构造器关联
        public UserInfo build(){
            return new UserInfo(this);
        }

    }

    // 创建UserInfo的构造器,给user对象赋值的类 同步给userInfo对象
    public UserInfo(User user) {
        this.username = user.username;
        this.age = user.age;
        this.address = user.address;
        this.phone = user.phone;
        this.email = user.email;
        this.money = user.money;
    }


    public static void main(String[] args) {
        UserInfo user = new UserInfo.User("YYH", 25).setAddress("湖北省武汉市").setEmail("10086").setPhone("18627785960").build();
        System.out.println(JSON.toJSONString(user));
    }

}
