package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(4);
        list.append(5);
        list.append(53);
        list.append(52);
        list.append(51);
        list.append(44);



        list.printList();
        list.reverse();
        list.printList();

    }
}
