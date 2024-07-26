package LinkedLists;

class ListNode{
    int data;
    ListNode next;
    ListNode prev;

    ListNode(int data, ListNode next, ListNode prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    ListNode(int data){
        this.data = data;
    }
}
public class DLL {

    public static ListNode convertArr2Dll(int[] arr){
        // First we create the head Node to start the DLL formation.
        ListNode head = new ListNode(arr[0]);
        // Store a replica of head in prev
        ListNode prev = head;

        // Now we need to insert the remaining nodes in the head
        for(int i = 1; i<arr.length; i++){
            ListNode temp = new ListNode(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }

        return head;
    }

    public static void printDLL(ListNode head){
        while(head != null){
            System.out.print("\t"+head.data);
            head = head.next;
        }
        System.out.println();
    }

    // Deletion in DLL
    // Remove head
    public static ListNode removeHead(ListNode head){
        // If DLL is empty
        // If DLL contains only one element
        if(head == null || head.next == null) return head;

        // Make the next node head
        ListNode prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;

        return head;
    }

    // Remove tail
    public static ListNode removeTail(ListNode head){
        // If DLL contains only one element
        if(head == null || head.next == null) return head;

        ListNode tail = head;
        // Go to the last element
        while(tail.next != null){
            tail = tail.next;
        }
        // Get the previous element
        ListNode prev = tail.prev;
        tail.prev = null;
        prev.next = null;

        return head;
    }

    // Remove Kth element
    public static ListNode removeKth(ListNode head, int k){
        if(head == null){
            return null;
        }

        // Store the head reference
        ListNode temp = head;

        // Move temp to the Kth element
        int count = 0;
        while(temp != null){
            count++;
            if(count == k) break;
            temp = temp.next;
        }

        // Remove the temp element
        assert temp != null;
        ListNode prev = temp.prev;
        ListNode front = temp.next;

        if(prev == null && front == null){
            return null;
        }
        else if(prev == null){
            return removeHead(head);
        }
        else if(front == null){
            return removeTail(head);
        }
        prev.next = front;
        front.prev = prev;
        temp.next = null;
        temp.prev = null;
        return head;
    }

    public static void deleteNode(ListNode temp){
        ListNode prev = temp.prev;
        ListNode next = temp.next;

        if(next == null){
            prev.next = null;
            temp.prev = null;
            return;
        }

        prev.next = next;
        next.prev = prev;

        temp.next = temp.prev = null;
    }

    // Insertion at DLL
    public static ListNode insertBeforeHead(ListNode head, int val){
        ListNode temp = new ListNode(val, head, null);
        head.prev = temp;
        return temp;
    }

    public static ListNode insertBeforeTail(ListNode head, int val){
        if(head.next == null){
            return insertBeforeHead(head, val);
        }

        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
        }

        ListNode prev = tail.prev;
        ListNode newNode = new ListNode(val, tail, prev);
        prev.next = newNode;
        tail.prev = newNode;

        return head;
    }

    public static ListNode insertBeforeKth(ListNode head, int val, int k){

        if(k == 1) return insertBeforeHead(head, val);
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            if(count == k) break;
            temp = temp.next;
        }

        ListNode prev = temp.prev;
        ListNode newNode = new ListNode(val, temp, prev);
        prev.next = newNode;
        temp.prev = newNode;
        return head;
    }

    public static void insertBeforeNode(ListNode node, int val){
        if(node == null || node.prev == null)  return;
        ListNode prev = node.prev;
        ListNode newNode = new ListNode(val, node, prev);
        prev.next = newNode;
        node.prev = newNode;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 50, 60, 70};
        ListNode head = convertArr2Dll(nums);
        printDLL(head);

        // Removing head
        System.out.println("REMOVING HEAD");
        head = removeKth(head, 1);
        printDLL(head);

        // Remove Tail
        System.out.println("REMOVING Tail");
        head = removeKth(head, 5);
        printDLL(head);

        // Deleting a node in a LL
        System.out.println("Deleting Node in DLL");
        deleteNode(head.next.next);
        printDLL(head);

        System.out.println("Insert before head");
        head = insertBeforeHead(head, 11);
        printDLL(head);

        System.out.println("Insert before Tail");
        head = insertBeforeTail(head, 22);
        printDLL(head);

        System.out.println("Insert Before K");
        head = insertBeforeKth(head, 23, 3);
        printDLL(head);

        System.out.println("Insert before a node");
        insertBeforeNode(head.next.next.next, 100);
        printDLL(head);

        int[] arr = {1,2,3};
        ListNode head2 = convertArr2Dll(arr);
        printDLL(head2);

        insertBeforeNode(head2, 100);
        printDLL(head2);
    }
}
