package myLinkedList;

public class LQueueRunner {

	public static void main(String[] args) {
		LQueue lq = new LQueue();
		for(int i = 0; i < 10; i++){
			lq.enqueue("" + i);
		}
		lq.enqueueFront("bob");
	
		for(int i = 0; i < 11; i++){
		System.out.println(lq.dequeueRear());
		}
		/*
		for(int i = 0; i < 8; i++){
			System.out.println(lq.dequeue());
		}
		*/
	}

}
