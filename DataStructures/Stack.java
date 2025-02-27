package DataStructures;
import java.util.Iterator;

/*
 * This is the implementation of the stack with a one way linked list
 * The poping and pushing actions are of complexity O(1)
 * Searching for elements is of time complexity O(N)
 */
public class Stack<T> implements Iterable<T> {
    private Node<T> first;

    public Stack() {
        this.first = null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.setNext(this.first);
        this.first = newNode;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T item = first.getItem();
        this.first = this.first.getNext();
        return item;
    }

    public void empStack() {
        this.first = null;
    }

    public Node<T> getFirstNode(){
        return this.first;
    }

    public void setFirstNode(Node<T> node){
        this.first = node;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T>{
        private Node<T> current;
        public StackIterator(){
            this.current = first;
        }
        @Override
        public boolean hasNext(){
            return this.current != null;
        }
        @Override
        public T next(){
            T item = this.current.getItem();
            this.current = this.current.getNext();
            return item;
        }
    }
}

