import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9*9];
		
		for(int i = 0, j = 9; i < 9; i++){
			int start = i * j;
			int[] check = Arrays.stream(br.readLine().split(" "))
					            .mapToInt(Integer::parseInt)
					            .toArray();
			for(int k = start, q = 0; k < start + 9; k++, q++){
				arr[k] = check[q];
			}
		}
		
		int max = Arrays.stream(arr).max().getAsInt();
		int point = IntStream.range(0, arr.length)
							 .filter(i -> max == arr[i])
							 .findAny()
							 .orElse(-1);
		int y = point / 9 + 1;
		int x = point % 9 + 1;
		System.out.println(max);
		System.out.println(y + " " + x);
	}
}