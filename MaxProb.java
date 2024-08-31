import java.util.*;
public class MaxProb {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        @SuppressWarnings("unchecked")
        List<int[]>[] adjacencyList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjacencyList[u].add(new int[]{v, i});
            adjacencyList[v].add(new int[]{u, i});
        }

        for (int i = 0; i < n - 1; i++) {
            boolean updated = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double prob = succProb[j];

                if (maxProb[u] * prob > maxProb[v]) {
                    maxProb[v] = maxProb[u] * prob;
                    updated = true;
                }
                if (maxProb[v] * prob > maxProb[u]) {
                    maxProb[u] = maxProb[v] * prob;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        return maxProb[end_node];
    }

    public static void main(String[] args) {
        MaxProb solution = new MaxProb();

        int n = 5; // number of nodes
        int[][] edges = {{0, 1}, {1, 2}, {0, 2}, {2, 3}, {3, 4}};
        double[] succProb = {0.5, 0.5, 0.2, 0.3, 0.1};
        int start_node = 0;
        int end_node = 4;

        double maxProb = solution.maxProbability(n, edges, succProb, start_node, end_node);
        System.out.println("Maximum probability: " + maxProb);
    }
}