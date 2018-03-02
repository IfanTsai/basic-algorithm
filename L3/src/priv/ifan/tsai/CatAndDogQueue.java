package priv.ifan.tsai;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 实现一种猫狗队列的结构,要求如下:
 * 用户可以调用add方法将cat类或dog类的实例放入队列中;
 * 用户可以调用pollAll方法,将队列中所有的实例按照进队列的先后顺序依次弹出;
 * 用户可以调用pollDog方法,将队列中的dog类的实例按照进队列的先后顺序依次弹出;
 * 用户可以调用pollCat方法,将队列中的cat类的实例按照进队列的先后顺序依次弹出;
 * 用户可以调用isEmpty方法,检查队列中是否还有dog或cat类的实例;
 * 用户可以调用isDogEmpty方法,检查队列中是否有dog类的实例
 * 用户可以调用isCatEmpty方法,检查队列中是否有cat类的实例
 */
public class CatAndDogQueue {

	static class Pet {
		private String type;
		
		public Pet(String type) {
			this.type = type;
		}
		
		public String getPetType() {
			return this.type;
		}
	}
	
	static class Dog extends Pet {
		public Dog() {
			super("dog");
		}
	}
	
	static class Cat extends Pet {
		public Cat() {
			super("cat");
		}
	}
	
	
	// 重新封装一下原来的pet类,增加入队序号
	static class PetWithCount {
		private Pet pet;
		int count;  // 入队序号
		
		public PetWithCount(Pet pet, int count) {
			this.pet = pet;
			this.count = count;
		}
		
		public Pet getPet() {
			return pet;
		}
		
		public int getCount() {
			return count;
		}
	}
	
	static class PetQueue {
		private Queue<PetWithCount> catQueue;
		private Queue<PetWithCount> dogQueue;
		private int count;
		
		public PetQueue() {
			catQueue = new LinkedList<PetWithCount>();
			dogQueue = new LinkedList<PetWithCount>();
		}
		
		public void add(Pet pet) {
			if (pet.getPetType().equals("cat")) {
				catQueue.add(new PetWithCount(pet, count++));
			} else {
				dogQueue.add(new PetWithCount(pet, count++));
			}
		}
		
		public Pet pollAll() {
			Pet pet;
			if (catQueue.isEmpty() && dogQueue.isEmpty()) {
				throw new RuntimeException("The pet queue is empty");
			} else if (catQueue.isEmpty()) {
				pet =  dogQueue.poll().getPet();
			} else if (dogQueue.isEmpty()) {
				pet = catQueue.poll().getPet();
			} else {
				if (catQueue.peek().getCount() < dogQueue.peek().getCount()) {
					pet = catQueue.poll().getPet();
				} else {
					pet = dogQueue.poll().getPet();
				}
			}
			return pet;
		}
		
		public Pet pollDog() {
			if (dogQueue.isEmpty()) {
				throw new RuntimeException("The dog queue is empty");
			}
			return dogQueue.poll().getPet();
		}
		
		public Pet pollCat() {
			if (catQueue.isEmpty()) {
				throw new RuntimeException("The cat queue is empty");
			}
			return catQueue.poll().getPet();
		}
		
		public boolean isEmpty() {
			return catQueue.isEmpty() && dogQueue.isEmpty();
		}
		
		public boolean isDogEmpty() {
			return dogQueue.isEmpty();
		}
		
		public boolean isCatEmpty() {
			return catQueue.isEmpty();
		}
	}

	
	public static void main(String[] args) {

	}

}
