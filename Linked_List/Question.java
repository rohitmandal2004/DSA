public class Question{
    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
        ll.print();
        System.out.println("is palindrome: " + ll.checkPalindrome());

        //  System.out.println("Size of Linked List: " + ll.size);
        // // System.out.println("the element found at index: " + ll.itrSearch(3));
        // // System.out.println("the element found at index: " + ll.itrSearch(10));

        // System.out.println("the element found at index: " + ll.recSearch(3));
        // System.out.println("the element found at index: " + ll.recSearch(10));

            // ll.reverse();
            // ll.print();
            // ll.deleteNthFromEnd(3);
            // ll.print();


}

}

class Linkedlist{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;


 public void addFirst(int data){
        // Step 1: Create a new node
         Node newNode = new Node(data);
         size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        // Step 2: newNode next = head
        newNode.next = head; //link new node with head

        // Step 3: head = newNode
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode; //link tail node with new node
        tail = newNode; //update tail to new node
    }


    public void print(){
        if(head == null){
            System.out.println("Linked List is empty");
            return;
        }
        Node temp = head;
        while(temp != null){    
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void add(int index, int data){
    // case 1: insert at beginning
    if(index == 0){
        addFirst(data);
        return;
    }

    Node newNode = new Node(data);
    size++;
    Node temp = head;
    int i = 0;

    // move to (index - 1)
    while(i < index - 1){
        temp = temp.next;
        i++;
    }

    // link new node
    newNode.next = temp.next;
    temp.next = newNode;
}


    public int removeFirst(){
        if(size == 0){
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        } 
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }


    public int removeLast(){
        if(size == 0){
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        } 
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        // find second last node  
        Node prev = head;  
        for(int i = 0; i < size - 2; i++){
            prev = prev.next;
        }
        int val = prev.next.data; // tail node data
        prev.next = null;
        tail = prev; // update tail to second last node
        size--;
        return val;
    }


    public int removeAt(int index){
    // invalid index
    if(index < 0 || index >= size){
        System.out.println("Invalid index");
        return Integer.MIN_VALUE;
    }

    // first node
    if(index == 0){
        return removeFirst();
    }

    // last node
    if(index == size - 1){
        return removeLast();
    }

    // middle node
    Node prev = head;

    // go to (index - 1)
    for(int i = 0; i < index - 1; i++){
        prev = prev.next;
    }

    int val = prev.next.data;   // node to delete
    prev.next = prev.next.next; // skip that node
    size--;

    return val;
}

public int itrSearch(int key){ //o(n)
    Node temp = head;
    int i = 0;

    while(temp != null){
        if(temp.data == key){
            return i;
        }
        temp = temp.next;
        i++;
    }
    return -1;
}

    public int helper(Node head, int key){ //O(n)

        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx + 1;
    }

    public int recSearch(int key){
        return helper(head, key);
    }

    public void reverse(){
        Node prev = null;
        Node curr = tail = head; //update tail to head
        Node next;

        while(curr != null){
            next = curr.next; //save next node
            curr.next = prev; //reverse link
            prev = curr; //move prev forward
            curr = next; //move curr forward
        }
        head = prev; //update head to last node
    }
     

     public void deleteNthFromEnd(int n){
        //calculate size of linked list
        int size = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        if(n == size){
            head = head.next; //delete first node
            return;
        }

        // find (size - n)th node
        int i = 1;
        int idxToFind = size - n;
        Node prev = head;
         
        while(i < idxToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next; //skip the nth node from end
     }
    
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; //move 1 step
            fast = fast.next.next; //move 2 steps
        }
        return slow; //slow is mid node
    }

     public boolean checkPalindrome(){

        if(head == null || head.next == null){
            return true;
        }
        // step 1: find mid
        Node midNode = findMid(head);

        // step 2: reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while(curr != null){
            next = curr.next; //save next node
            curr.next = prev; //reverse link
            prev = curr; //move prev forward
            curr = next; //move curr forward
        }
        Node rightHead = prev; //head of reversed second half
        Node leftHead = head; //head of first half

        // step 3: compare first and second half
        while(rightHead != null){
            if(leftHead.data != rightHead.data){
                return false; //not palindrome
            }
            leftHead = leftHead.next;
            rightHead = rightHead.next;
        }
        return true; //palindrome


     }

     
}
