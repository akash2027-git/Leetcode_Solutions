import java.util.*;

public class Doubly_LinkedList {

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

    public static Node ConvertArr2DoublyLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;

        for(int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    public static void PrintDoublyLL(Node head) {
        System.out.print("null <- ");
        while(head != null) {
            System.out.print(head.data + " ");
            if(head.next != null) {
                System.out.print(" <-> ");
            }
            head = head.next;
        }
        System.out.println("-> null");
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node head = ConvertArr2DoublyLL(arr);
        PrintDoublyLL(head);
    }
}
