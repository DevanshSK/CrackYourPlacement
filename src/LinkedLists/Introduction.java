package LinkedLists;


public class Introduction {

    // Converting an array to a linkedlist
    static Node convertArr2LL(int[] arr){   // TC: O(N)
        // Create a head node
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i = 1; i < arr.length; i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    // Traversing in a LL
    static void traverseLL(Node head){
        Node temp = head;
        System.out.print("Data: ");
        while(temp != null){
            System.out.print("\t" + temp.data);
            temp = temp.next;
        }
        System.out.println();
    }

    static int lengthLL(Node head){
        int count = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    static int checkIfPresentInLL(Node head, int num){
        Node temp = head;
        while(temp != null){
            if(temp.data == num) return 1;
            temp = temp.next;
        }
        return 0;
    }




    // INSERTIONS AND DELETIONS IN LL
    public static Node removeHead(Node head){
        // If our LL is empty
        if(head == null) return head;
        // Update the head value to next element
        head = head.next;
        return head;
    }

    public static Node removeTail(Node head){
        // Check for empty LL
        if(head == null || head.next == null) return head;

        // Go to the second last element
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }

        // Remove the last element link
        temp.next = null;
        return head;
    }

    public static Node removeK(Node head, int k){
        if(head == null) return head;
        if(k == 1){
            head = head.next;
            return head;
        }
        int count = 0;
        Node temp = head;
        Node prev = null;
        while(temp != null){
            count++;
            if(count == k){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node removeEl(Node head, int val){
        if(head == null) return head;
        if(head.data == val){
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null){
            if(temp.data == val){
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    static Node insertHead(Node head, int val){ // TC: O(1)
        return new Node(val, head);
    }

    static Node insertLast(Node head, int val){
        // Edge case: If LL is empty
        if(head == null){
            return new Node(val);
        }
        // Iterate to the last element
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(val);
        return head;
    }

    // Insert at Kth position
    static Node insertK(Node head, int val, int k){
        // Edge case: LL is empty
        if(head == null){
            if(k == 1){
                return new Node(val);
            }
            else{
                return head;
            }
        }
        // Edge case: Insertion at head
        if(k == 1){
            return new Node(val);
        }
        // Traverse to target element
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            if(count == k-1){
                Node x = new Node(val);
                x.next = temp.next;
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    static Node insertBeforeN(Node head, int val, int n){
        // Edge case: LL is empty, No value present here.
        if(head == null){
            return null;
        }
        // Edge case: Value is present at head, So insertion at head
        if(head.data == n){
            return new Node(val, head);
        }
        // Traverse to target element
        Node temp = head;
        while(temp.next != null){
            if(temp.next.data == n){
                Node x = new Node(val, temp.next);
                temp.next = x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
//        int[] arr = { 2,3,5,8 };
        // Creating and accessing a node of LL
//        Node y = new Node(arr[0]);
//        System.out.println(y.data);

        // Converting an array into a Linked List
//        Node head = convertArr2LL(arr);
//        System.out.println(head.data);

//        // Traversing LL
//        System.out.println("Traversing LL");
//        traverseLL(head);
//        System.out.println("Length of LL: " + lengthLL(head));

//        // Searching LL
//        System.out.println(checkIfPresentInLL(head, 5));
//        System.out.println(checkIfPresentInLL(head, 15));


        // INSERTIONS AND DELETIONS IN LL
        int[] arr = { 2,3,5,8 };
        Node head = convertArr2LL(arr);
        // Delete head
//        head = removeK(head, 4);
//        head = removeEl(head, 18);
//        traverseLL(head);
//        // Delete tail
//        head = removeKElement(head, 3);

//        traverseLL(head);

        // Insert at head
        head = insertHead(head, 4);
        traverseLL(head);
        head = insertLast(head, 122);
        traverseLL(head);

        head = insertK(head, 106, 3);
        traverseLL(head);

        head = insertBeforeN(head, 44, 5);
        traverseLL(head);


    }
}
