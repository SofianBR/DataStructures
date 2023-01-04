import java.util.*;

public class HashMap<K, V> {

    /**
     * Author: Sofian Ben Hamman
     * Version: 1.2
     * Description: Own implementation of a HashMap.
     */

    private int size;
    private int capacity;
    private int thresholdValue;
    private LinkedList<KeyValueEntry<K, V>>[] entries;
    private final float LOAD_FACTOR = 0.75f;

    public HashMap() {
        size = 0;
        capacity = 16;
        thresholdValue = (int)(capacity * LOAD_FACTOR);
        entries = new LinkedList[capacity];
    }

    private int hashFunction(int hash) {
        return hash & (capacity - 1);
    }

    private void resizeAndRehash() {
        if (size < thresholdValue) {
            return;
        }
        capacity *= 2;
        LinkedList<KeyValueEntry<K, V>>[] copy = entries;
        entries = new LinkedList[capacity];
        for (LinkedList<KeyValueEntry<K, V>> copyListBucket : copy) {
            if (copyListBucket != null) {
                for (KeyValueEntry<K, V> entry : copyListBucket) {
                    int index = hashFunction(entry.getHash());
                    if (entries[index] == null) {
                        entries[index] = new LinkedList<>();
                    }
                    entries[index].add(entry);
                }
            }
        }
    }

    /**
     * Creates a relation between the key and his value. If this key previously existed, the value is replaced.
     * @param key: The key which the specified value is mapped to.
     * @param value: The value which the specified key is mapped to.
     */
    public void put(K key, V value) {
        KeyValueEntry<K, V> entry = new KeyValueEntry<>(key, value);
        int index = hashFunction(entry.getHash());
        if (entries[index] == null) {
            entries[index] = new LinkedList<>();
        }
        boolean found = false;
        Iterator<KeyValueEntry<K, V>> it = entries[index].iterator();
        while (!found && it.hasNext()) {
            KeyValueEntry<K, V> node = it.next();
            if (node.equals(entry)) {
                node.setValue(entry.getValue());
                found = true;
            }
        }
        if (!found) {
            entries[index].add(entry);
            size++;
        }
        resizeAndRehash();
    }

    /**
     * Returns the value associated to a given Key (K), or 'null' if this map contains no key.
     * It's also possible that the value associated to the key is the value 'null'.
     * @param key: The key whose associated value will be returned.
     * @return Value to which the specified key is mapped to, or 'null' if there is no mapping on the given key.
     */
    public V get(K key) {
        int keyHash = Objects.hashCode(key);
        int index = hashFunction(keyHash);
        for (KeyValueEntry<K, V> entry : entries[index]) {
            if (Objects.equals(keyHash, entry.getHash())) {
                return entry.getValue();
            }
        }
        return null;
    }

    /**
     * Removes the mapping for the specified key.
     * @param key: Given key that belongs to a mapping whose must be removed.
     * @return True if the mapping is removed, false otherwise.
     */
    public boolean remove(K key) {
        int keyHash = Objects.hashCode(key);
        int index = hashFunction(keyHash);
        int i = 0;
        boolean found = false;
        while (!found && i < size) {
            KeyValueEntry<K, V> entry = entries[index].get(i);
            if (Objects.equals(keyHash, entry.getHash())) {
                entries[index].remove(i);
                found = true;
            }
            i++;
        }
        return found;
    }

    /**
     * Returns A LinkedList of the pairs values in the map.
     * @return A LinkedList of the entries contained in the map.
     */
    public LinkedList<KeyValueEntry<K, V>>[] getEntries() {
        return entries;
    }

    /**
     * Returns a Set of the pairs values in the map. If the set is modified, so the HashMap will.
     * @return A set view of the map contained in the map.
     */
    public Set<KeyValueEntry<K, V>> entrySet() {
        Set<KeyValueEntry<K, V>> entrySet = new HashSet<>();
        for (LinkedList<KeyValueEntry<K, V>> listBucket : entries) {
            if (listBucket != null) {
                entrySet.addAll(listBucket);
            }
        }
        return entrySet;
    }

    private static class KeyValueEntry<K, V> {

        /**
         * This class represents the pair of values (key, value).
         */

        private K key;
        private V value;
        private int hash;

        public KeyValueEntry(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = hashCode();
        }

        public K getKey() {
            return this.key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public int getHash() {
            return this.hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            KeyValueEntry<?, ?> that = (KeyValueEntry<?, ?>) o;
            return Objects.equals(hash, that.hash);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(key);
        }
    }

}
