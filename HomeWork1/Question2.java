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

    public void DeleteRange(int start, int end) {
        if (start > end || this.isEmpty() || start < 0 || end < 0) {
            System.out.println("Couldn't complete action");
            return;
        }
    
        Node<T> tempStart = this.head;
        Node<T> prev = null; 
        int index = 0;
    
        while (index < start) {
            if (tempStart == null) {
                System.out.println("Index out of bound");
                return;
            }
            prev = tempStart;
            tempStart = tempStart.getNext();
            index++;
        }
    
        Node<T> tempEnd = tempStart;
        while (index <= end) {
            if (tempEnd == null) {
                System.out.println("Index out of bound");
                return;
            }
            tempEnd = tempEnd.getNext();
            index++;
        }
    
        if (start == 0) {
            this.head = tempEnd;  
        } else {
            prev.setNext(tempEnd); 
        }
    }
    

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
public class Question2 {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5); 
        // List: 5 -> 4 -> 3 -> 2 -> 1
        
        System.out.print("Original list: ");
        Node<Integer> tmp = list.getHead();
        while (tmp != null) {
            System.out.print(tmp.getItem() + " -> ");
            tmp = tmp.getNext();
        }
        System.out.println("null");

        list.DeleteRange(0, 2);

        System.out.print("After DeleteRange(0,2): ");
        tmp = list.getHead();
        while (tmp != null) {
            System.out.print(tmp.getItem() + " -> ");
            tmp = tmp.getNext();
        }
        System.out.println("null");
    }
}
