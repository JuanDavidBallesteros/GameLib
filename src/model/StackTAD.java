package model;

import TADAction.StackAction;

public class StackTAD<T> implements StackAction<T> {

    private Node topNode;
    private int size;

    public StackTAD(){
        size = 0;
    }

    @Override
    public void push(T value){
        Node temp = new Node(value);
        if(topNode == null){
            topNode = temp;
            size++;
        } else {
            temp.setNextNode(topNode);
            topNode = temp;
            size++;
        }
    }

    @Override
    public boolean isEmpty(){
        if(topNode == null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T top(){
        return topNode.getValue();
    }

    @Override
    public T pop(){
        T temp = topNode.getValue();
        topNode = topNode.getNextNode();
        size--;
        return temp;
    }

    public int getSize() {
        return size;
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
