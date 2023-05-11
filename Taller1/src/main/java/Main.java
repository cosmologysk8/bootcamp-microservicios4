import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);

        int count = 0;

        for (int num : numbers) {
            if (num > 10) {
                count++;
            }
        }

        long count2 = numbers.stream().filter(n -> n > 10).count();


        System.out.println(count);
        System.out.println(count2);
    }

}
