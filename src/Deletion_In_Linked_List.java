import java.util.*;

public class Deletion_In_Linked_List {

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node convertArr2LL(int[] arr) {
        if(arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static void printUpdatedLL(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node DeleteHead(Node head) {
        if(head == null) return head;
        head = head.next;
        return head;
    }

    public static Node DeleteTail(Node head) {
        if(head == null || head.next == null) return head;
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node DeleteKth(Node head, int k) {
        if (head == null) return head;
        if (k == 1) {
            head = head.next;
            return head;
        }
        int c = 0;
        Node prev = null;
        Node temp = head;
        while (temp != null) {
            c++;
            if (c == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node DeleteEl(Node head, int ele) {
        if(head == null) return head;
        if(head.data == ele) {
            head = head.next;
            return head;
        }
        Node prev = null;
        Node temp = head;
        while(temp != null) {
            if(temp.data == ele) {
                prev.next = prev.next.next;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node head = convertArr2LL(arr);
//        head = DeleteHead(head);
//        head = DeleteTail(head);
//        head = DeleteKth(head, 3);
        head = DeleteEl(head, 4);
        printUpdatedLL(head);
        sc.close();
    }
}