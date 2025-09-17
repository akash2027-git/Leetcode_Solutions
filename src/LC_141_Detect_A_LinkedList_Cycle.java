import java.util.*;

public class LC_141_Detect_A_LinkedList_Cycle {

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

    public static boolean hasCycle(Node head) {
//        Method 1 by Hashing
//        HashMap<Node, Integer> mpp = new HashMap<>();
//        Node temp = head;
//        while (temp != null) {
//            if(mpp.containsKey(temp) == true) {
//                return true;
//            } else {
//                mpp.put(temp, 1);
//                temp = temp.next;
//            }
//        }
//        return false;

//        Method 2 by Tortoise & Hare Method
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node head = ConvertArr2LL(arr);
        head.next.next.next = head.next;
        System.out.print(hasCycle(head));
    }
}
