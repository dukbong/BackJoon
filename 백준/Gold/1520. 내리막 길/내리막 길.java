import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int maxY, maxX;
    static int[][] graph;
    static int[][] dp;
    static int[] moveY = {-1, 1, 0, 0}, moveX = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arrSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        maxY = arrSize[0];
        maxX = arrSize[1];

        graph = new int[maxY][maxX];
        dp = new int[maxY][maxX];

        for (int i = 0; i < maxY; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(dp[i], -1); // dp 배열을 -1로 초기화
        }

        System.out.println(bfs(0, 0));
    }

    private int bfs(int y, int x) {
        if (y == maxY - 1 && x == maxX - 1) {
            return 1; // 도착 지점에 도달하면 1을 반환
        }

        if (dp[y][x] != -1) {
            return dp[y][x]; // 이미 계산한 위치면 결과 반환
        }

        dp[y][x] = 0; // 초기값 설정

        for (int i = 0; i < 4; i++) {
            int nextY = y + moveY[i];
            int nextX = x + moveX[i];

            if (nextY >= 0 && nextX >= 0 && nextY < maxY && nextX < maxX) {
                if (graph[nextY][nextX] < graph[y][x]) {
                    dp[y][x] += bfs(nextY, nextX);
                }
            }
        }

        return dp[y][x];
    }
}
