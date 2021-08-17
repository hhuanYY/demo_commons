package 每日一练.enum测试;

/**
 * @projectName: dataStructure 
 * @className: test
 * @author: yuanyinhuan
 * @description:   
 * @date: 2021/6/16 11:17
 */
public class test {
    public static void main(String[] args) {
        Entity entity = new Entity();
        entity.setId(10);
        entity.setType(TypeEnum.TEXT);
        System.err.println(entity);
    }
}
