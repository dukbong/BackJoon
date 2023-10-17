import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().solution();
	}

	// 1차 메모리 초과
	private void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = "";
		while ((str = br.readLine()) != null) {
			int len = (int) Math.pow(3, Integer.parseInt(str));
			List<Integer> list = new LinkedList<>();
			String result = change(len, list);
			sb.append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	private String change(int len, List<Integer> list) {
		if (len == 1) {
			StringBuilder sbb = new StringBuilder();
			if (list.size() == 0) {
				return "-";
			}
			for (int i = 0; i < list.size(); i++) {
				if ((i + 1) % 2 == 0) {
					int count = list.get(i);
					for (int j = 0; j < count; j++) {
						sbb.append(" ");
					}
				} else {
					sbb.append("-");
				}
			}
			return sbb.toString();
		} else {
			if (list.size() == 0) {
				for (int i = 0; i < 3; i++) {
					int x = len / 3;
					list.add(x);
				}
			} else {
				Map<Integer, Integer[]> map = new TreeMap<>((o1, o2) -> o2 - o1);
				for (int i = 0; i < list.size(); i++) {
					if ((i + 1) % 2 != 0) {
						int x = list.get(i) / 3;
						map.put(i, new Integer[] { x, x, x });
					}
				}
				for (Map.Entry<Integer, Integer[]> m : map.entrySet()) {
					list.remove((int) m.getKey());
					Arrays.stream(m.getValue()).forEach(i -> {
						list.add(m.getKey(), i);
					});
				}
			}
			return change(len / 3, list);
		}
	}

}