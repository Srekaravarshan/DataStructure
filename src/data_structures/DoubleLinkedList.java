package data_structures;

class Main{

	public static void main(String[] args) {
		DoubleLinkedList list = new DoubleLinkedList();

		list.push(1);
		list.push(2);

		list.printAllItems();

		list.pop();

		list.printAllItems();
	}
}

public class DoubleLinkedList {
	DLLNode head = null;
	DLLNode tail = null;
	int length = 0;

	public void printAllItems(){
		DLLNode dllNode = this.head;
		while(dllNode != null){
			System.out.println(dllNode.getData());
			dllNode = dllNode.getNext();
		}
	}

	public void push(Object data){
		DLLNode node = new DLLNode(data);
		if(length == 0){
			head = node;
		} else {
			tail.setNext(node);
			node.setPrevious(tail);
		}
		tail = node;
		length++;
	}

	public void pop(){
		if(length == 0) return;
		if(length == 1) {
			head = null;
			tail = null;
		} else {
			DLLNode popped = tail;
			tail = popped.getPrevious();
			popped.setPrevious(null);
			tail.setNext(null);
		}
		length--;
	}
}

class DLLNode {
	private Object data;
	private DLLNode next = null;
	private DLLNode previous = null;

	public DLLNode(Object data) {
		this.data = data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public void setPrevious(DLLNode previous) {
		this.previous = previous;
	}

	public DLLNode getNext() {
		return next;
	}

	public DLLNode getPrevious() {
		return previous;
	}

	public Object getData() {
		return data;
	}
}