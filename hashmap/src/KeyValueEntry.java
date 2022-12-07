import java.util.Objects;

public class KeyValueEntry<K, V> {

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
