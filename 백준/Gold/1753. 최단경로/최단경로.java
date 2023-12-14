import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	
	static List<List<Node>> list;
	static int[] dist; // 정점간의 이동 회수
	static int V,E,start;  // 정점의 개수, 간선의 개수, 시작점
	
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}
	
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 점정의 개수와 노드의 개수
		int[] pointAndNode = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		V = pointAndNode[0];
		
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		list = new ArrayList<>();
		for(int i = 0; i <= V; i++){
			list.add(new ArrayList<>());
		}
		
		start = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < pointAndNode[1]; i++){
			int[] startAndEndAndWeight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			list.get(startAndEndAndWeight[0]).add(new Node(startAndEndAndWeight[1], startAndEndAndWeight[2]));
		}
		
		machine(start);
		
		for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE){
            	sb.append("INF\n");
            } else {
            	sb.append(dist[i] + "\n");
            }
        }
		System.out.println(sb);
	}

	private void machine(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] check = new boolean[V + 1];
		queue.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()){
			Node now = queue.poll();
			int nowEnd = now.index;
			
			if(check[nowEnd]){
				continue;
			}
			
			check[nowEnd] = true;
			for(Node node : list.get(nowEnd)){
				if(dist[node.index] > dist[nowEnd] + node.cost){
					dist[node.index] = dist[nowEnd] + node.cost;
					queue.add(new Node(node.index, dist[node.index]));
				}
			}
		}
	}
}

class Node implements Comparable<Node>{
	int index, cost; // 정점의 번호, 비용
	
	Node(int index, int cost){
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}