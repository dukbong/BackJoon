import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    int limit, virus, sec, endY, endX;
    int[] mY = { -1, 1, 0, 0 }, mX = { 0, 0, -1, 1 };
    int[][] graph;
    boolean[][] visited;

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] sizeAndMaxNumVirus = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        limit = sizeAndMaxNumVirus[0];
        virus = sizeAndMaxNumVirus[1];
        graph = new int[limit][limit];
        visited = new boolean[limit][limit];

        for (int i = 0; i < limit; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] secAndXY = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sec = secAndXY[0];
        endX = secAndXY[1];
        endY = secAndXY[2];

        bfs();

        System.out.println(graph[endX - 1][endY - 1]);
    }

    private void bfs() {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 1; i <= virus; i++) {
            for (int j = 0; j < limit; j++) {
                for (int k = 0; k < limit; k++) {
                    if (graph[j][k] == i) {
                        q.offer(new int[]{j, k});
                        visited[j][k] = true;
                    }
                }
            }
        }

        while (!q.isEmpty() && sec-- > 0) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int[] now = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nY = now[0] + mY[j];
                    int nX = now[1] + mX[j];

                    if (nY >= 0 && nX >= 0 && nY < limit && nX < limit) {
                        if (graph[nY][nX] == 0 && !visited[nY][nX]) {
                            graph[nY][nX] = graph[now[0]][now[1]];
                            q.offer(new int[]{nY, nX});
                            visited[nY][nX] = true;
                        }
                    }
                }
            }
        }
    }
}