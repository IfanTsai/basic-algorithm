import java.util.HashMap;
import java.util.Scanner;

public class 高僧斗法 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		String[] ss = line.split(" ");
		int[] monks = new int[ss.length];
		for (int i = 0; i < monks.length; i++) {
			monks[i] = Integer.parseInt(ss[i]);
		}
		
		solve(monks);		
	
	}
	
	public static void solve(int[] monks) {
		for (int i = 0; i < monks.length - 1; i++) {
			for (int j = monks[i] + 1; j < monks[i + 1]; j++) {
				int old = monks[i];
				monks[i] = j;
				if (nimi(monks)) {
					System.out.println(old + " " + j);
					return;
				}
				monks[i] = old; 
			}
		}
	    System.out.println(-1);
	}
	
	// 尼姆堆的解法
	public static boolean nimi(int[] monks) {
		int[] nimis = new int[monks.length / 2];
		for (int i = 0; i < nimis.length; i++) {
			nimis[i] = monks[2 * i + 1] - monks[2 * i] - 1;
		}
		int res = 0;
		for (int i = 0; i < nimis.length; i++) {
			res ^= nimis[i];
		}
		if (res == 0) {
			return true;
		}
		return false;
	}

	
	static HashMap<String, Boolean> map = new HashMap<String, Boolean>();
	public static boolean dfs(int[] monks) {
		for (int i = 0; i < monks.length - 1; i++) {
			for (int j = monks[i] + 1; j < monks[i + 1]; j++) {
				int old = monks[i];
				monks[i] = j;
				try {
					boolean b = map.containsKey(convert(monks)) ? map.get(convert(monks)) : dfs(monks);
					if (!b) {
						monks[i] = old;
						map.put(convert(monks), true);
						return true;
					}
				} finally {
					monks[i] = old;
				}
			}
		}
		map.put(convert(monks), false);
		return false;
	}
	
	public static String convert(int[] monks) {
		String res = new String();
		for (int i = 0; i < monks.length; i++) {
			res += (monks[i] + "_");
		}
		
		return res;
	}
}
