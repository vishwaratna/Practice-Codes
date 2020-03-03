package DirectoryWatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
public class CandidateCode {
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(s.readLine());
    for (int l = 0; l < t; l++) {
      PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>(
          (e1, e2) -> e1.getWeight() > e2.getWeight() ? -1
              : e1.getWeight() < e2.getWeight() ? 1 : 0);
      int[] nAndmArray = new int[2];
      Arrays.stream(s.readLine().split("  ")).forEach(p -> {
        String[] s1 = p.split(" ");
        nAndmArray[0] = Integer.parseInt(s1[0]);
        nAndmArray[1] = Integer.parseInt(s1[1]);
      });
      for (int i = 0; i < nAndmArray[1]; i++) {
        Arrays.stream(s.readLine().split("  ")).forEach(j -> {
          final String[] s1 = j.split(" ");
          priorityQueue.add(new Edge(Integer.parseInt(s1[0]) - 1, Integer.parseInt(s1[1]) - 1,
              Integer.parseInt(s1[2])));
        });
      }
      DisjointUnionSets ds = new DisjointUnionSets(nAndmArray[0]);
      long ans = 0;
      while (!priorityQueue.isEmpty()) {
        Edge e = priorityQueue.poll();
        if (ds.findSet(e.v1) != ds.findSet(e.v2)) {
          ds.union(e.v1, e.v2);
          ans += e.getWeight();

        }
      }
      System.out.println(ans);
      System.out.println(ds.parent.length);
    }
  }
}

class Edge {

  public int v1, v2, weight;

  Edge(int v1, int v2, int weight) {
    this.v1 = v1;
    this.v2 = v2;
    this.weight = weight;
  }

  public int getWeight() {
    return weight;
  }
}

class DisjointUnionSets {
  int[] rank, parent;
  int n;

  public DisjointUnionSets(int n) {
    rank = new int[n];
    parent = new int[n];
    this.n = n;
    makeSet();
  }

  void makeSet() {
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  int findSet(int x) {
    if (parent[x] != x) {
      parent[x] = findSet(parent[x]);
    }
    return parent[x];
  }

  void union(int x, int y) {
    int xRoot = findSet(x);
    int yRoot = findSet(y);
    if (xRoot == yRoot) {
      return;
    }
    if (rank[xRoot] < rank[yRoot]) {
      parent[xRoot] = yRoot;
    } else if (rank[yRoot] < rank[xRoot]) {
      parent[yRoot] = xRoot;
    } else {
      parent[yRoot] = xRoot;
      rank[xRoot] = rank[xRoot] + 1;
    }
  }

}

