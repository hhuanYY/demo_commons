package other.秋招.剑指offer;

public class a_替换空格 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer(" han  YYH ");
        System.err.println(reverseNull(str));
    }

    private static String reverseNull(StringBuffer str) {
        return str == null ? null : str.toString().replaceAll(" ", "%20");
    }
}
