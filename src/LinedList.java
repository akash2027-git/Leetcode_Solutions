import java.util.*;

public class LinedList {

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

//    Converting Array to Linked List

    public static Node ConvertArr2LL(int[] arr) {
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

//    Printing Linked List

    public static void PrintUpdatedLL(Node head) {
        while(head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        int n = 5;
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node head = ConvertArr2LL(arr);
        PrintUpdatedLL(head);
    }
}