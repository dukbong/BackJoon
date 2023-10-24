import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private int[] readLineArr(String str) {
		return Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nCount = Integer.parseInt(br.readLine());
		int[] n = readLineArr(br.readLine());
		int[] op = readLineArr(br.readLine());

		int count = 0;
		for (int i = 0; i < 4; i++) {
			if (op[i] != 0) {
				count += op[i];
			}
		}

		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			if (op[i] != 0) {
				for (int j = 0; j < op[i]; j++) {
					switch (i) {
					case 0:
						list.add("+");
						break;
					case 1:
						list.add("-");
						break;
					case 2:
						list.add("*");
						break;
					case 3:
						list.add("/");
						break;
					}
				}
			}
		}

		boolean[] bool = new boolean[nCount - 1];
		ArrayList<String> arr = new ArrayList<>();
		// 1차 생각 : op의 조합마 신경쓰면 되겠다.
		// 0 : +
		// 1 : -
		// 2 : *
		// 3 : /

		oper(list, new String[count], bool, 0, count, n);
		Collections.sort(result);
		System.out.println(result.get(result.size()-1));
		System.out.println(result.get(0));
	}

	// 순열
	private void oper(ArrayList<String> list, String[] out, boolean[] bool, int depth, int count, int[] n) {
		if (depth == count) {
			machine(out, n);
		}

		for (int i = 0; i < list.size(); i++) {
			if (!bool[i]) {
				bool[i] = true;
				out[depth] = list.get(i);
				oper(list, out, bool, depth + 1, count, n);
				bool[i] = false;
			}
		}
	}

	private void machine(String[] out, int[] n) {
		int start = n[0];
		for (int i = 0; i < n.length -1; i++) {
			switch (out[i]) {
			case "+":
				start += n[i+1];
				break;
			case "-":
				start -= n[i+1];
				break;
			case "*":
				start *= n[i+1];
				break;
			case "/":
				// 조건 음수 일경우
				if(start < 0){
					start *= -1;
					start /= n[i+1];
					start *= -1;
				}else{
					start /= n[i+1];
				}
				break;
			}
		}
		result.add(start);
	}

}