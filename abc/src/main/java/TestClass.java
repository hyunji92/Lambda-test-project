import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by hyunji on 2016. 6. 10..
 */
public class TestClass {
    public static void main(String args[]) {
        List<Integer> intArray = new ArrayList<>();

        final int[] sum = {0};

        for(int i = 50000; i > 0; i--)
            intArray.add(i);


        final int[] count = {0};

        AtomicInteger ai = new AtomicInteger(0);

        List<Integer> sortedArray =
                intArray
                    .stream()
                    .sorted(Integer::compare)
                    .filter(i -> i > 49000)
                    .collect(Collectors.toList());

        for(Integer i : sortedArray) {

            System.out.println(i);
        }

        // 1 : sum = 1 + 2;
        // 2 : sum = 1 + 3;

       // test(intArray, sum, count, ai);
    }

    private static void test(List<Integer> intArray, int[] sum, int[] count, AtomicInteger ai) {
        System.out.println(ai.get());

        sum[0] = 0;
        count[0] = 0;
        ai.set(0);


        intArray
                .parallelStream()
                .forEach(i -> System.out.println(i));

        System.out.println(ai.get());
    }

}
