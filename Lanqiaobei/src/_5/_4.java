package _5;

import java.util.Arrays;
import java.util.Scanner;

public class _4 {
	
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char[] chs = str.toCharArray();
		Arrays.sort(chs);
		permutation(chs, new char[chs.length], new boolean[chs.length], str, 0);
	}
	
	// 暴力dfs思维的全排列
	public static void permutation(char[] chs, char[] per, boolean[] vis, String str, int x) {
	    if (x == chs.length) {
	        // solve
	    	if (String.valueOf(per).equals(str)) {
	    		System.out.println(count);
	    	}
	    	count++;
	        return;
	    }
	    for (int i = 0; i < chs.length; i++) {
	        if (!vis[i]) {
	            vis[i] = true;
	            per[x] = chs[i];
	            permutation(chs, per, vis, str, x + 1);
	            vis[i] = false;
	        }
	    }
	}
}
