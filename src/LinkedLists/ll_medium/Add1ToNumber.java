package LinkedLists.ll_medium;

public class Add1ToNumber {
    /**
     * Given a number in a linked list, add 1 to the number and return it.
     *
     * Approach 1: Reverse and then add the number
     *      1. Reverse the list to start adding from end.
     *      2. Add 1 to the number
     *      3. Reverse the complete number and return it again.
     *
     *      TC: O(3N)
     *      SC: O(1)
     *
     *
     * Optimal Solution: We use recursion to solve the high complexity.
     *      - To solve this problem, we need to add from right to left.
     *      - This can be achieved by using backtracking as we only can go forward in the LL.
     *      - When we start backtracking, we start our addition with carry value 1. (Base case)
     *      - Then as we return back, we add the carry and update the nodes if necessary.
     *      - If at the end, we get a carry. That means a new node needs to eb created
     *
     *      TC: O(N)
     *      SC: O(N)
     *
     * */

    public static int helper(Node temp){
        // Helper function for calculating the carry value and recursive additon.

        // Base case: End of list and start addition by 1.
        if(temp == null) return 1;

        // Calculate carry of that digit. Thanks recursion
        int carry = helper(temp.next);

        // Update digits and calculate carry for previous node.
        temp.data = temp.data + carry;
        if(temp.data < 10){ // Sum is less than 10
            return 0;
        }

        // Sum is equal to 10. So...
        // digit = 0, carry = 1
        temp.data = 0;
        return 1;
    }

    public static Node addOneRecursive(Node head){
        // Perform the final addition

        // Get the final carry value
        int carry = helper(head);

        // If carry exists, add a new digit to the head.
        if(carry == 1){
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }

        // Else return the list.
        return head;
    }

    public static Node reverseLL(Node head){
        // Check if LL is empty
        if(head == null || head.next == null)   return head;

        Node prev = null;
        Node temp = head;
        while(temp != null){
            Node nextEl = temp.next;
            // Assign link to previous element.
            temp.next = prev;

            // Updating values
            prev = temp;
            temp = nextEl;
        }

        head = prev;
        return head;
    }
    public static Node addOneIterative(Node head)
    {
          head = reverseLL(head);
          Node temp = head;
          int carry = 1;
          while(temp != null){
              temp.data = temp.data + carry;
              if(temp.data < 10){
                carry = 0;
                break;
              }
              else{
                  temp.data = 0;
                  carry = 1;
              }
              temp = temp.next;
          }

          if(carry == 1){
              Node newNode = new Node(1);
              head = reverseLL(head);
              newNode.next = head;
              return newNode;
          }

          head = reverseLL(head);
          return head;
    }


}
