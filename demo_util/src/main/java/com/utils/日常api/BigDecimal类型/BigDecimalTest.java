package com.utils.日常api.BigDecimal类型;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @author: yuanyinhuan
 * @date: 2021/12/2 11:10
 */
public class BigDecimalTest {

    /**
     * 去除尾部所有的0，并返回一个字符串类型的num
     * @param num
     * @return
     */
    public String decimalToStr(BigDecimal num) {
        return num.stripTrailingZeros().toPlainString();
    }

    /**
     * 处理小数(保留N位小数点)
     * @param num 目标数
     * @return 结果数
     */
    public String handleNum(String num) {
        return new BigDecimal(num).setScale(2, RoundingMode.HALF_UP).toPlainString();
    }

    /**
     * a / b
     * @param a 除数
     * @param b 被除数
     * @return 结果
     */
    public BigDecimal divideDecimal(BigDecimal a, BigDecimal b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.ZERO.compareTo(b) == 0 ? BigDecimal.ZERO : a.divide(b, 2, RoundingMode.HALF_UP);
    }


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


    /**
     * 字符串转BigDecimal进行处理后,再转成字符串
     * @param num
     * @return
     */
    public String handleBigDecimalToStr(String num) {
        return new BigDecimal(num).setScale(2, RoundingMode.HALF_UP).toPlainString();
    }

}
