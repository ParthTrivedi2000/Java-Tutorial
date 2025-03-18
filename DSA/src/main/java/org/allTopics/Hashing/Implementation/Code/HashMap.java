package org.allTopics.Hashing.Implementation.Code;

import java.util.ArrayList;

public class HashMap< K, V >  {
    private class HMNode {
        K key;
        V value;

        public HMNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList< HMNode >[] buckets;
    private int size; // number of key-value pairs

    public HashMap() {
        initbuckets();
        size = 0;
    }

    private void initbuckets() {
        buckets = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    private int hash(K key) {
        int hc = key.hashCode();
        int bi = Math.abs(hc) % buckets.length;
        return bi;
    }

    private int getIndexWithinBucket(K key, int bi) {
        int di = 0;
        for (HMNode node : buckets[bi]) {
            if (node.key.equals(key)) {
                return di; // Key found
            }
            di++;
        }
        return -1; // Key not found
    }

    private void rehash() {
        ArrayList<HMNode>[] oldBuckets = buckets;
        initbuckets();
        size = 0;

        for (ArrayList <HMNode> bucket : oldBuckets) {
            for (HMNode node : bucket) {
                put(node.key, node.value);
            }
        }
    }

    public void put(K key, V value) {
        int bi = hash(key);
        int di = getIndexWithinBucket(key, bi);

        if (di != -1) {
            // Key found, update the value
            buckets[bi].get(di).value = value;
        } else {
            // Key not found, insert new key-value pair
            HMNode newNode = new HMNode(key, value);
            buckets[bi].add(newNode);
            size++;

            // Check for rehashing
            double lambda = size * 1.0 / buckets.length;
            if (lambda > 2.0) {
                rehash();
            }
        }
    }

    public V get(K key) {
        int bi = hash(key);
        int di = getIndexWithinBucket(key, bi);

        if (di != -1) {
            return buckets[bi].get(di).value;
        } else {
            return null;
        }
    }

    public boolean containsKey(K key) {
        int bi = hash(key);
        int di = getIndexWithinBucket(key, bi);

        return di != -1;
    }

    public V remove(K key) {
        int bi = hash(key);
        int di = getIndexWithinBucket(key, bi);

        if (di != -1) {
            // Key found, remove and return value
            size--;
            return buckets[bi].remove(di).value;
        } else {
            return null; // Key not found
        }
    }

    public int size() {
        return size;
    }

    public ArrayList<K> keyset() {
        ArrayList<K> keys = new ArrayList<>();
        for (ArrayList<HMNode> bucket : buckets) {
            for (HMNode node : bucket) {
                keys.add(node.key);
            }
        }
        return keys;
    }
}


