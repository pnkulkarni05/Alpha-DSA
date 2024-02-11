public class ZigzakLinkedList {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;

    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        
        newNode.next=head;
        head=newNode;
        
    }

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

    public Node findMid(){
        Node slow=head;
        Node fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public Node reverseLL(Node mid){
        Node prev=null;
        Node curr=mid;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    public void getZigZakList(){
        
        Node mid=findMid();
        
        Node rightHead=reverseLL(mid);
        mid.next=null;
        Node leftHead=head;
        
        
        while(rightHead!=null && leftHead!=null){
            Node nextLeft=leftHead.next;
            leftHead.next=rightHead;
            Node nextRight=rightHead.next;
            rightHead.next=nextLeft;

            
            leftHead=nextLeft;
            rightHead=nextRight;
        }
       

         

    }
    public static void main(String args[]){
        ZigzakLinkedList ll=new ZigzakLinkedList();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.addFirst(6);
        ll.printLL();
        ll.getZigZakList();
        ll.printLL();

        


    }
}
