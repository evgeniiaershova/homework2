import java.util.*;
import java.util.stream.Collectors;

public class StreamsEx {

    public static void main(String[] args) {

        List<Integer> initialList = new ArrayList<Integer>();

        for (int i = 0; i < 1000; i++) {
            initialList.add(new Random().nextInt(1000 - 1) + 1);
        }

        List<Integer> collectionsResult = initialList.stream()
                .filter(myInteger -> (myInteger >= 18) && (myInteger <= 50))
                .skip(10)
                .limit(40)
                .collect(Collectors.toList());

        collectionsResult.forEach(System.out :: println);
    }

}
