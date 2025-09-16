import java.util.*;

public class Find_Middle_Node_Of_The_Linked_List {

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static Node ConvertArr2LL(int[] arr) { // Here we are converting Arr to LL
        if(arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node temp = head;

        for(int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static void PrintUpdatedLL(Node head) { // Here we are Printing the Updated LL after converting it from Arr
        while(head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static int CalLengthOfLL(Node head) { // Here we are Calculating the Length of LL
        int c = 0;
        while(head != null) {
            c++;
            head = head.next;
        }
        return c;
    }

    public static Node CalMiddleNode(Node head) { // Here we are Converting the Middle Node of an LL
        int len = CalLengthOfLL(head);
        int midLen = len/2;
        Node temp = head;

        for(int i = 0; i < midLen; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static void PrintFromMidOfLL(Node head) { // Here we are Printing the LL from middle Node
        Node mid = CalMiddleNode(head);
        PrintUpdatedLL(mid);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node head = ConvertArr2LL(arr);
        PrintUpdatedLL(head);
        int len = CalLengthOfLL(head);
        System.out.println(len);

        Node middle = CalMiddleNode(head);
        PrintFromMidOfLL(head);
    }
}