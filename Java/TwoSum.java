import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            int diff = sum - list[i];

            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }
            map.put(list[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if (indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}
