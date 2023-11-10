
public class TestQueue {
	public static void main(String[] args) {
		//Code created by J. Alan Wallace 2/9/2022 CS226
		Queue newQ = new Queue();
		for(int control = 1; control <=20; control++) {
			newQ.enqueue(control);
		}//Puts the numbers 1-20 in the queue
		for(int control = 20; control >= 1; control--) {
			System.out.println(newQ.dequeue());
		}//Removes the numbers 1-20 from the queue
	}//End main
}//End TestQueue

class Queue{
	private int[] queue;
	private int size;
	public static final int DEFAULT_CAPACITY = 8;
	
	public Queue(){
		this(DEFAULT_CAPACITY);
	}//End default constructor
	
	public Queue(int capacity) {
		queue = new int[capacity];
	}//End constructor
	
	public void enqueue (int v){
		if(size >= queue.length) {
			int temp[] = new int[queue.length * 2];
			System.arraycopy(queue, 0, temp, 0, queue.length);
			queue = temp;
		}
		queue[size] = v;
		size++;
	}//End Enqueue
	
	public int dequeue(){
		int toReturn = queue[0];
		for(int control = 0; control < (queue.length-1); control++) {
			queue[control] = queue[control+1];
		}
		queue[queue.length-1] = 0;
		size--;
		return toReturn;//Returns the first value in queue, then shifts every value forward one space to fill the gap
	}//End Dequeue
	
	public boolean empty() {
		if(queue[0] != 0) {
			return false;
		}else {
			return true;
		}
	}//End empty
	
	public int getSize() {
		return size;
	}//End getSize	
}//End Queue

/*
Test Output:
<terminated> TestQueue [Java Application] C:\Program Files\Java\jdk-16.0.2\bin\javaw.exe (Feb 10, 2022, 12:30:21 PM - 12:30:21 PM)
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
*/