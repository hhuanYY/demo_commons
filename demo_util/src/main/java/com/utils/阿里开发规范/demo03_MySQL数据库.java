package com.utils.阿里开发规范;

import com.utils.开发常用.rocketmq.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class demo03_MySQL数据库 {

    public static void main(String[] args) {
        // 1. 使用Optional防止NEP异常
        // 构造一个Optional对象
        List<User> list = new ArrayList<>();
        list.add(new User("YYH", 18, "hubei", null));
        list.add(new User("XJH", 17, "yichang", null));
        Optional<List<User>> optionalUserList = Optional.of(list);

        // 2. 内连接、外连接(左连接/右连接)、全连接(笛卡尔积)
        // 内连接(INNER JOIN): 只返回符合连接条件的数据, 不符匹配连接条件的数据被过滤
        // 左连接(LEFT JOIN): 无论连接条件是否匹配, 会将左表的全部数据返回; 匹配右表的符合数据
        // 右连接(RIGHT JOIN): 无论连接条件是否匹配, 会将右表的全部数据返回; 匹配左表的符合数据
        // 全连接(FULL JOIN): 无论连接条件是否匹配, 会返回两边的乘积数据


        // 3.索引
        // 业务具有唯一特性的字段，即使是组合索引，也必须建立唯一索引
        // 超过三个表，禁止使用join; 即使使用join也需要注意数据类型保持绝对一致; 多表关联查询时要保证被关联的字段需要有索引
        // 在varchar类型字段上建立索引时, 必须制定索引长度
        // 建立联合索引时,区分度最高的在左边：  如果 where a=? and b=?，a 列的几乎接近于唯一值，那么只需要单建 idx_a 索引即可
        // in 操作能避免则避免，若实在避免不了，需要仔细评估 in 后边的集合元素数量，控s制在 1000 个之内
    }

}
