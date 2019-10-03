package com.aidanmurphey.circlequeue;

public class DLLNode<T> {
    private T element;
    private DLLNode<T> next;
    private DLLNode<T> previous;

    /**
     * C O N S T R U C T O R
     * default set node and next to null
     */
    public DLLNode() {
        element = null;
        next = null;
    }

    /**
     * C O N S T R U C T O R
     * conversion set node to input element and and next to null
     */
    public DLLNode(T inElem) {
        element = inElem;
        next = null;
    }

    /**
     * Accessor: getElement()
     *
     * @return this DLLNode
     */
    public T getElement() {
        return element;
    }

    /**
     * Accessor: getNext()
     *
     * @return reference to next DLLNode
     */

    public DLLNode<T> getNext() {
        return next;
    }

    /**
     * Mutator: setNext( DLLNode<T> ptr)
     *
     * @return reference to next DLLNode
     */

    public void setNext(DLLNode<T> nodePtr) {
        next = nodePtr;
    }

    /**
     * Mutator: setElement(T inputElement) allow user/client to change the value
     * of the Node
     */
    public void setNode(T inElem) {
        element = inElem;
    }

    public DLLNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode<T> inPrv) {
        previous = inPrv;
    }
}
