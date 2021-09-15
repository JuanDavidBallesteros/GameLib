package model;

public class QueueTAD<T> {

    private Node first;

    public QueueTAD(){}

    public void add(T value){
        Node temp =  new Node(value);

        if(first == null){
            first = temp;
        } else {
            boolean validation = false;
            Node node = first;
            while (!validation) {
                node = node.getNextNode();
                if(node.getNextNode() == null){
                    node.setNextNode(temp);
                    validation = true;
                }
            }
        }
    }

    public boolean isEmpty(){
        if(first ==  null){
            return true;
        } else {
            return false;
        }
    }

    public T front(){
        return first.getValue();
    }

    public T dequeue(){
        T temp = first.getValue();
        first = first.getNextNode();
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
