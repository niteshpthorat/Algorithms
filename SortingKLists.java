/*
package csula.cs3112.assignments;

import java.util.*;
class HeapObject {

    public void setArrayIndex(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }

    public void setElementIndex(int elementIndex) {
        this.elementIndex = elementIndex;
    }

    public int[] arrayIndex;
    public int elementIndex;
    public int value;

    HeapObject(int arrayIndex,int elementIndex,int value )
    {
        this.arrayIndex = arrayIndex;
        this.elementIndex = elementIndex;
        this.value = value;
    }
    public Integer getValue() { return value; }
    // display() method to display
    // the student data
    public void display()
    {
        System.out.println("arrayIndex is: " + arrayIndex + "elementIndex is: "
                + elementIndex + "value is : " + value);
        System.out.println();
    }

}
public class SortingKLists{
    static int getParentIndex(int i){
        return (i-1)/2;
    }

    static boolean hasParent(int i){
        // if (getParentIndex(i)<0)
        //     return false;
        // return true;

        return  getParentIndex(i)>=0;
    }
    static int getLeftChildIndex(int i){
        return (2*i+1);
    }
    static int getRightChildIndex(int i){
        return (2*i+2);
    }

    static boolean hasLeftChild(int i, int length){
        return getLeftChildIndex(i)<length;
    }

//    static int parent(int i, HeapObject minHeap){
//         minHeap[getParentIndex(i)];
//    }

    */
/*boolean hasRightChild(int i ,int size){
        return getRightChildIndex(i)<size;
    }

    int rightChild(int i, int[] arr){
        return arr[getRightChildIndex(i)];
    }

    int leftChild(int i , HeapObject arr){
        return arr.[getLeftChildIndex(i)];
    }*//*





    MaxIntHeap minHeap = new MaxIntHeap();
    static void printArray(int[] arr) {
        for (int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }
    public static void main(String[] args){
        MaxIntHeap minHeap=new MaxIntHeap();

//        List<LinkedList> list = new ArrayList();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Lists: ");
        int k = sc.nextInt();

        System.out.println("Enter number of elements in each List: ");
        int n = sc.nextInt();

        int[][] list = new int[k][n];
        for (int i = 0; i < k; i++){
            list[i] = createList(n);
        }
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }

        int[] mergedList = mergeKSortedList(list);
        for (int i: mergedList) { System.out.print(i + " ");
        }
        */
/*LinkedList<Integer> linkedList = new LinkedList<>();
        LinkedList<Integer> lst1 = new LinkedList<>();
        for(int i= 0;i<k ;i++)
            list.add(createList(n));

        System.out.println(list);
        for (LinkedList lst :list){
            lst.getFirst();*//*

//            lst.getFirst().
        }

    private static int[] mergeKSortedList(int[][] list) {
        int[] result = new int[300];
        HeapObject[] minHeap = new HeapObject[list.length];
        for (int i =0; i< list.length ;i++) {
            minHeap[i] = new HeapObject(i, 0, list[i][0]);
        }
        for (HeapObject ele: minHeap) {
            ele.display();
        }
        heapify(minHeap);
            for (HeapObject ib: minHeap) {
                ib.display();
            }
//        for (HeapObject ib: minHeap) {
//            ib.display();
//        }
        int i =0;
        while (minHeap[0].getValue() != Integer.MAX_VALUE){
            HeapObject top = minHeap[0];
            result[i] = top.getValue();
            i++;
            top.elementIndex +=1;
            if(top.elementIndex >= list[top.arrayIndex].length) {
                top.value = Integer.MAX_VALUE;
            } else {
                top.value = list[top.arrayIndex][top.elementIndex];
            }
            for (HeapObject ib: minHeap) {
                ib.display();
            }
            heapifyDown(minHeap,0);
        }
        return result;
    }

        */
/*for (Map.Entry<Integer ,int[]> entry : list.entrySet()) {
            System.out.println(entry.getKey());
            for (int ele : entry.getValue())
                 System.out.print(ele + " ");
        }*//*


        */
