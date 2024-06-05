import java.util.Arrays;

public class Prim {

    public static void main(String[] args) {
        int v = 5;

        int graph[][] = new int[][] {
                { 0, 0, 1, 2, 0, 0, 0 },
                { 0, 0, 2, 0, 0, 3, 0 },
                { 1, 2, 0, 1, 3, 0, 0 },
                { 2, 0, 1, 0, 0, 0, 1 },
                { 0, 0, 3, 0, 0, 2, 0 },
                { 0, 3, 0, 0, 2, 0, 1 },
                { 0, 0, 0, 1, 0, 1, 0 } };

        prim(graph, v);
    }

    public static void prim(int g[][], int v) {
        int Inf = 9999999;

        int no_edge; // number of edge

        // array to track selected vertex
        // selected is true, if not false
        boolean select[] = new boolean[v];

        // initially set to false
        Arrays.fill(select, false);

        no_edge = 0;

        // 0th vertex true
        select[0] = true;

        System.out.println("Edge : Weight");

        while (no_edge < v - 1) {
            int min = Inf;
            int x = 0;   // row
            int y = 0;   // columm

            for (int i = 0; i < v; i++) {
                if (select[i] == true) {
                    for (int j = 0; j < v; j++) {
                        if (!select[j] && g[i][j] != 0) {
                            if (min > g[i][j]) {
                                min = g[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }
            System.out.println(x + " - " + y + " :  " + g[x][y]);
            select[y] = true;
            no_edge++;
        }
    }
}
