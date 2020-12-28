package data_structures;

import java.util.ArrayList;

class Main{
    public static void main(String[] args) {
        MaxBinaryHeap maxBinaryHeap = new MaxBinaryHeap();

        maxBinaryHeap.insert(41);
        maxBinaryHeap.insert(32);
        maxBinaryHeap.insert(17);
        maxBinaryHeap.insert(50);
        maxBinaryHeap.insert(51);
        maxBinaryHeap.insert(18);

        ArrayList<Object> values = maxBinaryHeap.getValues();

        for(Object value : values){
            System.out.println(value);
        }
    }
}

public class MaxBinaryHeap {
    ArrayList<Object> values = new ArrayList<>();

    public ArrayList<Object> getValues() {
        return values;
    }

    public void insert(Object data){
        values.add(data);
        bubbleUp();
    }

    private void bubbleUp(){
        int index = values.size()-1;
        while(true){
            int parentIndex = (index-1)/2;
            if(values.get(parentIndex).hashCode() < values.get(index).hashCode()){
                Object parentValue = values.get(parentIndex);
                values.set(parentIndex, values.get(index));
                values.set(index, parentValue);
                index = parentIndex;
            }else break;
        }
    }

    public void extractMax(){
        if (values.size() != 0) {
            if(values.size() == 1) {
                values.clear();
            }else{
//                Object element = values.get(-1);
//                values.set(-1, values.get(0));
//                values.set(0, element);
                swap(values.get(0), values.get(-1));
                int index = 0;
                while(true){
                    int child1Index = (2 * index)+1;
                    int child2Index = (2 * index)+2;
                    if(child1Index> child2Index) {
                        swap(child1Index, values.get(index));
                        index = child1Index;
                    }
                    else {
                        swap(child2Index, values.get(index));
                        index = child2Index;
                    }
                }
            }
        }
    }

    private void swap(Object o1, Object o2){
        Object temp = o1;
        o2 = o1;
        o1 = temp;
    }

}
