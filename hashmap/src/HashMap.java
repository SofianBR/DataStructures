import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class HashMap<K, V> {

    /**
     * Author: Sofian Ben Hamman
     * Version: 1.1
     * Description: Own implementation of a HashMap.
     */

    private Bucket<K, V> bucket;

    public HashMap() {
        bucket = new Bucket<K, V>();
    }

    /**
     * Creates a relation between the key and his value. If this key previously existed, the value is replaced.
     * @param key: The key which the specified value is mapped to.
     * @param value: The value which the specified key is mapped to.
     */
    public void put(K key, V value) {
        KeyValueEntry<K, V> entry = new KeyValueEntry<>(key, value);
        bucket.addEntry(entry);
    }

    /**
     * Returns the value associated to a given Key (K), or 'null' if this map contains no key.
     * It's also possible that the value associated to the key is the value 'null'.
     * @param key: The key whose associated value will be returned.
     * @return Value to which the specified key is mapped to, or 'null' if there is no mapping on the given key.
     */
    public V get(K key) {
        return bucket.getEntry(key);
    }

    /**
     * Removes the mapping for the specified key.
     * @param key: Given key that belongs to a mapping whose must be removed.
     * @return True if the mapping is removed, false otherwise.
     */
    public boolean remove(K key) {
        return bucket.removeEntry(key);
    }

    /**
     * Returns a Set of the pairs values in the map. If the set is modified, so the HashMap will.
     * @return A set view of the map contained in the map.
     */
    public Set<KeyValueEntry<K, V>> entrySet() {
        Set<KeyValueEntry<K, V>> entrySet = new HashSet<>();
        for (LinkedList<KeyValueEntry<K, V>> listBucket : bucket.getEntries()) {
            if (listBucket != null) {
                entrySet.addAll(listBucket);
            }
        }
        return entrySet;
    }

}
