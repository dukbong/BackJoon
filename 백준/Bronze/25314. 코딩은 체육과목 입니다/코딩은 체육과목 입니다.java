import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int longCount = num / 4;
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < longCount; i++){
			sb.append("long ");
		}
		sb.append("int");
		System.out.println(sb.toString());
	}
}