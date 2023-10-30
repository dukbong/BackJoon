import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());

		int[][] arr = new int[len][len];

		for (int i = 0; i < len; i++) {
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		machine(0,0, len, arr);
		
		System.out.println(sb);
	}

	private void machine(int y, int x, int len, int[][] arr) {
		
		boolean check = true;
		
		int target = arr[y][x]; // 가장 왼쪽 상단을 시작 위치로 지정
		
		for(int i = y; i < y + len; i++){
			for(int j = x; j < x + len; j++){
				if(target != arr[i][j]){
					check = false;
				}
			}
		}
		
		if(check){
			sb.append(arr[y][x]);
			return;
		}
		
		// 아닐 경우
		len /= 2; // 길이를 점점 줄이면서 접근한다.
		
		sb.append("(");
		// 이렇게 4가지 경우를 만들면 하나씩 모두 접근할 수 있다.
		machine(y, x, len, arr);
		machine(y, x + len, len, arr);
		machine(y + len, x, len, arr);
		machine(y + len, x + len, len, arr);
		sb.append(")");
	}

}