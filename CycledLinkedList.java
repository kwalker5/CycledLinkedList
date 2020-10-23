import java.util.*;

//Kate Walker
public class CycledLinkedList {
    public static Node head,tail;//initializing a variable of type node to store head and the tail
    int size=0;
    public static class Node {//Node class
        int data;//int to store the nodes data
        Node next;//node to store the information of the next node

        Node(int data, Node next) {//constructor for the node
            this.data = data;//setting the data to the given data
            this.next = next;//setting the node.next to the next node
        }

    }
    
    public Node hasCycle(Node head) {//function that takes in the head of a linkedlist and checks for a cycle in it
        if (head == null || head.next == null){//if the head is or the head.next is null
            return null;//then return null
        }
        Node slow = head;//initializing the slow node to equal the head
        Node fast = head;//initializing the fast node to also equal the head
        boolean cycle = false;//making a boolean called cycle and setting it to false
        while (slow.next != null && fast.next != null && fast.next.next != null) {//while slow.next,fast.next, & fast.next.next are not null
            slow = slow.next;//make slow equal to slow.next
            fast = fast.next.next;//make fast equal to fast.next.next so it is one ahead of slow
            if (slow == fast) {//if slow == fast
                cycle = true;//set cycle to be true
                break;//break the loop
            }
        }
        if (!cycle){//if cycle is still false
            return null;//return null
        }
        fast = head;//set the fast equal to the head
        while (true) {//while cycle is true
            if (fast == slow) {//if slow equals fast return slow
                return slow;//return slow
            }
            slow = slow.next;//set slow to slow.next
            fast = fast.next;//set fast to fast.next.next
        }

    }
}
