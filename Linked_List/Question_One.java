public class Question_One{
    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();

        System.out.println("Size of Linked List: " + ll.size);
        System.out.println("the element found at index: " + ll.itrSearch(3));
        System.out.println("the element found at index: " + ll.itrSearch(10));
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



}