package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _771_Jewels_and_Stones {
	 public static int numJewelsInStones(String J, String S) {
	        Set<Character> set = new HashSet<Character>();
	        for (int i = 0; i < J.length(); i++) {
	        	set.add(J.charAt(i));
	        }
	        int count = 0;
	        for (int i = 0; i < S.length(); i++) {
	        	if (set.contains(S.charAt(i))) {
	        		count++;
	        	}
	        }
	        return count;
	 }
	 
	 public static void main(String[] args) {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(numJewelsInStones("z", "ZZ"));
	}
}
