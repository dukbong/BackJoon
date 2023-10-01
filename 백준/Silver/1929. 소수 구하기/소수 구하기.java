import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        for(int i = arr[0]; i <= arr[1]; i++) {
        	boolean check = checkSosu(i);
        	if(check) {
        		sb.append(i).append("\n");
        	}
        }
        System.out.println(sb.toString());
    }

	private boolean checkSosu(int num) {
		
		if(num == 1) {
			return false;
		}
		if(num == 2 || num == 3) {
			return true;
		}
		
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}