public class LinkedList{
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
            return;
        }
    }
    public static Node head;        //Nodes head and tail decleared globally to access in every method of this class.
    public static Node tail;
    public static int size=0;

    //Method to add node at start of linked list

    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            size++;  // condition when ll is empty and we have to add node first time.
            return;
        }
        
        newNode.next=head;
        head=newNode;
        size++;
        
    }


    //Method to add node at last of ll

    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
        }

        tail.next=newNode;
        tail=newNode;
        size++;

    }

    //Method to print ll

    public void printLL(){
        if(head==null){
            System.out.println("null");
            return;
        } 
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }


    //Method to add node in middle of ll

    public void addMiddle(int data, int index){
        int i=0;
        Node newNode=new Node(data);
        Node temp=head;
        if(index==0){
            addFirst(data);
            return;
        }
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;
        size++;

    }

    //Method to remove first element in ll

    public int removeFirst(){
        int val=0;
        if(head==null){
            System.out.println("LL is empty!");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
             val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        else{
             val=head.data;
            head=head.next;
            size--;
            return val;

        }
        
    }

    //Method to remove last element in ll

    public int removeLast(){
        int val=0;
        Node temp=head;
        Node prev=null;
        if(head==null){
            System.out.println("LL is empty!");
            return Integer.MIN_VALUE;
        }
        else if(size==1){
            val=head.data;
            head=tail=null;
            size=0;
            return val;

        }
        else{
            int i=0;
            
            while(i<size-1){
                prev=temp;
                val=temp.data;
                temp=temp.next;
                i++;
            }
            size--;
            prev.next=null;
            

        }
        return val;
    }




    // Method to search element in ll iteratively
    public int searchElementIteratively(int key){
        if(size==0){
            System.out.println("LL is empty!");
            return -1;
        }
        Node temp=head;
        int index=-1;
        for(int i=0;i<size;i++){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
        }
        return index;
    }



    //Method for searching element in ll recursively
    int i=0;
    public int searchElementRecursively(int key, Node temp){
        if(temp==null) return -1;
        if(temp.data==key) return i;
        i++;
        temp=temp.next;
        int res=searchElementRecursively(key, temp);
        return res;

    }

    
    public static void main(String args[]){
        LinkedList ll =new LinkedList(); //We are declaring this object of LinkedList class to access the methods inside this class.
        ll.printLL();
        ll.addFirst(10);
        ll.printLL();
        ll.addFirst(12);
        ll.printLL();
        ll.addFirst(15);
        ll.printLL();
        ll.addLast(20);
        ll.printLL();
        ll.addLast(22);
        ll.printLL();
        ll.addLast(25);
        ll.printLL();
        ll.addMiddle(48, 4);
        ll.printLL();
        System.out.println(ll.removeFirst());
        ll.printLL();
        
        System.out.println("Size = "+size);

        ll.removeLast();
        ll.printLL();
        System.out.println("Size = "+ size);

        System.out.println("The key find at index : "+ ll.searchElementIteratively(48));

        System.out.println("The key find at index : "+ ll.searchElementRecursively(48, head));

    }
}