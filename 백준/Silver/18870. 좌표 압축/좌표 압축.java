import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        ArrayList<Integer> list = Arrays.stream(arr).boxed().distinct().collect(Collectors.toCollection(ArrayList<Integer>::new));
        Collections.sort(list);

        // 인덱스로 왔다갔다 보다 빠른지 보기 위함.
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int i : list) {
        	if(!map.containsKey(i)) {
        		map.put(i, rank);
        		rank++;
        	}
        }
        
        for(int i = 0; i < num; i++) {
//        	sb.append(list.indexOf(arr[i])).append(" ");
        	sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb.toString());
        
    }
}