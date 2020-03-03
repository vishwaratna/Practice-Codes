package DirectoryWatch;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class MainWatch {

  static class Nodes{
    Integer from;
    Integer to;
    Integer cost;
    List<Integer> li = new ArrayList<>();

    public Integer getFrom() {
      return from;
    }

    public Integer getTo() {
      return to;
    }

    public Integer getCost() {
      return cost;
    }

    public List<Integer> getLi() {
      return li;
    }

    public Nodes(Integer from, Integer to, Integer cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }
  }
  public static void main(String[] args) {
    List<Nodes> collect = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter No of Cases:");
    int x = sc.nextInt();
    sc.nextLine();
     for(int i=0;i<x;i++){
       Arrays.stream(sc.nextLine().split("  ")).map(s -> {
         String[] split = s.split(" ");
         collect.add(new Nodes(Integer.valueOf(split[0]), Integer.valueOf(split[1]),
             Integer.valueOf(split[2])));
         return new Nodes(Integer.valueOf(split[0]), Integer.valueOf(split[1]),
             Integer.valueOf(split[2]));
       }).count();
     }

    System.out.println(collect);

  }
}