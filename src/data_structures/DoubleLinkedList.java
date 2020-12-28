package data_structures;

@SuppressWarnings("unused")
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

	public void shift(){
		if(length == 0) return;
		if(length == 1) {
			head = null;
			tail = null;
		}else{
			DLLNode tempHead = head;
			head = head.getNext();
			head.setPrevious(null);
			tempHead.setNext(null);
		}
		length--;
	}

	public void unShift(Object data){
		DLLNode node = new DLLNode(data);
		if(head == null){
			head = node;
			tail = node;
		} else {
			head.setPrevious(node);
			node.setNext(head);
			head = node;
		}
		length++;
	}

	public DLLNode get(int index){
		if(index<0 || index>= length) return null;
		DLLNode node;
		if(index <= length/2){
			node = head;
			for (int i = 0; i< index; i++){
				node = node.getNext();
			}
		} else {
			node = tail;
			index = length - index -1;
			for (int i = 0; i< index; i++){
				node = node.getPrevious();
			}
		}
		return node;
	}

	public void set(int index, Object data){
		if(index < 0 || index >= length) return;
		DLLNode foundNode = get(index);
		foundNode.setData(data);
	}

	public void insert(int index, Object data){
		if (index >= 0 && index < length) {
			if(index == 0){ unShift(data);}
			else if(index == length-1){ push(data);}
			else{
				DLLNode node = get(index);
				DLLNode previous = node.getPrevious();
				DLLNode newNode = new DLLNode(data);

				previous.setNext(newNode);
				newNode.setPrevious(previous);
				newNode.setNext(node);
				node.setPrevious(newNode);

				length++;
			}
		}
	}

	public void remove(int index){
		if(index >= 0 && index < length){
			if(index == 0) {
				shift();
			}else if (index == length-1){
				pop();
			}else{
				DLLNode node = get(index);
				node.getPrevious().setNext(node.getNext());
				node.getNext().setPrevious(node.getPrevious());
				node.setPrevious(null);
				node.setNext(null);
				length--;
			}
		}
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