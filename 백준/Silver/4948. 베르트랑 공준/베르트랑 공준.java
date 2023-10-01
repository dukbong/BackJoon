import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
        	int n = Integer.parseInt(br.readLine());
        	if(n == 0) {
        		break;
        	}
        	int count = findSosu(n);
        	sb.append(count).append("\n");
        }
        
        System.out.println(sb.toString());
    }

	private int findSosu(int n) {
		int count = 0;
		for(int i = n + 1; i <= n*2; i++) {
			boolean check = checkSosu(i);
			if(check) {
				count++;
			}
		}
		return count;
	}

	private boolean checkSosu(int i) {
		if(i == 1) {
			return false;
		}
		if(i == 2 || i == 3) {
			return true;
		}
		for(int j = 2; j <= Math.sqrt(i); j++) {
			if(i % j == 0) {
				return false;
			}
		}
		return true;
	}

}