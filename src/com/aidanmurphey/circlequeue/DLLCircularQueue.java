package com.aidanmurphey.circlequeue;

public class DLLCircularQueue<Type> implements QueueADT<Type> {
    private int count;
    private DLLNode<Type> head, tail, current;
    private boolean isCircle = false;

    /**
     * C O N S T R U C T O R
     */
    public DLLCircularQueue() {
        count = 0;
        head = tail = current = null;
    }

    /**
     * Mutator: enqueue() Add an element to the end of the queue (tail)
     */
    public void enqueue(Type elem) {
        DLLNode<Type> node = new DLLNode<Type>(elem);
        if (isEmpty()) // no item waiting in the queue currently
        {
            head = node;
            current = head;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);

            if (isCircle)
                head.setPrevious(node);
        }
        tail = node;
        count++;
    }

    /**
     * Mutator: dequeue() Removes the first item from the head of the queue
     */
    public Type dequeue() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue -- cannot dequeue");
        }
        Type result = head.getElement();

        if (isCircle) {
            head.getPrevious().setNext(head.getNext());
            head.getNext().setPrevious(head.getPrevious());
        }
        if (head == current)
            current = head.getNext();
        head = head.getNext();

        count--;
        if (count == 0) // empty queue
        {
            tail = null;
        }

        return result;
    }

    public void createCircle() {
        isCircle = true;
        tail.setNext(head);
        head.setPrevious(tail);
        current = head;
    }

    /**
     * Accessor first() -- returns a copy of the item at the front of the queue;
     * no remove
     *
     * @return copy of the element
     */
    public Type first() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue -- no front element");
        }

        Type result = head.getElement();
        return result;
    }

    /**
     * Accessor: isEmpty() indicates whether or not the queue has no elements
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Accessor size() reports the number of elements in the queue
     *
     * @return count of items in the queue
     */
    public int size() {
        return count;
    }

    /**
     * Returns the value of the current node
     *
     * @return The value of the current node
     */
    public Type getCurrent() {
        return current.getElement();
    }

    /**
     * Moves the current node to the next value and returns the new value
     *
     * @return The value of the next node
     */
    public Type nextNode() {
        if (isCircle && !isEmpty()) {
            current = current.getNext();
            return current.getElement();
        }

        throw new RuntimeException("The queue must be circular and not empty to call nextNode()");
    }

    /**
     * Removes the current node, returns its value, and moves to the next node in the circle
     *
     * @return The value of the current node
     */
    public Type remove() {
        Type element = null;
        if (isCircle && !isEmpty()) {

            if (size() == 1) {
                current = head = tail = null;
            } else {
                element = current.getElement();

                current.getNext().setPrevious(current.getPrevious());
                current.getPrevious().setNext(current.getNext());

                if (current == head)
                    head = current.getNext();

                current = current.getNext();
            }

            count--;
            return element;
        }

        throw new RuntimeException("The queue must be circular and not empty to call remove()");
    }

    /**
     * Accessor: toString() displays the contents of the queue: </br>
     * one element after the other from front to rear
     */
    public String toString() {
        String out = "";
        DLLNode<Type> current = head;
        if (current == null) {
            out += "Empty queue\n";
        } else {
            for (int i = 0; i < size(); i++) {
                out += current.getElement();
                out += "\n";
                current = current.getNext();
            }
        }

        return out;
    }
}
