import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	
	ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
//		new Main().greedy(); 실패
		
		new Main().backTracking();
		
	}
	
	private void greedy() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] question = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		ArrayList<Integer> card = Stream.of(br.readLine().split(" "))
										.map(Integer::parseInt)
										.collect(Collectors.toCollection(ArrayList::new));
		Collections.sort(card);
		
		int[] result = new int[3];
		
		loop:
		for(int i = card.size() - 1; i >= 0; i--){
			int Max  = question[1];
			int first = card.get(i);
			Max -= first;
			if(Max <= 0){
				Max += first;
				continue;
			}
			
			for(int j = i - 1; j >= 0; j--){
				int second = card.get(j);
				Max -= second;
				if(Max <= 0){
					Max += second;
					continue;
				}
				
				for(int k = j -1; k >= 0; k--){
					int other = card.get(k);
					Max -= other;
					if(Max < 0){
						Max += other;
						continue;
					}
					if(Max >= 0){
						result[0] = card.get(i);
						result[1] = card.get(j);
						result[2] = card.get(k);
						break loop;
					}
				}
			}
		}
		System.out.println(result[0] + result[1] + result[2]);
	}
	
	private void backTracking() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] question = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] card = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		boolean[] visited = new boolean[card.length];
		
		backTrackingCode(card, visited, 0, card.length, 3, question[1]);
//		Optional<Integer> result = resultPackage.stream().filter(i -> question[1] <= i).mapToInt(Integer::intValue).max();
		OptionalInt result = list.stream().mapToInt(Integer::intValue).max();
		
		System.out.println(result.getAsInt());
	}
	private void backTrackingCode(int[] card, boolean[] visited, int start, int cardCount, int count, int max){
		ArrayList<Integer> result = new ArrayList<>();
		// 3개 다 뽑혔을때
		if(count == 0){
			int lineSum = sum(card, visited, cardCount);
			if(lineSum <= max){
				list.add(lineSum);
			}
			return;
		}
		// 뽑는 과정
		for(int i = start; i < cardCount; i++){
			visited[i] = true;
			backTrackingCode(card, visited, i + 1, cardCount, count - 1, max);
			visited[i] = false;
		}
	}
	
	// 다 뽑혔으면 값을 더해주기
	private int sum(int[] card, boolean[] visited, int cardCount){
		int sum = 0;
		for(int i = 0; i < cardCount; i++){
			if(visited[i]){
				sum += card[i];
			}
		}
		return sum;
	}
}