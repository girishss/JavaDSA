package LinkedList;

public class LinkedList {
    Node head;
    Node tail;
    int length;
    public LinkedList(int value){
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length =1;
    }
    public void printList(){
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head=newNode;
            tail=newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    public int removeLast() {
       if(length == 0) return -1;
       Node temp = head;
       Node prev = head ;
       while(temp.next !=null){
           prev =temp;
           temp = temp.next;
       }
       tail = prev;
       tail.next = null;
       length--;
       if(length == 0){
           tail=null;
           head=null;
       }
       return temp.value;
    }
    public  void prepend(int value){
        Node newNode  = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }
    public  int removeFirst(){
        if(length == 0) return -1;
        Node temp = head;
        head = temp.next;
        temp.next = null;
        length --;
        if(length==0){
            temp =null;
        }
        return  temp.value;
    }
    public  Node get(int index){
        if(index < 0 || index >= length) return  null;
        Node temp = head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return  temp;
    }
    public boolean set(int index,int value){
       Node temp = get(index);
        if (temp != null) {

            temp.value = value;
            return true;
        }
        return  false;
    }

    public boolean insert(int index,int value){
        if(index<0||index>length){
            return false;
        }
        if(index ==0){
            prepend( value);
            return true;
        }
        if(index ==length){
            append( value);
            return true;
        }
        Node temp = get(index-1);
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next =newNode;
        length++;
        return  true;
    }
    public int remove(int index){
        if(index < 0||index>=length) return -1;
        if(index==0){
            return removeFirst();
        }
        if(index == length-1){
            return removeLast();
        }
        Node prev = get(index-1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp.value;
    }
    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for(int i=0;i<length;i++){
            after = temp.next;
            temp.next = before;
            before=temp;
            temp=after;
        }
    }
}
