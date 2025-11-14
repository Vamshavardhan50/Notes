import java.util.ArrayList;
import java.util.List;

public class LeftRotByKplaces {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;
    int n = arr.length;
    k = k % n;

    List<Integer> temp = new ArrayList<>();

    // Corrected: store first k elements
    for (int i = 0; i < k; i++) {
      temp.add(arr[i]);
    }

    // Shift elements left by k
    for (int i = k; i < n; i++) {
      arr[i - k] = arr[i];
    }

    // Add temp values at the end
    for (int i = n - k; i < n; i++) {
      arr[i] = temp.get(i - (n - k));
    }

    System.out.println("Array after left rotation by " + k + " places:");
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
