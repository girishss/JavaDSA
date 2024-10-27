package BinarySearchTree;

public class BinarySearchTree {
    private Node root;

    public boolean insert(int value){
        Node newNode = new Node(value);
        if(root == null) {
            root =newNode;
            return false;
        }
        Node temp = root;

        while(true){
            if(temp == null){

            }
            if(temp.value == value){
                return false;
            }
            if(temp.value > value)
            {
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
            if (temp.value < value) {
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
        }
    }

}
