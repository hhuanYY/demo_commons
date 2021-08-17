package 每日一练.enum测试;

/**
 * @projectName: dataStructure 
 * @className: enum枚举
 * @author: yuanyinhuan
 * @description:   
 * @date: 2021/6/16 11:15
 */
public class Entity {
    private Integer id;
    private TypeEnum type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
