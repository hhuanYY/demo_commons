package 每日一练.工具类;

/**
 * @projectName: dataStructure 
 * @className: PageUtils
 * @author: yuanyinhuan
 * @description: 分页
 * @date: 2021/7/19 17:08
 */
public class PageUtils {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        boolean flag = false;
        System.err.println(flag ? a * b : c);


    }

    /**
     * 获取跳过的行数
     * @param pageIndex 当前页码
     * @param pageSize 每页显示数量
     * @return 跳过的行数
     */
    public static Integer getJumpRow(Integer pageIndex,Integer pageSize) {
        // 减1的目的: 获取的当前页面之前的页码数,然后乘以每页显示数量,得到跳过的条数
        return pageIndex > 0 ? (pageIndex - 1) * pageSize : 0;
    }
}
