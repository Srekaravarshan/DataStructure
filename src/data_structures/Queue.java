package data_structures;

public class Queue<T> {
    QNode<T> first = null;
    QNode<T> last = null;
    int size = 0;

    public void enqueue(T data){
        QNode<T> newNode = new QNode<>(data);
        if(first == null){
            first = newNode;
        }else{
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public T dequeue() {
        if (first != null) {
            QNode<T> popped = null;
            if (size == 1) {
                first = null;
                last = null;
                size--;
                return null;
            } else {
                popped = first;
                first = first.getNext();
                popped.setNext(null);
                size--;
                return popped.getData();
            }
        }
        return null;
    }
}

class QNode<T>{
    T data;
    QNode<T> next = null;

    public QNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public QNode<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(QNode<T> next) {
        this.next = next;
    }
}

