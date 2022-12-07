/**
 * Esta clase ssir veiasfpmsa
 */

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 11; i++) {
            numbers.add(i);
        }

        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            System.out.println(numbers.get(i));
        }
    }

}
