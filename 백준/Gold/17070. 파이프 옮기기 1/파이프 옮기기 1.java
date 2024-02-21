import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	int size, result = 0;
	int arr[][];
	int moveX[] = { 1, 0, 1 };
	int moveY[] = { 0, 1, 1 };

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		arr = new int[size][size];
		for (int i = 0; i < size; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		solve(1, 0, 0);
		System.out.println(result);
	}

	// 0 가로 1 세로 2 대각
    private  void solve(int x, int y, int shape) {
        if (x == size - 1 && y == size - 1) {
            result++;
            return;
        }
        for (int d = 0; d < 3; d++) {
            int newY = y + moveY[d];
            int newX = x + moveX[d];

            if (newY >= size || newX >= size || arr[newY][newX] == 1)
                continue;

            if ((d == 1 && shape == 0) || (d == 0 && shape == 1))
                continue;

            if (d == 2 && (arr[y][x + 1] == 1 || arr[y + 1][x] == 1))
                continue;

            solve(newX, newY, d);
        }
    }

}