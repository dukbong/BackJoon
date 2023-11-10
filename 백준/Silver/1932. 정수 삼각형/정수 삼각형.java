import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int triangleSize = Integer.parseInt(br.readLine());

		long[][] resultArr = new long[triangleSize][]; // col에 대한 길이 제약이 없는 것을
														// 만든다.
		resultArr[0] = new long[] { Integer.parseInt(br.readLine()) };
		for (int i = 1; i < triangleSize; i++) {

			if (i == 1) {
				// 2번째 row까지는 단순하게 모든 노드가 더해지기 때문에 그냥 더한다.
				int[] allSumRow = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				resultArr[i] = new long[] { allSumRow[0] + resultArr[0][0], allSumRow[1] + resultArr[0][0] };

			} else {
				// 3번째 row부터는 이전 row의 길이만큼 반복하며 현재 배열의 이전 row의 인덱스와 이전 row의 인덱스
				// + 1 중 더 큰값을 찾아 더해준다.
				resultArr[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

				resultArr[i][0] += resultArr[i - 1][0];
				resultArr[i][resultArr[i].length - 1] += resultArr[i - 1][resultArr[i - 1].length - 1];
				
				for(int j = 1; j < resultArr[i - 1].length; j++){
					
					long max = Math.max(resultArr[i - 1][j - 1], resultArr[i - 1][j]);
					resultArr[i][j] += max;
					
				}

				// resultArr[i][resultArr[i].length - 1] =
				// resultArr[i][resultArr[i].length - 1] + resultArr[i -
				// 1][resultArr[i - 1].length - 1];

			}

		}

//		for (long[] x : resultArr) {
//			System.out.println(Arrays.toString(x));
//		}

		Arrays.sort(resultArr[triangleSize - 1]);
		System.out.println(resultArr[triangleSize - 1][triangleSize - 1]);
	}
}
