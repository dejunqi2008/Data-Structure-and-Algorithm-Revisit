package map;

public class ListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node next;
        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ": " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public ListMap() {
        dummyHead = new Node();
        size = 0;
    }



    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size += 1;
        } else {
            node.value = value;
        }
    }

    @Override
    public void set(K key, V val) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException("Key Error: element does not exist.");
        }
        node.value = val;
    }


    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        Node cur = dummyHead.next;
        while (prev != null && cur != null) {
            if (cur.key.equals(key)) {
                prev.next = cur.next;
                cur.next = null;
                size -= 1;
                return cur.value;
            }
            prev = prev.next;
            cur = cur.next;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return null;
    }

    /******************** private members  ****************/

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }




}
