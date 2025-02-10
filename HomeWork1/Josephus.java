package HomeWork1;
//import DataStructures.*;
import java.util.Scanner;

class Node <T> {
    private T item;
    private Node <T> next;

    public Node(){
        this.item = null;
        this.next = null;
    }

    public Node(T item){
        this.item = item;
        this.next = null;
    }

    public T getItem(){
        return this.item;
    }
    
    public void setItem(T item){
        this.item = item;
    }
    
    public Node <T> getNext(){
        return this.next;
    }

    public void setNext(Node <T> next){
        this.next = next;
    }

}

class Queue <T> {
    private Node <T> first;
    private Node <T> last;
    private int size;

    public Queue(){
        this.first = null;
        this.last = null;
        this.size = 0;
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
        this.size ++;
    }

    public T dequeue(){
        if(!this.isEmpty()){
            T item = this.first.getItem();
            if(this.first == this.last){
                this.last = null;
            }
            this.first = this.first.getNext();
            this.size--;
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
    public int getSize(){
        return this.size;
    }
    
}

public class Josephus {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        if(M>N){
            M = M%N;
        }
        Queue <Integer> circle = new Queue<Integer>();
        for(int j = 0; j < N; j++){
            circle.enqueue(j);
        }
        System.out.print("Eleminated indecies:");
        while(circle.getSize() > 1){
            for(int i = 1; i < M; i++){
                circle.enqueue(circle.dequeue());
            }
            System.out.print(circle.dequeue());
            if(circle.getSize() > 1) {
                System.out.print(", ");
            }
        }

        System.out.println("\nAnd the surviving index is " + circle.dequeue());
        
    }
    
}
