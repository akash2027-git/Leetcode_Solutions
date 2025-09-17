import java.util.*;

public class LC_142_LinkedList_Cycle_2 {
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
    public Node detectCycle(Node head) {
        // HashMap<ListNode, Integer> map = new HashMap<>();
        // ListNode temp = head;
        // while(temp != null) {
        //     if(map.containsKey(temp) == true) {
        //         return temp;
        //     }
        //     map.put(temp, 1);
        //     temp = temp.next;
        // }
        // return null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