/*for (Map.Entry<Integer ,int[]> entry : list.entrySet()) {
            arr = entry.getValue().
        }*//*



        */
/*int[] heap = new int[n];
        Iterator<int[]> it = list.iterator();
        for (it.hasNext()) {
            for (int j = 0; j < n; j++){
                heap[j] = it;
            }
        }*//*


    static void heapify(HeapObject[] minHeap){
        for(int i = minHeap.length - 1; i >= 0; i--) {
            heapify(minHeap, i ,0);
        }
    }


    */
/*static void heapifyDown(HeapObject[] minHeap, int index){
        int currentIndex = index;

        HeapObject current = minHeap[currentIndex];
        int leftIndex = getLeftChildIndex(currentIndex);
        int rightIndex = getRightChildIndex(currentIndex);
        int minIndex = findMinChildIndex(minHeap, leftIndex, rightIndex);
        HeapObject minChild = null;
        if (minIndex !=0){
            minChild = minHeap[minIndex];
        }
        while ((null != minChild) && (current.getValue() > minChild.getValue())){
            HeapObject temp = minHeap[currentIndex];
            minHeap[currentIndex] = minHeap[minIndex];
            minHeap[minIndex] = temp;

            currentIndex = minIndex;

            leftIndex = getLeftChildIndex(currentIndex);
            rightIndex = getRightChildIndex(currentIndex);

            minIndex = findMinChildIndex(minHeap, leftIndex, rightIndex);

            if (minIndex !=0){
                minChild = minHeap[minIndex];
            }
            else{
                minChild = null;
            }
        }
    }*//*

    */
/*void heapifyDown1(HeapObject[] minHeap,int smallest){
        while(hasLeftChild(smallest , minHeap.length)  ){
            int greaterChildIndex=getLeftChildIndex(smallest);
            if (hasRightChild(smallest , minHeap.length)
                    && (rightChild(smallest , minHeap)<leftChild(smallest))){
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
    }*//*


    private static void heapify(HeapObject array, int number, int node) {
        int largest = node;
        // Initialize largest as root
        int left = 2*node + 1; // left = 2*i + 1
        //When the left kid is bigger than the root
        int right = 2*node + 2; // right = 2*i + 2
        if (left < number && (array[left] > array[largest]))
            largest = left;
        //If the right child is bigger than the biggest thus far, then
        if (right < number && array[right] > array[largest])
            largest = right;
        // If largest is not root
        if (largest != node) {
            int swap = array[node];
            array[node] = array[largest];
            array[largest] = swap;
            //Heapify the impacted sub-tree recursively.
            heapify(array, number, largest);

        }

    private static int findMinChildIndex(HeapObject[] minHeap, int leftIndex, int rightIndex) {
        int minIndex = 0;
        if(hasLeftChild(leftIndex ,minHeap.length) ) {
            HeapObject leftChild = minHeap[leftIndex];
            HeapObject rightChild = minHeap[rightIndex];
            if (!leftChild.getValue().equals(null)) {
                if (!rightChild.getValue().equals(null)) {
                    minIndex = leftIndex;
                } else {
                    minIndex = rightChild.getValue() < leftChild.getValue() ? rightIndex : leftIndex;
                }
            }
        }
        return minIndex;
    }
    public static int[] createList(int number) {
        int[] array = new int[number];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = (int)(Math.random() * 100 + 1);
        }
        Arrays.sort(array);
        return array;
//        LinkedList numbers = new LinkedList();

        */
/*for (int i = 0; i < number; i++){
            numbers.add(array[i]);
        }*//*

    }

//    static void heapifyUp(HeapObject minHeap, int length){
//        int i=length-1;
//        while(hasParent(minHeap.arrayIndex) && (parent(i,minHeap)>minHeap[i].getValue())){
//            minHeap.swap(i, minHeap.getParentIndex(i));
//            i= minHeap.getParentIndex(i);
//        }
//    }
}
*/
