package com.aidanmurphey.circlequeue;

public interface QueueADT<Type> {
    /**
     * Mutator: enqueue -- adds an item to the queue (by definition, the element
     * is added to the "rear" of the queue (line) </br>
     */
    void enqueue(Type elem);

    /**
     * Mutator: dequeue -- removes an item from the "front" of the queue </br>
     */
    Type dequeue();

    /**
     * Accessor: first() -- returns a copy of the "front" of the queue without
     * removing it from the queueu
     */
    Type first();

    /**
     * Accessor: isEumpty() -- returns true/false indicator regarding whether or
     * not the queue is empty
     */
    boolean isEmpty();

    /**
     * Accessor: size() -- returns the count of items in the queue
     */
    int size();

    /**
     * Accessor: toString()
     */
    String toString();
}
