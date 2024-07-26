package LinkedLists.ll_medium;

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
public class Sort012 {



    static Node segregate(Node head){

        if(head == null || head.next == null) return head;

        Node temp = head;
        Node zeroHead = new Node(-1), oneHead = new Node(-1), twoHead = new Node(-1);
        Node zeros = zeroHead, ones = oneHead, twos = twoHead;

        // Traverse the list
        while(temp != null){
            if(temp.data == 0){
                zeros.next = temp;
                zeros = zeros.next;
            }
            else if(temp.data == 1){
                ones.next = temp;
                ones = ones.next;
            }
            else{
                twos.next = temp;
                twos = twos.next;
            }

            temp = temp.next;
        }

        // Careful, missing it caused cyclic LL
        zeros.next = null;
        ones.next = null;
        twos.next = null;

        // Combining the lists
        zeros.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        ones.next = twoHead.next;
        twoHead.next = null;
        return zeroHead.next;
    }

    /**
     *  Count and replace the occurances of the values.
     *
     *  TC: O(2N) - 2 pass solution
     *  SC: O(1)
     * */
    static Node segregateBrute(Node head) {
        // Bruteforce Solution
        Node temp = head;
        int count0 = 0, count1 = 0, count2 = 0;

        // Iterate the list to record values
        while(temp != null){
            switch(temp.data){
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
            }

            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            if(count0 > 0){
                temp.data = 0;
                count0--;
            }
            else if(count1 > 0){
                temp.data = 1;
                count1--;
            }
            else{
                temp.data = 2;
                count2--;
            }
        }

        return head;
    }
}
