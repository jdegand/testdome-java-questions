import java.util.*;

public class TrainComposition {
    // implementation same as my csharp solution

    private LinkedList<Integer> train;
  
    public TrainComposition() 
    {
      train = new LinkedList<Integer>();
    }
  
    public void attachWagonFromLeft(int wagonId) {
        train.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        train.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
         int node = train.removeFirst();
         return node;
    }

    public int detachWagonFromRight() {
        int node = train.removeLast();
        return node;
    }

    public static void main(String[] args) {
        TrainComposition train = new TrainComposition();
        train.attachWagonFromLeft(7);
        train.attachWagonFromLeft(13);
        System.out.println(train.detachWagonFromRight()); // 7 
        System.out.println(train.detachWagonFromLeft()); // 13
    }
}