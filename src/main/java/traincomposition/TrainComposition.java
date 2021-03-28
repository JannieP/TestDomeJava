package traincomposition;

import java.util.Deque;
import java.util.LinkedList;

public class TrainComposition {
    private final Deque<Integer> wagons = new LinkedList<>();

    public void attachWagonFromLeft(int wagonId) {
        wagons.addFirst(wagonId);
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public void attachWagonFromRight(int wagonId) {
        wagons.addLast(wagonId);
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public int detachWagonFromLeft() {
        if (!wagons.isEmpty()) {
            return wagons.removeFirst(); // Alternative if exception should not be bubbled up: wagons.pollFirst()
        } else {
            return 0;
        }
        // throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public int detachWagonFromRight() {
        if (!wagons.isEmpty()) {
            return wagons.removeLast(); // Alternative if exception should not be bubbled up: wagons.pollLast()
        } else {
            return 0;
        }
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }
    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}
