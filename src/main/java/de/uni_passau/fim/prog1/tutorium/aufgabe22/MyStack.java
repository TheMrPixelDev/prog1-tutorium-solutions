package de.uni_passau.fim.prog1.tutorium.aufgabe22;

public class MyStack {
    private MyNode front;
    private int size;

    /**
     * Size of the stack
     *
     * @return amounth of element on stack
     */
    public int size() {
        return size;
    }

    /**
     * Pushes a single value onto the stack.
     *
     * @param value to push to the stack
     */
    public void add(final int value) {
        final MyNode neuerKnoten = new MyNode(value);
        neuerKnoten.setNext(front);
        front = neuerKnoten;
        size++;
    }

    /**
     * Pops a single item off the stack and returns it.
     *
     * @return popped element
     * @throws Exception
     */
    public int get() throws Exception {
        if (front == null) {
            throw new Exception("Empty Stack!");
        }

        final int value = front.getValue();
        front = front.getNext();
        size--;
        return value;
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
