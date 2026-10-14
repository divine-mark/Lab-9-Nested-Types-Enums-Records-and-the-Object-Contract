import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDemo<T> implements Iterable<T> {

    // STATIC NESTED: helper type, no need for an outer instance
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) { this.data = data; }
    }

    private Node<T> head;
    private int size = 0;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
    }

    public int size() { return size; }

    // INNER CLASS: has access to the outer instance's head field
    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = head; // reads outer's head

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) throw new NoSuchElementException();
            T value = current.data;
            current = current.next;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(); // inner class instantiation
    }

    public static void main(String[] args) {
        LinkedListDemo<String> list = new LinkedListDemo<>();
        list.add("alpha");
        list.add("beta");
        list.add("gamma");

        System.out.println("Size: " + list.size());

        // for-each relies on Iterable + Iterator
        System.out.print("Contents: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}