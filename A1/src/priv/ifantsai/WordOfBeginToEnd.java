package priv.ifantsai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 给定两个单词beginWord和endWord， 还有一本词典是list类型。
 * 找到所有从beginWord变到endWord的最短转换路径， 变动的规则是：
 * 1， 一次只能变一个位置的字符
 * 2， 每一个转换后的word一定要在list中
 * 3， 初始时list中没有beginWord这个词
 * 比如
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 返回：
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]注
 * 意：
 * 1， 返回值的类型为List<List<String>>
 * 2， 如果不存在转化路径请返回空链表（不是null）
 * 3， 所有的词一定都是相同长度的
 * 4， 所有词都是小写的a~z
 * 5， 在list中没有重复的词
 * 6， beginWord和endWord都不是空字符串或者null
 */
public class WordOfBeginToEnd {
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = 
				Arrays.asList(new String[] { beginWord, "hot", "dot", "dog", "lot", "log", "cog"});
		List<List<String>> res = getShortestPaths(beginWord, endWord, wordList);
		
//		for (List<String> list : res) {
//			for (String str : list) {
//				System.out.print(str + " ");
//			}
//			System.out.println();
//		}
		// 输出最短路径
		System.out.println(res.size() == 0 ? 0 : res.get(0).size());
		
		
	}
	
	public static List<List<String>> getShortestPaths(String beginWord, 
			String endWord, List<String> wordList) {
		// 获取包括beginWord在内的wordList的各节点的邻接表
		HashMap<String,List<String>> nexts = getNexts(wordList);
		// bfs，获取各节点到beginWord的最短距离表 
		HashMap<String, Integer> distances = getDistances(beginWord, nexts);
		List<String> pathList = new ArrayList<>();
		List<List<String>> res = new ArrayList<>();
		// dfs，获取所有最短路径
		getShortestPaths(beginWord, endWord, nexts, distances, pathList, res);
		return res;
	}
	

	public static void getShortestPaths(String cur, String end, 
			HashMap<String, List<String>> nexts,
			HashMap<String, Integer> distances, 
			List<String> pathList, List<List<String>> res) {
		pathList.add(cur);
		if (end.equals(cur)) {
			res.add(new LinkedList<String>(pathList));
		} else {
			for (String next : nexts.get(cur)) {
				if (distances.get(next) == distances.get(cur) + 1) {
					getShortestPaths(next, end, nexts, distances, pathList, res);
				}
			}
		}
		pathList.remove(pathList.size() - 1);
	}

	public static HashMap<String, Integer> getDistances(String beginWord, HashMap<String, List<String>> nexts) {
		HashMap<String, Integer> distanceMap = new HashMap<>();
		distanceMap.put(beginWord, 0);
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		HashSet<String> set = new HashSet<>();
		set.add(beginWord);
		while (!queue.isEmpty()) {
			String cur = queue.poll();
			List<String> next = nexts.get(cur);
			for (String str : next) {
				if (!set.contains(str)) {
					distanceMap.put(str, distanceMap.get(cur) + 1);
					set.add(str);
					queue.add(str);
				}
			}
		}
		return distanceMap;
	}

	public static HashMap<String, List<String>> getNexts(List<String> wordList) {
		HashSet<String> wordSet = new HashSet<>(wordList);
		HashMap<String, List<String>> nextMap = new HashMap<>();
		for (String str : wordSet) {
			nextMap.put(str, getNext(str, wordSet));
		}
		return nextMap;
	}

	
	public static List<String> getNext(String str, HashSet<String> wordSet) {
		char[] chs = str.toCharArray();
		List<String> res = new ArrayList<>();
		// 这里的时间复杂度为O(26L), 其中L为单词长度
		// 
		for (int i = 0; i < chs.length; i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (ch != chs[i]) {
					char t = chs[i];
					chs[i] = ch;
					if (wordSet.contains(String.valueOf(chs))) {
						res.add(String.valueOf(chs));
					}
					chs[i] = t;
				}
			}
		}
		return res;
	}
} 
