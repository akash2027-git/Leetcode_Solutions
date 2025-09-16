import java.util.*;

public class Deletion_In_DLL {

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

    public static Node RemoveHeadFromDLL(Node head) {
        if(head == null || head.next == null) return null;
        Node prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;

        return head;
    }

    public static Node RemoveTailFromDLL(Node head) {
        if(head == null || head.next == null) return null;
        Node tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        Node NewTail = tail.prev;
        NewTail.next = null;
        tail.prev = null;
        return head;
    }
    public static Node RemoveKthElementFromDLL(Node head, int k) {
        if(head == null) return null;
        Node temp = head;
        int c = 0;
        while(temp != null) {
            c++;
            if(c == k) break;
            temp = temp.next;

        }
        Node prev =  temp.prev;
        Node front = temp.next;

        if(prev == null && front == null) {
            return null;
        } else if(prev == null) {
            RemoveHeadFromDLL(head);
        } else if(front == null) {
            RemoveTailFromDLL(head);
        } else {
            prev.next = front;
            front.prev = prev;
            temp.prev = null;
            temp.next = null;
        }
        return head;
    }

    public static void RemoveNodeFromDLL(Node temp) {
        Node prev = temp.prev;
        Node front = temp.next;

        if(front == null) {
            prev.next = null;
            temp.prev = null;
            return;
        }
        prev.next = front;
        front.prev = prev;
        temp.next = null;
        temp.prev = null;

    }

    public static void PrintUpdatedDLL(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node head = ConvertArr2DLL(arr);
//        head = RemoveHeadFromDLL(head);
//        head = RemoveTailFromDLL(head);
//        head = RemoveKthElementFromDLL(head, 3);
        RemoveNodeFromDLL(head.next);
        PrintUpdatedDLL(head);
    }
}