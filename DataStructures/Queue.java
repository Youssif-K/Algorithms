package DataStructures;

import java.util.Iterator;

/*
 * This is the implementation of the Queue with a one way linked list
 * Enqueuing an element is of time complexity O(1)
 * Dequeuing an element is of time complexity O(1) (because we point to the last element)
 * Searching for elements is of time complexity O(N)
 * Enqueuing from last pointer
 * Dequeuing from first pointer
 */
public class Queue <T> implements Iterable<T>{
    private Node <T> first;
    private Node <T> last;

    public Queue(){
        this.first = null;
        this.last = null;
    }
    
    public boolean isEmpty(){
        return this.first == null;
    }

    public void enqueue(T item){
        Node <T>newNode = new Node<T>(item);
        if(this.last == null && this.first == null){
            this.first = newNode;
            this.last = newNode;
        }else{
            this.last.setNext(newNode);
            this.last = newNode;
        }    
    }

    public T dequeue(){
        if(!this.isEmpty()){
            T item = this.first.getItem();
            if(this.first == this.last){
                this.last = null;
            }
            this.first = this.first.getNext();
            return item;
        }
        return null;
    }

    public void emptyQueue(){
        this.first = null;
        this.last = null;
    }

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
        return last;
    }
    
    public Iterator<T> iterator(){
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T>{
        private Node<T> current;
        public QueueIterator(){
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
