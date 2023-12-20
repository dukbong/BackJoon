import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] checking;
	static int targetStart, targetEnd;
	static int result = 0;
	static int[] line;
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int person = Integer.parseInt(br.readLine());
		int[] target = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		targetStart = target[0];
		targetEnd = target[1];
		int nodeCount = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= person; i++){
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < nodeCount; i++){
			int[] relationShip = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			list.get(relationShip[0]).add(relationShip[1]);
			list.get(relationShip[1]).add(relationShip[0]);
			
		}
		
		checking = new boolean[person + 1];
		line = new int[person + 1];
		searching(targetStart);
		
		System.out.println( line[targetEnd] == 0 ? -1 : line[targetEnd] );
	}

	private void searching(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()){
			int now = queue.poll();
			if(now == targetEnd) return;
			int size = list.get(now).size();
			for(int i = 0; i < size; i++){
				int connectionPoint = list.get(now).get(i);
				if(!checking[connectionPoint]){
					result++;
					checking[connectionPoint] = true;
					line[connectionPoint] = line[now] + 1;
					queue.offer(connectionPoint);
				}
			}
		}
		result = -1;
	}

}

/*

사람수
문제 ( a,b 는 몇촌 관계냐 )
부모 자식들 간의 관계의 개수 m
9
7 3
7
1 2
1 3
2 7
2 8
2 9
4 5
4 6


3
*/
