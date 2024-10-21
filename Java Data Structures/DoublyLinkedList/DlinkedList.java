package DoublyLinkedList;

public class DlinkedList {
    Node head;
    Node tail;
    int length;

    public DlinkedList(int value){
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }

    public void append(int value){
        Node newNode = new Node(value);
        if(length==0){
            head=newNode;
            tail =newNode;
        }else{
            tail.next = newNode;
            newNode.prev =tail;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value){
        Node newNode = new Node(value);
        if(length==0){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
        length++;
    }

    public int removeLast(){
        if(length==0){
            return -1;
        }
        Node temp = tail;
        tail = tail.prev;
        tail.next=null;
        temp.prev=null;
        length--;
        if(length==0){
            head=null;
            temp=null;
        }
        return temp.value;
    }

    public int removeFirst(){
        if(length ==0){
            return -1;
        }
        Node temp = head;
        if(length==1){
            head=null;
            tail=null;
        }else{

            head = head.next;
            head.prev=null;
            temp.next=null;
        }
        length--;
        return temp.value;
    }

    public Node get(int index){
        // 1 - 2 - 2 - 3
        // 0   1   2   3
        if(index<0||index>=length) return null;
        Node temp = head;
        if(length<index/2){
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
        }else{
            temp=tail;
            for(int i = length-1;i>index;i++){
                temp=temp.prev;
            }
        }
        return  temp;
    }
    public boolean set(int value,int index){
        Node temp = get(index);
        if(temp!=null){
            temp.value = value;
            return true;
        }
        return false;
    }
    public boolean insert(int value,int index){
        if(index <0 || index>length) return  false;
        if(index==0){
            prepend(value);
            return true;
        }
        if(index ==length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index-1);
        Node after = before.next;

        newNode.next=after;
        newNode.prev = before;
        before.next=newNode;
        after.prev=newNode;
        length++;
        return true;

    }
    public int remove(int index){
        if(index <0 || index>=length) return -1;
        if(index==0){
            return removeFirst();
        }
        if(index==length-1) return removeLast();

        Node temp = get(index);

        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next=null;
        temp.prev=null;
        length--;
        return temp.value;


    }
}
