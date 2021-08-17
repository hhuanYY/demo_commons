package 每日一练.数组_字符串相关;

import java.util.Stack;

/**
* @program: dataStructure
* @description: 有效括号
* @author: 袁银欢
* @createTime: 2021/03/05 12:04
**/
public class Effective_Bracket {
    public static void main(String[] args) {
        String s = "{{}}[{[()]}][]{}()";
        System.err.println(method(s));
    }

    private static boolean method(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '{' || c[i] == '[' || c[i] == '(') {
                stack.push(c[i]);
            }else {
                // 栈为空,却来了反括号,则不合规范
                if (stack.isEmpty()) {
                    return false;
                }

                Character result = stack.pop();
                switch (c[i]) {
                    case ')':{
                        if (result != '('){
                            return false;
                        }
                        break;
                    }
                    case '}':{
                        if (result != '{') {
                            return false;
                        }
                        break;
                    }
                    case ']':{
                        if (result != '[') {
                            return false;
                        }
                        break;
                    }
                }
            }
        }
        // for循环结束以后,当栈中无元素时,才规则正确！
        if (stack.isEmpty()) {
            return true;
        }else {
            return false;
        }
    }
}
