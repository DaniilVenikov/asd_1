import java.util.ArrayList;

public class Adder {

    public static ArrayList<Integer> sumTwoLists(LinkedList firstList, LinkedList secondList) {
        ArrayList<Integer> result = new ArrayList<>();

        int count = firstList.count();
        if (count == secondList.count() && count != 0) {
            Node nodeFirst = firstList.head;
            Node nodeSecond = secondList.head;

            while (count > 0) {
                result.add(nodeFirst.value + nodeSecond.value);
                count--;
                nodeFirst = nodeFirst.next;
                nodeSecond = nodeSecond.next;
            }

        }

        return result;
    }
}
