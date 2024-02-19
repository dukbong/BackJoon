import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		new Main().solution();
	}

	private void solution() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < size; i++) {
			String[] arr = br.readLine().split(" ");
			
			switch(arr[0]){
			case "add":
				set.add(arr[1]);
				break;
			case "remove":
				set.remove(arr[1]);
				break;
			case "check":
				if(set.contains(arr[1])) {
					sb.append(1);
				}else {
					sb.append(0);
				}
				sb.append("\n");
				break;
			case "toggle":
				if(!set.remove(arr[1])) set.add(arr[1]);
				break;
			case "empty":
				set.clear();
				break;
			case "all":
				for(int j = 1; j <= 20; j++) set.add(String.valueOf(j));
				break;
			}
		}
		
		System.out.println(sb);
		
	}
	
}