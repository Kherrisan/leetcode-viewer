
class LRUCache {

    class Node {
        int value;
        int key;
        Node prev;
        Node succ;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> map = new HashMap();
    Node head;
    Node tail;
    int capacity;
    int size = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    void delete(Node n) {
        if (n.prev != null) {
            //n不是head
            n.prev.succ = n.succ;
        } else {
            head = n.succ;
        }
        if (n.succ != null) {
            //n 不是 tail
            n.succ.prev = n.prev;
        } else {
            tail = n.prev;
        }
        n.succ = n.prev = null;
    }

    void append(Node n) {
        if (head == null) {
            head = tail = n;
        } else {
            tail.succ = n;
            n.prev = tail;
            tail = n;
        }
    }

    public int get(int key) {
        System.out.println(key);
        if (!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        delete(n);
        append(n);
        return n.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            size++;
        if (size > capacity) {
            size--;
            map.remove(head.key);
            delete(head);
        }
            Node n = new Node(key, value);
            map.put(key, n);
            append(n);
        } else {
            Node n = map.get(key);
            n.value = value;
            delete(n);
            append(n);
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */