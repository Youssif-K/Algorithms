package DataStructures;
/*
 * This is the implementation of the Queue with a one way linked list
 * Enqueuing an element is of time complexity O(1)
 * Dequeuing an element is of time complexity O(1) (because we point to the last element)
 */
public class Queue <T> {
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
    
}
