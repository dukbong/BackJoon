import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		
		int five = N / 5;
		if(N % 5 == 0) {
			result = five;
		}else {
			while(true) {
				int check = 0;
				if(five > 0) {					
					check = N - (5 * five);
				}else {
					check = N;
				}
				if(check % 3 == 0) {
					result = five + (check / 3);
					break;
				}else if(five > 0) {
					five --;
				}else if (five == 0 && check % 3 != 0) {
					result = -1;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
