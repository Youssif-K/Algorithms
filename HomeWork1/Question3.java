package HomeWork1;
import DataStructures.*;

class SinglyLinkedList<T> {
    private Node<T> head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNext(head);
        this.head = newNode;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            Node<T> temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }
    
    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
public class Question3 {
    public static int max(Node<Integer> firstNode){
        if(firstNode == null){
            return 0;
        }else{
            
            Node <Integer> tmp = firstNode;
            int max = tmp.getItem();
            while(tmp != null){
                if(tmp.getItem() > max){
                    max = tmp.getItem();
                }
                tmp = tmp.getNext();
            }
            return max;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(35);
        list.addFirst(455);
        list.addFirst(500); 

        System.out.println("The maxmim number of the listing is:" + max(list.getHead()));
    }
}
