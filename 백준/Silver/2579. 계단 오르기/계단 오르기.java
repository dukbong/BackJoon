import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[] points;

	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		
		int[] test = new int[total + 1];
		points = new int[total + 1];
		
		for(int i = 1; i < total + 1; i++){
			points[i] = Integer.parseInt(br.readLine());
		}
		
		test[1] = points[1];
		
		if(total >= 2){
			test[2] = points[1] + points[2];
		}
		
		System.out.println(testMethod(test, points, total));
	}

	private int testMethod(int[] test, int[] points, int total) {
		if(test[total] == 0 && total != 0){
			test[total] = Math.max(testMethod(test, points, total - 2), testMethod(test, points, total - 3) + points[total - 1]) + points[total];
		}
		return test[total];
	}
}
