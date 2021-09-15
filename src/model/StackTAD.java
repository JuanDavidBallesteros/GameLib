package model;

public class StackTAD<T> {
    private Node topNode;

    public StackTAD(){}

    public void push(T value){
        Node temp = new Node(value);
        if(topNode == null){
            topNode = temp;
        } else {
            temp.setNextNode(topNode);
            topNode = temp;
        }
    }

    public boolean isEmpty(){
        if(topNode == null){
            return true;
        } else {
            return false;
        }
    }

    public T top(){
        return topNode.getValue();
    }

    public T pop(){
        T temp = topNode.getValue();
        topNode = topNode.getNextNode();
        return temp;
    }

    public class Node {

        private Node nextNode;
        private T value;
        
        public Node(T value){
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public T getValue() {
            return value;
        }        

    }
}
