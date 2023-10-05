import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] num = Arrays.stream(br.readLine().split(" "))
						  .mapToInt(Integer::parseInt)
						  .toArray();

		// 조회가 아닌 삭제를 할꺼기 떄문에 LinkedList를 사용한다.
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0; i < num[0]; i++){
			list.add(i+1);
		}
		
		// 인덱스로 삭제할꺼기 때문에 -1을 해준다.
		int index = num[1] - 1;
		
		while(!list.isEmpty()){
			if(index < list.size()) { 
				sb.append(list.remove(index)).append(" "); 
			}else {
				index = index % list.size(); 
				sb.append(list.remove(index)).append(" ");
			}
			index += num[1] - 1;
		}
		String str = "<"+String.join(", ",sb.toString().split(" "))+">";
		System.out.println(str);
	}
}