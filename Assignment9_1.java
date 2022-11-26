package csula.cs3112.assignments;

class MaxIntHeap{
    int arr[]=new int[10];
    int size=0;

    int getParentIndex(int i){
        return (i-1)/2;
    }

    int getLeftChildIndex(int i){
        return (2*i+1);
    }

    boolean hasParent(int i){
        // if (getParentIndex(i)<0)
        //     return false;
        // return true;

        return getParentIndex(i)>=0;
    }

    boolean hasLeftChild(int i){
        return getLeftChildIndex(i)<size;
    }

    int getRightChildIndex(int i){
        return (2*i+2);
    }

    boolean hasRightChild(int i){
        return getRightChildIndex(i)<size;
    }

    int parent(int i){
        return arr[getParentIndex(i)];
    }

    int rightChild(int i){
        return arr[getRightChildIndex(i)];
    }

    int leftChild(int i){
        return arr[getLeftChildIndex(i)];
    }

    int size(){
        return size;
    }

    boolean isEmpty(){
        return size<=0;
    }

    //returns the root
    int peek(){
        return arr[0];
    }

    void insert(int val){
        arr[size]=val;
        size++;
        heapifyUp();
    }

    void heapifyUp(){
        int i=size-1;
        while(hasParent(i) && (parent(i)>arr[i])){
            swap(i, getParentIndex(i));
            i=getParentIndex(i);
        }
    }

    void swap(int a, int b){
        int temp;
        temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    void print(){
        for (int i=0; i<size; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    int poll(){
        int val=arr[0];
        arr[0]=arr[size-1];
        size--;
        heapifyDown();
        return val;
    }

    void heapifyDown(){
        int smallest=0;
        while(hasLeftChild(smallest)  ){
            int greaterChildIndex=getLeftChildIndex(smallest);
            if (hasRightChild(smallest) && (rightChild(smallest)<leftChild(smallest))){
                greaterChildIndex=getRightChildIndex(smallest);
            }
            if (arr[smallest]>arr[greaterChildIndex]){
                swap(smallest, greaterChildIndex);
            }
            else{
                break;
            }
            smallest=greaterChildIndex;
        }
    }

    // function to sort the heap as labour
    void sort(){
        int n=size;
        while(n!=0){
            int temp;
            temp=arr[0];
            arr[0]=arr[n-1];
            arr[n-1]=temp;
            heapifyDown();
            n--;
        }
    }
}

public class Assignment9_1{
    public static void main(String args[]){
        MaxIntHeap mh=new MaxIntHeap();
        mh.insert(10);
        mh.insert(5);
        mh.insert(3);
        mh.insert(2);
        mh.insert(7);
        mh.sort();
        mh.print();

    }
}
