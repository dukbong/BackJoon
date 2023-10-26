import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		int result = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[] str = br.readLine().split("-");
		// 최소를 얻기 위해서는 덧셈을 먼저 해줘야 한다.
		for(int i = 0; i < str.length; i++) {
			int sum = 0;
			String[] arr = str[i].split("\\+"); // 정규표현식때문이다.
			for(String num : arr) {
				sum += Integer.parseInt(num);
			}
			if(i == 0) {
				result += sum;
			}else {
				result -= sum;
			}
		}
		System.out.println(result);
	}
}