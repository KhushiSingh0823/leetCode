import java.util.*;

class StonesRemoved {
    public void dfs(int src, List<List<Integer>> adjList, boolean visited[]) {
        visited[src] = true;
        for (int neighbour : adjList.get(src)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adjList, visited);
            }
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int components = 0;
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adjList, visited);
                components++;
            }
        }
        return n - components;
    }

    public static void main(String[] args) {
        StonesRemoved sr = new StonesRemoved();
        int[][] stones = {{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}};
        int result = sr.removeStones(stones);
        System.out.println("Number of stones removed: " + result);
    }
}