package model;

public class HashNode<K,V> {

        private HashNode<K,V> nextNode;
        private HashNode<K,V> backNode;
        private V value;
        private K key;
        
        public HashNode(K key, V value){
            this.value = value;
            this.key = key;
        }

        public HashNode<K,V>  getNextNode() {
            return nextNode;
        }

        public void setNextNode(HashNode<K,V> nextNode) {
            this.nextNode = nextNode;
        }

        public V getValue() {
            return value;
        }
    
        public void setValue(V value) {
            this.value = value;
        }

        public HashNode<K,V> getBackNode() {
            return backNode;
        }

        public void setBackNode(HashNode<K,V> backNode) {
            this.backNode = backNode;
        }

        public K getKey() {
            return key;
        }      

    
}
