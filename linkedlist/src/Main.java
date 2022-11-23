
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.remove(3);

        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            System.out.println(linkedList.get(i));
        }

        //System.out.println(linkedList.getFirstOne());
        //System.out.println(linkedList.getLastOne());
    }
}
