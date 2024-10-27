package Stacks;

public class Stack {
    Node top;
    int height;

    public  Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height=1;
    }

    public void  push(int value){
        Node newNode=new Node(value);
        if(height==0){
            top=newNode;
        }else{
            newNode.next=top;
            top=newNode;

        }
        height++;
    }

    public Node pop(){
        if(height==0)return null;
        Node temp = top;
        top=top.next;
        temp.next=null;
        height--;
        return  temp;
    }
}
