package data_structures;


public class SingleLinkedList {

	private int length = 0;
	private LLNode head = null;
	private LLNode tail = null;

	public int length() {
		return length;
	}

	public void printAllItems(){
		LLNode tempLLNode = this.head;
		while(tempLLNode != null){
			System.out.println(tempLLNode.getData());
			tempLLNode = tempLLNode.next();
		}
	}

	public SingleLinkedList push(Object data){
		LLNode tempLLNode = new LLNode(data);
		if(head == null){
			head = tempLLNode;
			tail = head;
		}else{
			tail.setNext(tempLLNode);
			tail = tempLLNode;
		}
		length++;
		return this;
	}

	public SingleLinkedList pop(){
		if(head == null){
			return this;
		}
		LLNode endOfList = head;
		LLNode newTail = endOfList;
		while(endOfList.next() != null){
			newTail = endOfList;
			endOfList = endOfList.next();
		}
		tail = newTail;
		tail.setNext(null);
		length--;
		if(length == 0){
			head = null;
			tail = null;
		}
		return this;
	}

	public SingleLinkedList shift(){
		if(head == null){
			return this;
		}
		head = head.next();
		length--;
		return this;
	}

	public SingleLinkedList unShift(Object data){
		if(head == null){
			head = new LLNode(data, null);
			this.tail = head;
		} else {
			head = new LLNode(data, head);
		}
		length++;
		return this;
	}

	public LLNode get(int index){
		if(index < 0 || index >= length) return null;
		LLNode LLNode = head;
		for (int i = 0; i < index; i++) {
			LLNode = LLNode.next();
		}
		return LLNode;
	}

	public boolean set(int index, Object data){
		LLNode foundLLNode = get(index);
		if (foundLLNode != null) {
			foundLLNode.setData(data);
			return true;
		};
		return false;
	}

	public boolean insert(int index,  Object data){
		if (index > length || index < 0) return false;
		if(index == 0) {
			unShift(data);
			return true;
		}
		if(index == length) {
			push(data);
			return true;
		}
		LLNode previousLLNode = get(index-1);
		LLNode nextLLNode = previousLLNode.next();
		previousLLNode.setNext(new LLNode(data, nextLLNode));
		length++;
		return true;
	}

	public boolean remove(int index){
		if(index < 0 || index >= length) return false;
		if(index == 0) {
			shift();
			return true;
		}
		if (index == length-1){
			pop();
			return true;
		}
		LLNode previousLLNode = get(index-1);
		LLNode currentLLNode = previousLLNode.next();
		previousLLNode.setNext(currentLLNode.next());
		length--;
		return true;
	}

	public SingleLinkedList reverse(){
		LLNode LLNode = head;
		head = tail;
		tail = LLNode;
		LLNode next;
		LLNode previous = null;

		for (int i=0; i < length; i++){
			next = LLNode.next();
			LLNode.setNext(previous);
			previous = LLNode;
			LLNode = next;
		}

		return this;
	}

}

class LLNode {
	private Object data = null;
	private LLNode next = null;

	public LLNode(Object data) {
		this.data = data;
	}

	public LLNode(Object data, LLNode next) {
		this.data = data;
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public LLNode next() {
		return next;
	}

	public void setNext(LLNode next) {
		this.next = next;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean hasNext(){
		return next != null;
	}
}
