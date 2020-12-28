package data_structures;

public class Stacks {
    SNode first = null;
    SNode last = null;
    int size = 0;

    public void push(Object data){
        SNode newNode = new SNode(data);
        if(first == null){
            first = newNode;
        } else {
            SNode temp = first;
            first = newNode;
            first.setNext(temp);
        }
        size++;
    }
    public void pop(){
        if(first!=null){
            if(size == 1){
                first = null;
                last = null;
            } else {
                SNode popped = first;
                first = first.getNext();
                popped.setNext(null);
            }
            size--;
        }
    }
}

class SNode {
    private Object data;
    private SNode next = null;

    public SNode(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public SNode getNext() {
        return next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(SNode next) {
        this.next = next;
    }
}