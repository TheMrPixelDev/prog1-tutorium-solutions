package de.uni_passau.fim.prog1.tutorium.tutorial4.exercise17;

public class MyQueue {
    private MyNode front;
    private int size;

    /**
     * Enqueue a single element at the front of the queue.
     *
     * @param value which will be enqueued
     */
    public void add(final int value) {
        final MyNode newNode = new MyNode(value);
        if (front == null) {
            front = newNode;
        } else {
            newNode.setNext(front);
            front = newNode;
        }
        size++;
    }

    /**
     * Dequeue a single element at the end and return its value.
     *
     * @return value from the end of the queue
     * @throws Exception
     */
    public int get() throws Exception {
        if (front == null) {
            throw new Exception("Empty Queue!");
        }

        if (size == 1) {
            size--;
            final int value = front.getValue();
            front = null;
            return value;
        }

        MyNode prevNode = null;
        MyNode currentNode = front;
        while (currentNode.getNext() != null) {
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
        assert prevNode != null;
        prevNode.setNext(null);
        size--;
        return currentNode.getValue();
    }


    /**
     * Getter for the queues current length
     *
     * @return length of queue
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append("[");
        MyNode currentNode = front;
        while (currentNode != null) {
            str.append(currentNode.getValue());
            currentNode = currentNode.getNext();
            if (currentNode != null) {
                str.append(", ");
            }
        }
        str.append("]");
        return str.toString();
    }
}
