
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


    //Method to reverse ll

    public void reverseLL(){
        Node prev=null;
        Node curr=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;

    }

    //Method to remove nth node from end

    public int removeNthFromEnd(int index){
        Node temp=head;
        while(i<size-i-1){
            temp=temp.next;
            i++;
        }
        int val=temp.next.next.data;
        temp.next=temp.next.next;
        size--;
        return val;
    }



    //Slow Fast approach

    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    //Method to check if ll is palindrome or not

    public boolean checkPalindrome(){
        if(head==null || head.next==null) return true;

        // step 1: Find mid node
        Node mid = findMid(head);


        //step 2: Reverse another half of ll
        Node prev=null;
        Node curr=mid;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node right=prev;
        Node left=head;

        //Step 3: check if second part is equal to 1st part

        while(right!=null){
            if(right.data!=left.data) return false;
            right=right.next;
            left=left.next;
        }

        return true;
    }


    //Method to Check if ll has cycle 

    public static boolean isCyclic(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow) return true;
        }
        return false;
    }


    //Method to remove cycle from ll

    public static void removeCycle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                Node prev=fast;
                

                while(slow!=fast){
                    prev=fast;
                    slow=slow.next;
                    fast=fast.next;
                    
                }
                prev.next=null;

            }
        }
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

        ll.reverseLL();;
        ll.printLL();

        ll.removeNthFromEnd(3);
        ll.printLL();


        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.printLL();
        System.out.println(ll.checkPalindrome());

        Node head=new Node(1);
        Node temp=new Node(2);
        head.next=temp;
        head.next.next=new Node(3);
        head.next.next.next=temp;
        //1->2->3->2
        
        System.out.println(isCyclic(head));
        removeCycle(head);
        System.out.println(isCyclic(head));

    }
}