package csula.cs3112.assignments;

import java.util.*;

//class Node {
//    int data;
//    Node next;
//
//    Node(int key)
//    {
//        data = key;
//        next = null;
//    }
//}
//
//class NodeComparator implements Comparator<Node> {
//
//    public int compare(Node k1, Node k2)
//    {
//        if (k1.data > k2.data)
//            return 1;
//        else if (k1.data < k2.data)
//            return -1;
//        return 0;
//    }
//}
public class Assignment9 {
    static Assignment9 ass9 = new Assignment9();
    public void sort(int[] array) {
        //Build a pile (rearrange array)
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i);
        // Take an element out of the heap one by one.
        for (int j=array.length-1; j>=0; j--) {
            // Move current root to end
            int temp = array[0];
            array[0] = array[j];
            array[j] = temp;
            // on the trimmed-down heap, call max heapify.
            heapify(array, j, 0);
        }
    }

    private void heapify(int[] array, int number, int node) {
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

    }
    static void printArray(int[] arr) {
        for (int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }

    // Main in the driver software
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = createList();
        System.out.println("Random array:");
        printArray(array);
        ass9.sort(array);
        System.out.println("Sorted array:");
        printArray(array);

//        System.out.println("Enter the number of sorted list to be merged");
//        int number = scanner.nextInt();
//        Node sortedList = createNSortedList(number);
//        mergeKList(sortedList,sortedList.size());

    }
    static Node mergeKList(List arr, int K)
    {
        // Priority_queue 'queue' implemented
        // as min heap with the help of
        // 'compare' function
        PriorityQueue<Node> queue
                = new PriorityQueue<>(new NodeComparator());
        Node at[] = new Node[K];
        Node head = new Node(0);
        Node last = head;
        // Push the head nodes of all
        // the k lists in 'queue'
        for (int i = 0; i < K; i++) {
            if (arr.get(i) != null) {
                queue.add((Node) arr.get(i));
            }
        }
        // Handles the case when k = 0
        // or lists have no elements in them
        if (queue.isEmpty())
            return null;
        // Loop till 'queue' is not empty
        while (!queue.isEmpty()) {
            // Get the top element of 'queue'
            Node curr = queue.poll();

            // Add the top element of 'queue'
            // to the resultant merged list
            last.next = curr;
            last = last.next;
            // Check if there is a node
            // next to the 'top' node
            // in the list of which 'top'
            // node is a member
            if (curr.next != null) {
                // Push the next node of top node
                // in 'queue'
                queue.add(curr.next);
            }
        }
        // Address of head node of the required
        // merged list
        return head.next;
    }

    private static int[] createList() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in array: ");
        int number = scanner.nextInt();
        int[] array = new int[number];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = (int)(Math.random()*100+1);
        }

        return array;
    }

    /*private static Node createNSortedList(int number) {
        Node listSort[] = new Node[number];
        int[][] temp = new int[number][number];
        for (int i=0; i<number ; i++){
             temp[i] = createList();
        }
        listSort = Arrays.asList(temp);
        System.out.println("Sorted Lists");
        for(int[] a : listSort){
            ass9.sort(a);
        }
        for(int[] a : listSort){
            printArray(a);
        }
        return listSort;
    }*/

}
