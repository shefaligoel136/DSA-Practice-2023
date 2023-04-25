package LinkedList;

public class BasicFunctions {

    public static void insert(Node head, int value){
        if(head == null){
            return;
        }
        Node newNode = new Node(value);
        if(head.next == null){
            head.next = newNode;
            return;
        }
        while(head.next!=null){
            head = head.next;
        }
        head.next = newNode;
        return;
    }

    public static int findMiddle(Node head){
        if(head == null){
            return -1;
        }

        Node slow = head;
        Node fast = head;

        while(fast.next !=null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.val;

    }

    public static void print(Node head){
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
        return;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        insert(head,2);
        insert(head,3);
        insert(head,4);
        insert(head,5);
        insert(head,6);
        insert(head,7);
        insert(head,8);
        print(head);

        System.out.println(findMiddle(head));
    }
}
