package org.pdas.heaps;

public class Heap {
    int capacity;
    int[] arrList;
    int heap_type;
    int count;

    Heap(int capacity, int heap_type){
        this.capacity = capacity;
        this.arrList = new int[capacity];
        this.count = 0;
        this.heap_type = heap_type;
    }

    public int parent(int index){
        // at any point i - parent will be (i-1)/2
        if (index <= 0 || index >= this.count) return -1;
        return (index-1)/2;
    }

    public int leftChild(int index){
        // left child would be 2*i+1
        int leftChild = 2*index+1;
        if (leftChild >= this.count) { return -1;}
        return leftChild;
    }

    public int rightChild(int index){
        // right child would be 2*i+2
        int rightChild = 2*index+2;
        if (rightChild >= this.count) { return -1;}
        return rightChild;
    }

    public int getMax(){
        if (this.count == 0) return -1;
        return this.arrList[0];
    }

    public void perforateDown(int index){
        int left, right, max, temp;
        left = leftChild(index);
        right = rightChild(index);

        if (left != -1 && this.arrList[left] > this.arrList[index]){
            max = this.arrList[left];
        } else {
            max = index;
        }
        if (right != -1 && this.arrList[right] > this.arrList[index]){
            max = this.arrList[right];
        }
        if (max != index){
            temp = this.arrList[index];
            this.arrList[index] = this.arrList[max];
            this.arrList[max] = temp;
            perforateDown(max);
        }
    }

    public int deleteMax(){
        if (this.count == 0) return -1;
        int data = this.arrList[0];
        this.arrList[0] = this.arrList[this.count-1];
        this.count--;
        perforateDown(0);
        return data;
    }

    public void  insert(int data){
        int index;
        if (this.count == this.capacity){

        }
    }

//    private void resizeHeap(){
//        int[] oldArray = new int[this.capacity];
//        System.arraycopy(this.arrList, 0, oldArray,this.count-1, );
//    }
}
