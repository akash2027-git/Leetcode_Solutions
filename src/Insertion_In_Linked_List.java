import java.util.Scanner;

public class Insertion_In_Linked_List {
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
        Node(int d, Node n) {
            data = d;
            next = n;
        }
    }

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

    public static void printUpdatedLL(Node head) {
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static Node InsertHead(Node head, int val) {
        Node temp = new Node(val, head);
        return temp;
    }

    public static Node InsertTail(Node head, int val) {
        if(head == null) {
            return new Node(val);
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
        return head;
    }

    public static Node InsertAtKth(Node head, int ele, int k) {
        if(head == null) {
            if(k == 1) {
                return new Node(ele);
            } else {
                return head;
            }
        }
        if(k == 1) {
            Node newHead = new Node(ele, head);
            return newHead;
        }
        int c = 0;
        Node temp = head;
        while(temp != null) {
            c++;
            if(c == (k-1)) {
                Node x = new Node(ele);
                x.next = temp.next;
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node InsertElementBeforeValue(Node head, int ele, int val) {
        if(head == null) {
            return null;
        }
        if(head.data == val) {
            return new Node(ele, head);
        }
        Node temp = head;
        while(temp.next != null) {
            if(temp.next.data == val) {
                Node x = new Node(ele);
                x.next = temp.next;
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int[] arr = new int[n];
        for(int i = 0; i < n;  i++) {
            arr[i] = sc.nextInt();
        }
        Node head = ConvertArr2LL(arr);
        head = InsertHead(head, 6);
//        head = InsertTail(head, 100);
//        head = InsertAtKth(head, 10, 7);
//        head = InsertElementBeforeValue(head, 10, 4);
        printUpdatedLL(head);
    }
}
