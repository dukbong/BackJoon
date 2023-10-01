import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num; i++) {
        	long n = Long.parseLong(br.readLine());
        	long x = findSosu(n);
        	
        	sb.append(x).append("\n");
        }
        System.out.println(sb.toString());
    }

	private long findSosu(long n) {
		boolean check = false;
		
		if(n < 2) {
			return 2;
		}else if(n == 3) {
			return 3;
		}
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(n % i == 0) {
				check = true;
				break;
			}
		}
		if(!check) {
			return n;
		}
		return findSosu(n + 1);
	}
}