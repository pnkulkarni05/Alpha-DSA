public class DoublyLL {

    class Node{
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size=0;

    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;

    }

    public int removeFirst(){
        if(head==null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            return val;
        }
        int val=head.data;
        head=head.next;
        head.prev=null; 
        return val;
    }


    public int removeLast(){
        Node temp=head;
        Node prev=null;
        if(head==null){
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }
        size--;
        if(size==1){
            head=tail=null;
            size=0;
        }
        
        while(temp!=null){
            prev=temp;
            temp=temp.next;
        }
        int val = prev.data;
        tail=prev.prev;
        tail.next=null;
        return val;
        
    }

    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            return;
        }

        Node temp=head;
        Node prev=null;

        while(temp!=null){
            prev=temp;
            temp=temp.next;
        }

        prev.next=newNode;
        tail=newNode;
        tail.prev=prev;

    }

    public void reverse(){
        Node prev=null;
        Node curr=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public void printDll(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" <-> " );
            temp=temp.next;
        }
        System.out.println("null");
    }
    public static void main(String args[]){
        DoublyLL dll=new DoublyLL();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.printDll();
        System.out.println(size);
        dll.removeFirst();
        dll.printDll();
        System.out.println(dll.removeLast());
        dll.printDll();
        dll.addLast(4);
        dll.printDll();
        dll.reverse();
        dll.printDll();
    }
}
