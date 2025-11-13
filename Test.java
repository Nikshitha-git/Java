import java.util.*;

public class Test {
    static int time = 0;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[] disc, low, parent;
    static Set<Integer> articulationPoints;

    static void dfs(int u) {
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                children++;
                parent[v] = u;
                dfs(v);

                low[u] = Math.min(low[u], low[v]);

                if (parent[u] != -1 && low[v] >= disc[u]) {
                    articulationPoints.add(u);
                }

                if (parent[u] == -1 && children > 1) {
                    articulationPoints.add(u);
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of Nodes: ");
        int n = sc.nextInt();

        System.out.print("Number of Connections: ");
        int m = sc.nextInt();

        System.out.println("Connections: ");
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new boolean[n];
        disc = new int[n];
        low = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);
        articulationPoints = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }
        
        for (int ap : articulationPoints) {
            System.out.print(ap + " ");
        }
    }
}
