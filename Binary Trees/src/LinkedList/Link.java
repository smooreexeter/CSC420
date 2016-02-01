package LinkedList;
	
/** Singly linked list node */
class Link<E> {
	private E element;
	private int x;
	private int y;// Value for this node
	private Link<E> next; // Pointer to next node in list
	// Constructors
	Link(E it, int xt, int yt, Link<E> nextval)
	{ element = it; x = xt; y = yt; next = nextval; }
	Link(Link<E> nextval) { next = nextval; }
	Link<E> next() { return next; } // Return next field
	Link<E> setNext(Link<E> nextval) // Set next field
	{ return next = nextval; } // Return element field
	E element() { return element; } // Set element field
	String getFullElement(){
		return element + " (" + x + ", " + y + ")";
	}
	int getX() { return x;}
	int getY() { return y;}
	E setElement(E it) { return element = it; }
}
