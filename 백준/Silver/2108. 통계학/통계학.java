import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);

		Arrays.stream(arr).forEach(i -> {
			if (map.containsKey(i)) {
				map.replace(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		});

		// map 정렬
		ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue()); // 내림 차순
			}
		});
		
		Map<Integer, Integer> reverseMap = new LinkedHashMap<>();
		list.stream().forEach(i -> reverseMap.put(i.getKey(), i.getValue()));
		
		Map.Entry<Integer, Integer> mm = reverseMap.entrySet().iterator().next();
		int maxValue = mm.getValue();
		
		ArrayList<Integer> test = new ArrayList<>();
		for(Map.Entry<Integer, Integer> mmm : reverseMap.entrySet()){
			if(mmm.getValue() == maxValue){
				test.add(mmm.getKey());
			}
		}
		
		Collections.sort(test);
		double ssAvgRe = Arrays.stream(arr).sum() / (arr.length * 1.0);
		long ssAvg =  ssAvgRe < 0 ? Math.round(ssAvgRe * -1) * -1:Math.round(ssAvgRe);
		int middle = arr[arr.length / 2];
		int cbValue = test.size() == 1?test.get(0):test.get(1);
		int range = arr[arr.length - 1] - arr[0];
		
		System.out.println(ssAvg);
		System.out.println(middle);
		System.out.println(cbValue);
		System.out.println(range);
	}
}