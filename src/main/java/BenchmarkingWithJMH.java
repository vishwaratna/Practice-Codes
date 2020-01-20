import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class BenchmarkingWithJMH {

  static Set<String> setA = new HashSet<>();

  public static Set<String> permutation(String prefix, String str, int len) {
    int n = str.length();
    if (prefix.length() == len) {
      setA.add(prefix);
    } else {
      for (int i = 0; i < n; i++) {
        permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), len);
      }
    }
    return setA;
  }

  public static void main(String[] args) {
    Set<String> setB = new HashSet<>();
    setB.addAll(permutation("", "1234", 2));
    Set<String> collect = setB.stream().map(
        s -> {
          Optional<String> reduce = Arrays.stream(s.split("")).sorted(Comparator.naturalOrder())
              .reduce((a, b) -> a + b);
          return reduce.get();
        })
        .collect(Collectors.toSet());
    System.out.println(collect);
  }
}

