package effective_java.page3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName ComparableDemo
 * @Description TODO
 * @Author yyhuan
 * @Date 2023/1/29 22:20
 * @Version 1.0
 */
public class ComparableDemo<T> {
    public static void main(String[] args) {
        List<Man> manList = Arrays.asList(new Man("YYH", 25), new Man("XJH", 24), new Man("WXM", 27));

        System.out.println(manList.stream().sorted(Comparator.comparing(Man::getAge,Comparator.reverseOrder())).collect(Collectors.toList()));

        List<Man> men = new ArrayList<>(manList);
        Man[] menArray = men.toArray(new Man[0]);

        List<Man> list = Arrays.asList(menArray);
        List<Man> arrayList = new ArrayList<>(list);


        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        Integer[] toArray = integerList.toArray(new Integer[0]);


        Arrays.sort(menArray, Comparator.comparing(Man::getAge,Comparator.reverseOrder()));
        System.out.println(Arrays.toString(menArray));




    }
}

@NoArgsConstructor
@AllArgsConstructor
@Data
class Man implements Comparator<String>  {
    private String name;
    private Integer age;

    @Override
    public int compare(String o1, String o2) {
        return 0;
    }
}


