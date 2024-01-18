import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
//		System.out.println(lastFindZero(factory(num)));
		System.out.println(test(num));
	}

	private int test(int num) {
		int result = 0;
		while(num >= 5){
			result += num / 5;
			num = num / 5;
		}
		return result;
	}

//	시간 초과 : 정말 단순하게
//	private int lastFindZero(int factory) {
//		int count = 0;
//		while (factory % 10 == 0) {
//			count++;
//			factory = factory / 10;
//		}
//		return count;
//	}
//
//	private int factory(int num) {
//		if (num == 1) {
//			return 1;
//		}
//		return num * factory(num - 1);
//	}
}