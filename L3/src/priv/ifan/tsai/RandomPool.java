package priv.ifan.tsai;

import java.util.HashMap;

/*
 * 设计RandomPool结构
 * 
 * 题目:
 * 设计一种结构,在该结构中有如下三个功能:
 * insert(key): 将某个key加入到该结构,做到不重复加入
 * delete(key): 将原本在结构中的某个key移除
 * getRandom(): 等概率随机返回结构中的任何一个key
 * 
 * 要求:
 * insert, delete, getRandom方法的时间复杂度都是O(1)
 */
public class RandomPool {
	/*
	 * 建立两张哈希表,第一张以key和索引作为键值对,第二张以索引和key作为键值对
	 * 在未进行删除操作情况下,索引是连续分布的,利用Math.random即可等概率随机返回
	 * 当进行删除操作后,为了仍然保持索引的连续,将最后一个元素填入删除的部分
	 */
	private HashMap<String, Integer> map1;
	private HashMap<Integer, String> map2;
	private int size;
	
	public void insert(String key) {
		map1.put(key, size++);
		map2.put(size - 1, key);
	}
	
	public void delete(String key) {
		Integer deleteIndex = map1.get(key);
		map1.remove(key);
		map2.remove(deleteIndex);
		
		/*
		 * 将最后一个key填入删除的部分,以至于key对于的索引仍然是连续分布的
		 */
		String lastKey = map2.get(size - 1);
		map1.put(lastKey, deleteIndex);
		map2.put(deleteIndex, lastKey);
		size--;
	}
	
	public String getRandom() {
		int randomIndex = (int) (Math.random() * size);
		return map2.get(randomIndex);
	}
}
