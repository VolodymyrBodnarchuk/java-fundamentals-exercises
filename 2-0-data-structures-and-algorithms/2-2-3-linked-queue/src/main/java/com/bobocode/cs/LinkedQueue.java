package com.bobocode.cs;


/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 * <p>
 *
 * @param <T> a generic parameter
 * @author Taras Boychuk
 * @author Ivan Virchenko
 */
public class LinkedQueue<T> implements Queue<T> {

    static class Node<T>{
        T element;
        Node<T> next;
        public Node(T element){
            this.element = element;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Adds an element to the end of the queue.
     *
     * @param element the element to add
     */
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
         if(size == 0){
             head = tail =  newNode;
         } else {
             tail.next = newNode;
             tail = newNode;
         }
         size++;
    }

    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    public T poll() {
        T removeElement;
        if(!isEmpty()) {
            removeElement = head.element;
            head = head.next;
            tail = null;
            size--;
            return removeElement;
        }

        if(isEmpty()){
            return null;
        }
        return head.element;
    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    public int size() {
        if(head == null && tail == null || size == 0){
            return size = 0;
        }
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    public boolean isEmpty() {
        if(head == null && tail == null || size == 0){
            return true ;
        }
        return false;
    }
}
