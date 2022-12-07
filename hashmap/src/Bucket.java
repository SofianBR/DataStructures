import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class Bucket<K, V> {

    /**
     * This class represents the array of entries. Each entry is a separated
     * linked list contaning on each node a pair of values (key, value).
     */

    private int size;
    private int capacity;
    private int thresholdValue;
    private LinkedList<KeyValueEntry<K, V>>[] entries;
    private final float LOAD_FACTOR = 0.75f;

    public Bucket() {
        size = 0;
        capacity = 16;
        thresholdValue = (int)(capacity * LOAD_FACTOR);
        entries = new LinkedList[capacity];
    }

    public LinkedList<KeyValueEntry<K, V>>[] getEntries() {
        return entries;
    }

    public V getEntry(K key) {
        int keyHash = Objects.hashCode(key);
        int index = hashFunction(keyHash);
        for (KeyValueEntry<K, V> entry : entries[index]) {
            if (Objects.equals(keyHash, entry.getHash())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public boolean removeEntry(K key) {
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

    public void addEntry(KeyValueEntry<K, V> entry) {
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
}
