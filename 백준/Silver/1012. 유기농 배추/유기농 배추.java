import java.util.*;
import java.io.*;

public class Main {

	static int[][] arr;
	static boolean[][] bArr;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ySize;
	static int xSize;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// input
		int totalRange = Integer.parseInt(br.readLine());
		int[][][] tArr = new int[totalRange][][];
		int[] pickLocation = new int[totalRange];
		List<int[]> locationList = new ArrayList<>();
		int tArrCount = 0;
		
		// input info
		String str = "";
		 while ((str = br.readLine()) != null) {
			int[] q = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
			if (q.length == 3) {
				tArr[tArrCount] = new int[q[0]][q[1]];
				pickLocation[tArrCount] = q[2];
				tArrCount++;
			} else {
				locationList.add(new int[] { q[0], q[1] });
			}
		}

		 // location fixed
		for (int i = 0; i < totalRange; i++) {
			for (int j = 0; j < pickLocation[i]; j++) {
				tArr[i][locationList.get(j)[0]][locationList.get(j)[1]] = 1;
			}
			locationList = locationList.subList(pickLocation[i], locationList.size());
		}
		
		// search
		for (int i = 0; i < totalRange; i++) {
			int count = 0;
			ySize = tArr[i].length;
			xSize = tArr[i][0].length;
			bArr = new boolean[ySize][xSize];
			arr = tArr[i];
			for (int j = 0; j < tArr[i].length; j++) {
				for (int k = 0; k < tArr[i][j].length; k++) {
					if(tArr[i][j][k] == 1 && !bArr[j][k]){
						count++;
						bArr[j][k] = true;
						dfs(j,k);
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);

	}

	private void dfs(int y, int x) {
		for (int i = 0; i < 4; i++) {
			int nowY = y + dy[i];
			int nowX = x + dx[i];

			if (nowX >= 0 && nowY >= 0 && nowX < xSize && nowY < ySize && !bArr[nowY][nowX] && arr[nowY][nowX] == 1) {
				bArr[nowY][nowX] = true;
				dfs(nowY, nowX);
			}
		}
	}
}