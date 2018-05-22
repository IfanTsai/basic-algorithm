package _8;

import java.util.Scanner;

public class _4 {
	
	public static String solve(String[] ins) {
		int calc = 0;
		int s = 10;
		int res = Integer.parseInt(ins[1].split(" ")[1]);
		for (int i = 1; i < ins.length - 1; i++) {
			if (ins[i].startsWith("CHANGE")) {
				s = Integer.parseInt(ins[i].split(" ")[1]);
			} else if (ins[i].startsWith("ADD")) {
				calc = 1;
			} else if (ins[i].startsWith("SUB")) {
				calc = 2;
			} else if (ins[i].startsWith("MUL")) {
				calc = 3;
			} else if (ins[i].startsWith("DIV")) {
				calc = 4;
			} else if (ins[i].startsWith("MOD")) {
				calc = 5;
			} else if (ins[i].startsWith("NUM")) {
				int num = Integer.parseInt(ins[i].split(" ")[1], s);
				switch (calc) {
				case 1:
					res += num;
					break;
				case 2:
					res -= num;
					break;
				case 3:
					res *= num;
					break;
				case 4:
					res /= num;
					break;
				case 5:
					res %= num;
					break;
				}
			}
		}
		return Integer.toString(res, s);
	}
	
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] ins = new String[n];
		sc.nextLine();
		for (int i = 0; i < ins.length; i++) {
			ins[i] = sc.nextLine();
		}
		
		System.out.println(solve(ins));
	}
}
