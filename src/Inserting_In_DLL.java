import java.util.*;

public class Inserting_In_DLL {
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

    public static Node InsertBeforeHeadOfDLL(Node head, int val) {
        Node newHead = new Node(val, head, null);
        head.prev = newHead;

        return newHead;
    }

    public static Node InsertBeforeTailOfDLL(Node head, int val) {
        Node tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.prev;
        Node NewNode = new Node(val, tail, prev);
        prev.next = NewNode;
        tail.prev = NewNode;

        return head;
    }

    public static Node InsertBeforeKthElementOfDLL(Node head, int k, int val) {
        if(k == 1) {
            return InsertBeforeHeadOfDLL(head, 10);
        }
        Node temp = head;
        int c = 0;
        while(temp != null) {
            c++;
            if(c == k) break;
            temp = temp.next;
        }
        Node prev = temp.prev;
        Node NewNode = new Node(val, temp, prev);
        prev.next = NewNode;
        temp.prev = NewNode;
        return head;
    }

    public static void InsertBeforeNode(Node node, int val) {
        Node prev = node.prev;
        Node NewNode = new Node(val, node, prev);
        prev.next = NewNode;
        node.prev = NewNode;
    }

    public static void PrintUpdatedDLL(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node head = ConvertArr2DLL(arr);
//        head = InsertBeforeHeadOfDLL(head, 10);
//        head = InsertBeforeTailOfDLL(head, 10);
//        head = InsertBeforeKthElementOfDLL(head, 3, 10);
        InsertBeforeNode(head.next, 10);
        PrintUpdatedDLL(head);
    }
}
