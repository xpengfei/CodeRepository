package xpffly.lambda.list;

import com.xpffly.lambda.dto.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: xpengfei
 * @Date: 2019/12/31 10:58
 * @Description：
 */
public class MergeList {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setAge(20);
        student.setMoney(10000);
        student.setName("xpf");
        list.add(student);
        System.out.println("list:"+list.toString());
        List<Student> list2 = new ArrayList<>();
        Student student2 = new Student();
        student2.setName("xpf");
        list2.add(student2);
        System.out.println("list2:"+list2.toString());
//        List<AClass> intersectResult = aClassList1.stream().filter(aClassList2::contains).collect(Collectors.toList());

//        list2.forEach();

        List<Student> result = list.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println(result);
        List<Student> list3 = new ArrayList<>();
        list3.addAll(list);
        list3.addAll(list2);

        list3.forEach(System.out::println);
    }
}
