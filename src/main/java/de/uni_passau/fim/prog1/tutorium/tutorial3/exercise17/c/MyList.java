package de.uni_passau.fim.prog1.tutorium.tutorial3.exercise17.c;

/**
 * Modify MyList and MyNode is order to allow for generic types.
 *
 * @author <a href=https://github.com/werli>Phil Werli<a/>
 */
@SuppressWarnings("Duplicates")
public class MyList<E> {
    private MyNode<E> front;
    private int size;

    /**
     * Appends a value to the list.
     *
     * @param value which will be appended to the list.
     */
    public void add(E value) {
        if (value == null) {
            return;
        }

        final MyNode<E> newNode = new MyNode<>(value);
        if (front == null) {
            front = newNode;
        } else {
            MyNode<E> node = front;

            // Knoten durchgehen bis zum Ende
            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(newNode);
        }
        size++;
    }

    /**
     * Inserts a value at the given position inside the list. All following elements will be of index i + 1.
     * If the position is greater than the lists size an {@link IndexOutOfBoundsException} will be thrown.
     *
     * @param value value which will be returned.
     * @param pos   position at which the value will be inserted.
     * @throws IndexOutOfBoundsException when the position is {@code < 0} or {@code > size()}.
     */
    public void add(E value, int pos) throws IndexOutOfBoundsException {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Position is out of bounds.");
        } else if (pos == 0) {
            final MyNode<E> newFront = new MyNode<>(value);
            newFront.setNext(front);
            front = newFront;
        } else {
            MyNode<E> node = front;
            for (int i = 0; i < pos - 1; i++) {
                node = node.getNext();
            }

            final MyNode<E> nextNode = node.getNext();
            final MyNode<E> newNode = new MyNode<>(value);
            node.setNext(newNode);
            newNode.setNext(nextNode);
        }
        size++;
    }

    /**
     * Returns the value at the given position.
     *
     * @param pos position of the value
     * @return value at the given position
     */
    public E get(int pos) {
        if (pos >= size) {
            return null;
        }

        MyNode<E> node = front;
        for (int i = 0; i < pos; i++) {
            node = node.getNext();
        }
        return node.getData();
    }

    /**
     * Returns the amount of elements in the list.
     *
     * @return amount of list elements.
     */
    public int size() {
        return size;
    }

    /**
     * Returns whether the list is empty.
     *
     * @return {@code true} if list is empty otherwise returns {@code false}
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Prints the elements of in the list as follows
     * <p>
     * {@code [element_0>,<element_1>,...,<element_n-1>,<element_n>]}
     */
    public void print() {
        if (isEmpty()) {
            System.out.println("[]");
        }

        final StringBuilder builder = new StringBuilder();
        builder.append('[');

        MyNode node = front;
        while (node.getNext() != null) {
            builder.append(node.getData());
            builder.append(", ");
            node = node.getNext();
        }
        builder.append(node.getData());

        builder.append(']');

        String output = builder.toString();
        System.out.println(output);
    }

    /**
     * Removes the node at the given position.
     *
     * @param pos position of the node which will be deleted.
     * @return {@code true} if deletion was successful.
     * Returns {@code false} otherwise.
     */
    public boolean remove(int pos) {
        if (pos < 0 || pos >= size) {
            return false;
        }
        if (pos == 0) {
            front = front.getNext();
        } else {
            MyNode<E> node = front;
            for (int i = 0; i < (pos - 1); i++) {
                node = node.getNext();
            }

            MyNode<E> removeNode = node.getNext();
            MyNode<E> next = removeNode.getNext();

            node.setNext(next);
        }

        size--;
        return true;
    }

    /**
     * Entfernt alle Elemente aus der Liste.
     */
    public void clear() {
        /*
        * Abkoppeln des ersten Listenknotens ist genug, da die restlichen Listenelemente
        * ohne den ersten Knoten nicht mehr "gefunden" werden können. Sie werden vom
        * Garbage Collector zur Laufzeit entfernt.
        */
        front = null;
        size = 0;
    }
}
