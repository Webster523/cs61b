package deque;

public class LinkedListDeque<T> {
    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(T item) {
            this.prev = null;
            this.next = null;
            this.item = item;
        }
    }

    private final Node sentinel;
    private int size;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addFirst(T item) {
        this.size += 1;

        Node node = new Node(item);
        if (this.isEmpty()) {
            node.next = sentinel.next;
            sentinel.next = node;
            node.prev = sentinel;
            sentinel.prev = node;
        } else {
            node.next = sentinel.next;
            sentinel.next = node;
            node.prev = sentinel;
            node.next.prev = node;
        }
    }

    public void addLast(T item) {
        this.size += 1;

        Node node = new Node(item);
        if (this.isEmpty()) {
            node.next = sentinel.next;
            sentinel.next = node;
            node.prev = sentinel;
            sentinel.prev = node;
        } else {
            node.next = sentinel;
            sentinel.prev.next = node;
            node.prev = sentinel.prev;
            sentinel.prev = node;
        }
    }

    public void printDeque() {
        Node node = sentinel.next;
        while (node != sentinel) {
            System.out.print(node.item);

            if (node.next != sentinel) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
            node = node.next;
        }
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }

        this.size -= 1;

        Node node = sentinel.next;
        sentinel.next = node.next;
        node.next.prev = node.prev;
        return node.item;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        this.size -= 1;

        Node node = sentinel.prev;
        node.prev.next = node.next;
        sentinel.prev = node.prev;
        return node.item;
    }

    public T get(int index) {
        if (this.isEmpty() || index >= size) {
            return null;
        }

        Node node = sentinel.next;
        while (index != 0) {
            node = node.next;
            index -= 1;
        }

        return node.item;
    }

    public T getRecursive(int index) {
        if (this.isEmpty() || index >= size) {
            return null;
        }
        return getHelper(index, sentinel.next);
    }

    private T getHelper(int index, Node node) {
        if (index == 0) {
            return node.item;
        }
        return getHelper(index--, node.next);
    }

}
