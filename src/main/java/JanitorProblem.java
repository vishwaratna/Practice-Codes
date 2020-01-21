import java.util.Arrays;
import java.util.Scanner;

public class JanitorProblem {
  public static void main(String[] args) {
    int n = 6;
    double[] a = {0.4, 0.4, 0.4, 2.4, 2.4, 2.4};
    int low = 0, high = n - 1, count = 0;
    Arrays.sort(a);
    for (int i = 0; i < n; i++) {
      if (low > high) {
        break;
      }
      if (a[high] == 3.0) {
        count++;
      }
      if (a[low] + a[high] > 3.0) {
        count++;
        high--;
      } else {
        count++;
        low++;
        high--;
      }
    }
    System.out.print(count);
  }
}

