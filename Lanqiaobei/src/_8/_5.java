package _8;

import java.util.HashMap;
import java.util.Scanner;

public class _5 {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		 String[] strs = new String[n];
		 for (int i = 0; i < n; i++) {
			 strs[i] = sc.next();
		 }
		 for (int i = 0; i < n; i++) {
			 System.out.println(dfs(strs[i].toCharArray()));
		 }
		
	}

	public static int process(char[] chs) {
		if (String.valueOf(chs).contains("LOL")) return -1;   // 轮到我方时已经出现LOL, 则我方输
		if (!String.valueOf(chs).contains("*"))  return 0;    // 轮到我方时没有出现LOL且没有空格了, 则平手
		boolean ping = false;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == '*') {
				chs[i] = 'L';            // 尝试填L
				switch (process(chs)) {
				case -1: 
					chs[i] = '*';   return 1;
				case 0:
					ping = true;
				}
				
				chs[i] = 'O';          // 尝试填O
				switch (process(chs)) {
				case -1:
					chs[i] = '*';   return 1;
				case 0:
					ping = true;
				}
				chs[i] = '*';
			}
		}
		if (ping)  return 0;
		return -1;
	}
	
	
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	public static int dfs(char[] chs) {
		// base case
		if (String.valueOf(chs).contains("LOL"))  return -1;
		if (!String.valueOf(chs).contains("*"))   return 0;
		
		int tag = -1;   
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] == '*') {
				chs[i] = 'L';
				int t = map.containsKey(String.valueOf(chs)) ? map.get(String.valueOf(chs)) : dfs(chs);
				try {
					if (t == -1) {
						chs[i] = '*';
						map.put(String.valueOf(chs), 1);
						return 1;
					}
					if (t == 0) tag = 0;
				} finally {
					chs[i] = '*';
				}
				
				chs[i] = 'O';
				t =  map.containsKey(String.valueOf(chs)) ? map.get(String.valueOf(chs)) : dfs(chs);
				try {
					if (t == -1) {
						chs[i] = '*';
						map.put(String.valueOf(chs), 1);
						return 1;
					}
					if (t == 0) tag = 0;  
				} finally {
					chs[i] = '*';
				}
			}
		}
		map.put(String.valueOf(chs), tag);
		return tag;
	}
	
	
}
