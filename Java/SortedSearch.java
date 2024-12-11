import java.util.Arrays;

public class SortedSearch {
  public static int countNumbers(int[] sortedArray, int lessThan) {
    int index = Arrays.binarySearch(sortedArray, lessThan);

    // If the element is not found, binarySearch returns (-(insertion point) - 1)
    if (index < 0) {
      index = -index - 1;
    }

    return index;
  }

  public static void main(String[] args) {
    System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4)); // Should print 2
  }
}
