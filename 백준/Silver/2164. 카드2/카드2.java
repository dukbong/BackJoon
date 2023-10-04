import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		new Main().solution();
	}
	
	private void solution() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= num; i++){
			queue.offer(i);
		}
		while(queue.size() != 1){
			queue.poll(); // 가장 윗장을 버린다.
			int lastItem = queue.poll();
			((LinkedList<Integer>) queue).addLast(lastItem);

		}
		System.out.println(queue.poll());
	}
}