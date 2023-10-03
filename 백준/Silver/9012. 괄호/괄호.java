import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
	
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
        	String str = br.readLine().replace(" ", "");
        	boolean check = vpsCheck(str);
        	if(check) {
        		sb.append("YES").append("\n");
        	}else {
        		sb.append("NO").append("\n");
        	}
        }
        System.out.println(sb.toString());
    }

	private boolean vpsCheck(String str) {
		int length = str.length();
		// 1 단계 수가 맞는지.
		if(str.length() % 2 != 0) {
			return false;
		}
		
		// 2 단계 잘 되어 있는지 
		for(int i = 0; i < length; i++) {
			str = str.replace("()","");
			if(str.equals("")) {
				return true;
			}
		}
		return false;
	}
}