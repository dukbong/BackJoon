import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    private void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            String key = String.valueOf(str.charAt(i));
            if(map.get(key) == null){
                map.put(key, 1);
            }else{
                map.replace(key, map.get(key) + 1);
            }
        }
        
        List<String> list = new ArrayList<>();
        
        int max = Collections.max(map.values()); // Max Value
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        
        System.out.println(list.size() == 1?list.get(0):"?");
    }
}