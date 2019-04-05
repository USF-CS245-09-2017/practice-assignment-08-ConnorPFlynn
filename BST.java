import java.lang.Comparable;

class BSTnode<T> {
    Comparable<T> data;
    BSTnode<T> left;
    BSTnode<T> right;

    BSTnode(Comparable<T> data) {
        this.data = data;
    }

    Comparable<T> getData() {
        return data;
    }

    void setData(Comparable<T> data) {
        this.data = data;
    }

    BSTnode<T> getLeft() {
        return left;
    }

    void setLeft(BSTnode<T> left) {
        this.left = left;
    }

    BSTnode<T> getRight() {
        return right;
    }

    void setRight(BSTnode<T> right) {
        this.right = right;
    }
}

class BST<T>{

    private BSTnode<T> root;

    boolean find(Comparable<T> value){
        return find(root, value);
    }
    private boolean find(BSTnode node, Comparable<T> value){
        if(node == null){
            return false;
        }
        if(node.getData().compareTo(value) == 0){
            return true;
        }
        else if(node.getData().compareTo(value) < 0){
            return find(node.getRight(),value);
        }
        else{
            return find(node.getLeft(), value);
        }
    }

    void insert(Comparable<T> value){
        root = insert(root, value);
    }

    private BSTnode insert(BSTnode<T> node, Comparable value){
        if (node == null){
            BSTnode n = new BSTnode(value);
            return n;
        }
        else if(node.data.compareTo((T)value) < 0){
            node.setRight(insert(node.getRight(), value));

        }
        else{
            node.setLeft(insert(node.left, value));
        }
        return node;
    }

    void delete(Comparable value) {
        root = delete(root, value);
    }

    BSTnode delete(BSTnode<T> node, Comparable value){
        if(node==null) {
            return null;
        }
        if(node.getData().compareTo((T)value) == 0){
            if(node.getLeft()==null){
                return node.getRight();
            }
            else if(node.getRight()==null){
                return node.getLeft();
            }
            else{
                if(node.getRight().getLeft() == null){
                    node.setData(node.getRight().getData());
                    node.setRight(node.getRight().getRight());
                    return node;
                }
                else{
                    node = (BSTnode<T>) removeSmallest(node.getRight());
                    return node;
                }
            }
        }
        else if((node.getData().compareTo((T)value)<0)){
            node.setRight(delete(node.getRight(),value));
        }
        else{
            node.setLeft(delete(node.getLeft(),value));
        }
        return node;
    }

    Comparable removeSmallest(BSTnode<T> node){
        if(node.getLeft().getLeft() == null){
            Comparable smallest = node.getLeft().getData();
            node.setLeft(node.getLeft().getRight());
            return smallest;
        }
        else{
            return removeSmallest(node.getLeft());
        }

    }

    void print(){
        print(root);
    }

    private void print(BSTnode node){
        if(node != null){
            print(node.left);
            System.out.println(node.data);
            print(node.getRight());
        }

    }

}


