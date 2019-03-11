package tk.ddvudo.lambda;

import java.util.*;
import java.util.function.Supplier;

public class LambdaTest {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Random r = new Random();
        List<TestClass> heros = new ArrayList<TestClass>();

        for (int i = 1; i <= 10; i++) {
            heros.add(new TestClass("Test " + i, i, i));
        }
        Comparator<TestClass> c0 = new Comparator<TestClass>() {
            @Override
            public int compare(TestClass h1, TestClass h2) {
                if (h1.getAge() >= h2.getAge())
                    return 1;
                else
                    return -1;
            }
        };
        Comparator<TestClass> c1 = (TestClass h1, TestClass h2) -> {
            if (h1.getAge() >= h2.getAge())
                return 1;
            else
                return -1;
        };
        Comparator<TestClass> c2 = (h1, h2) -> (h1.getAge() - h2.getAge()) > 0 ? 1 : -1;

        //由匿名类写法演化
        Collections.sort(heros, (h1, h2) -> h1.getAge() - h2.getAge());
        //调用静态方法
//		Collections.sort(heros, (h1, h2) ->LambdaTest.comparator(h1,h2));
//		Collections.sort(heros, LambdaTest::comparator);
        //引用对象方法
//		Collections.sort(heros, new LambdaTest()::comparator2);
//		List<Object> list2 = getList(()->new ArrayList<Object>());
//		List<Object> list3 = getList(ArrayList::new);
//		System.out.println(List.class.isAssignableFrom(ArrayList.class));
//		System.out.println(Supplier.class.isAssignableFrom(ArrayList.class));
        System.out.println(heros.stream().sorted(c2).skip(2).limit(1).findFirst().get().toString());

    }

    public static int comparator(TestClass h1, TestClass h2) {
        return h1.getAge() - h2.getAge();
    }

    public static List<Object> getList(Supplier<List<Object>> s) {
        return s.get();
    }

    public int comparator2(TestClass h1, TestClass h2) {
        return h1.getAge() - h2.getAge();
    }
}
