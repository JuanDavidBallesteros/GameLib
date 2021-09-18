package model;

import java.util.ArrayList;
import java.util.Objects;

import TADAction.HashTableAction;
import exception.NullKeyException;

public class HasTableTAD<K,V> implements HashTableAction<K, V> {

    public static final int SIZE = 127;
    private ArrayList<HashNode<K,V>> nodes;

    public HasTableTAD(){
        nodes = new ArrayList<HashNode<K,V>>();

        for (int i = 0; i < SIZE; i++) {
            nodes.add(null);
        }
    }

    @Override
    public void insert(K key, V value) throws NullKeyException  { // Error key = null o Lleno

        if (key == null)
            throw new NullKeyException();

        HashNode<K,V> temp = new HashNode<K,V>(key, value);
        int k = Objects.hashCode(temp.getKey());
        int i = hkFunction(k);

        if(nodes.get(i) == null){
            nodes.set(i, temp);
        } else {
            HashNode<K,V> node = nodes.get(i);
            boolean validation = false;
            while (!validation) {
                if(node.getNextNode() == null){
                    node.setNextNode(temp);
                    temp.setBackNode(node);
                    validation = true;
                }
                node = node.getNextNode();
            }
        }        
    }

    private int hkFunction(int k){
        double a = ((5)^(1/2))/2 ;
        return (int)(SIZE*((k*a)%1));
    }

    @Override
    public V search(K key) {
        int k = Objects.hashCode(key);
        int i = hkFunction(k);
        if(nodes.get(i) != null){
            return nodes.get(i).getValue();
        } else {
            return null;
        }
        
    }

    @Override
    public void delete(K key) {
        int k = Objects.hashCode(key);
        int i = hkFunction(k);
        nodes.set(i, null);
    }

    @Override
    public String toString() {
        return nodes.toString();
    }

    
}
