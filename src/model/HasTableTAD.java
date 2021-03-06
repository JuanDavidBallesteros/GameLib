package model;

import java.util.ArrayList;
import java.util.Objects;

import TADAction.HashTableAction;
import exception.FullTable;
import exception.NullKeyException;

public class HasTableTAD<K, V> implements HashTableAction<K, V> {

    public static final int SIZE = 127;
    private ArrayList<HashNode<K, V>> nodes;
    private HashNode<K,V> deleted;

    private int elements;

    public HasTableTAD() {
        elements = 0;
        nodes = new ArrayList<HashNode<K, V>>();

        for (int i = 0; i < SIZE; i++) {
            nodes.add(null);
        }
    }

    @Override
    public void insert(K key, V value) throws NullKeyException, FullTable { // Error key = null o Lleno

        if (key == null)
            throw new NullKeyException();

        HashNode<K, V> temp = new HashNode<K, V>(key, value);
        int k = Objects.hashCode(temp.getKey());

        for (int i = 0; i < SIZE; i++) {
            int pos = hkFunction(k, i);

            if (nodes.get(pos) == null || nodes.get(pos).equals(deleted)) {
                nodes.set(pos, temp);
                elements++;
                return;
            }
        }
        throw new FullTable();

    }

    private int hkFunction(int k, int i) {
        return (int) ((k % SIZE) + i) % SIZE;
    }

    @Override
    public V search(K key) {
        int value = Objects.hashCode(key);

        for (int i = 0; i < SIZE; i++) {
            int pos = hkFunction(value, i);
            if (nodes.get(pos) != null &&  nodes.get(pos).getKey().equals(key)) { // Revisar, habia key
                if(nodes.get(pos) != deleted){
                    return nodes.get(pos).getValue();
                }
            }
        }
        return null;
    }

    @Override
    public void delete(K key) {
        int k = Objects.hashCode(key);

        boolean validation = false;

        for (int i = 0; i < SIZE || !validation; i++) {
            int pos = hkFunction(k, i);

            if (nodes.get(pos) != null && nodes.get(pos).getKey().equals(key)) {
                nodes.set(pos, deleted);
                validation = true;
                elements--;
            }
        }
    }

    public void setValue(K key, V value){
        int k = Objects.hashCode(key);

        for (int i = 0; i < SIZE; i++) {
            int pos = hkFunction(k, i);
            if (nodes.get(pos) != null &&  nodes.get(pos).getKey().equals(key)) {
                if(nodes.get(pos) != deleted){
                    nodes.get(pos).setValue(value);
                    return;
                }
            }
        }
        return ;
    }

    @Override
    public String toString() {
        return nodes.toString();
    }

    public int getElements() {
        return elements;
    }

    
}
