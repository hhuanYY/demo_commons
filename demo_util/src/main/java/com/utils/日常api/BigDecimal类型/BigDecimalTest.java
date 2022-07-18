package com.utils.日常api.BigDecimal类型;

import java.math.BigDecimal;

/**
 * @author: yuanyinhuan
 * @date: 2021/12/2 11:10
 */
public class BigDecimalTest {
    public static void main(String[] args) {

        /**BigDecimal类型相互除法*/
        BigDecimal sumupRevpar = new BigDecimal(104.284);
        BigDecimal sumupRevparTarget = new BigDecimal(151.4869);
        /**
         * 作用: sumupRevpar / sumupRevparTarget
         * 1. sumupRevparTarget:除数
         * 2. 5: 保留五位小数
         * 3. BigDecimal.ROUND_DOWN: 使用的模式
         *      BigDecimal.ROUND_DOWN:直接省略多余的小数，比如1.28如果保留1位小数，得到的就是1.2
         *      BigDecimal.ROUND_UP:直接进位，比如1.21如果保留1位小数，得到的就是1.3
         *      BigDecimal.ROUND_HALF_UP:四舍五入，2.35保留1位，变成2.4
         *      BigDecimal.ROUND_HALF_DOWN:四舍五入，2.35保留1位，变成2.3
         */
        BigDecimal divide = sumupRevpar.divide(sumupRevparTarget, 5, BigDecimal.ROUND_DOWN);
        System.err.println(divide);


        /**
         * compareTo比较两个BigDecimal类型数据
         * public int compareTo(BigDecimal val){}
         * 1. b1==b2 则返回0
         * 2. b1!=b2 则返回1
         *
         */
        BigDecimal b1 = BigDecimal.ONE;
        BigDecimal b2 = BigDecimal.ZERO;
        int i = b1.compareTo(b2);

    }
}
