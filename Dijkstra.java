public class Dijkstra {
    public static void main(String[] args) {
        int graph[][] = new int[][] {
                { 0, 0, 1, 2, 0, 0, 0 },
                { 0, 0, 2, 0, 0, 3, 0 },
                { 1, 2, 0, 1, 3, 0, 0 },
                { 2, 0, 1, 0, 0, 0, 1 },
                { 0, 0, 3, 0, 0, 2, 0 },
                { 0, 3, 0, 0, 2, 0, 1 },
                { 0, 0, 0, 1, 0, 1, 0 } };
        dij(graph, 0);
    }

    public static void dij(int[][] graph, int src) {
        int count = graph.length;
        boolean[] visited = new boolean[count];
        int[] distance = new int[count];
        for (int i = 0; i < count; i++) {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        distance[src] = 0;
        for (int i = 0; i < count; i++) {
            int u = findMinDistance(distance, visited);
            visited[u] = true;

            for (int v = 0; v < count; v++) {
                if (!visited[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.println(String.format("Distance from %s to %s is %s", src, i, distance[i]));
        }
    }

    private static int findMinDistance(int[] distance, boolean[] visited) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }
}
