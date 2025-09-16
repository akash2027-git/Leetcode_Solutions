import java.util.*;

public class Reverse_DLL {

    static class Node {
        int data;
        Node next;
        Node prev;


        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }

        Node(int d, Node n, Node p) {
            data = d;
            next = n;
            prev = p;
        }
    }

    public static Node ConvertArr2DLL(int[] arr) {
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node prev = head;

        for(int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    public static Node ReverseDLL(Node head) {
        if(head == null || head.next == null) return null;
        Node current = head;
        Node last = null;

        while(current != null) {
            Node front = current.next;
            current.next = last;
            current.prev = front;

            last = current;
            current = front;
        }

        return last;
    }

    public static void PrintUpdatedDLL(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node head = ConvertArr2DLL(arr);
        head = ReverseDLL(head);
        PrintUpdatedDLL(head);
    }
}
