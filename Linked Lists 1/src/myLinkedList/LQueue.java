package myLinkedList;
class LQueue<E>{
	private Link<E> front; // Pointer to front queue node
	private Link<E> rear; // Pointer to rear queuenode
	private int size; // Number of elements in queue
	/** Constructors */
	public LQueue() { init(); }
	public LQueue(int size) { init(); } // Ignore size
	/** Initialize queue */
	private void init() {
		front = rear = new Link<E>(null);
		size = 0;
	}
	/** Reinitialize queue */
	public void clear() { init(); }
	/** Put element on rear */
	public void enqueue(E it) {
		rear.setNext(new Link<E>(it, null));
		rear = rear.next();
		size++;
	}
	/** Remove and return element from front */
	public E dequeue() {
		assert size != 0 : "Queue is empty";
		E it = front.next().element(); // Store dequeued value
		front.setNext(front.next().next()); // Advance front
		if (front.next() == null) rear = front; // Last Object
		size--;
		return it; // Return Object
	}
	/** @return Front element */
	public E frontValue() {
		assert size != 0 : "Queue is empty";
		return front.next().element();
	}
	/** @return Queue size */
	public int length() { return size; }
	
	
	public void enqueueFront(E it){
		front.setNext(new Link<E>(it, front.next()));
		size++;
	}
	public E dequeueRear(){
		assert size != 0 : "Queue is empty";
		E it = rear.element(); // Store dequeued value
		Link<E> temp = last();
		temp.setNext(null);
		rear = temp;// Advance front
		if (rear == null) front = rear; // Last Object
		size--;
		return it; // Return Object
	}
	
	public Link<E> last(){
		Link<E> temp = new Link<E>(front);
		for(int i = 0; i < size; i++){
			temp = temp.next();
		}
		return temp;
	}
}