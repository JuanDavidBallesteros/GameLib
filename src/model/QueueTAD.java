package model;

import TADAction.QueueAction;

public class QueueTAD<T> implements QueueAction<T> {

    private Node first;
    private int size;

    public QueueTAD(){
        size = 0;
    }

    @Override
    public void add(T value){
        Node temp =  new Node(value);

        if(first == null){
            first = temp;
            size = 1;
        } else {
            boolean validation = false;
            Node node = first;
            while (!validation) {
                if(node.getNextNode() == null){
                    node.setNextNode(temp);
                    size++;
                    validation = true;
                }
                node = node.getNextNode();
            }
        }
    }

    @Override
    public boolean isEmpty(){
        if(first ==  null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T front(){
        return first.getValue();
    }

    @Override
    public T dequeue(){
        T temp = first.getValue();
        first = first.getNextNode();
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
