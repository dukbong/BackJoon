import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++){
			String str = br.readLine();
			int count = 0;
			int x = isPalindrome(str, count, sb);
			System.out.println(x + sb.toString());
			sb.setLength(0);
		}
	}

	public int recursion(String s, int l, int r, int c, StringBuilder sb){
		c++;
        if(l >= r){
        	sb.append(" ").append(c);
        	return 1;
        } 
        else if(s.charAt(l) != s.charAt(r)){
        	sb.append(" ").append(c);
        	return 0;
        } 
        else return recursion(s, l+1, r-1, c, sb);
    }
	
    public int isPalindrome(String s, int c, StringBuilder sb){
        return recursion(s, 0, s.length()-1, c, sb);
    }
    /*
    1 2
    1 3
    1 3
    0 2
    0 1
    */
}