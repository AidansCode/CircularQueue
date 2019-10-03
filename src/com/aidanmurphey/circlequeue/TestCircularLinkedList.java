package com.aidanmurphey.circlequeue;

public class TestCircularLinkedList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DLLCircularQueue<Integer> queue = new DLLCircularQueue<>();
        for (int i = 1; i <= 10; i++)
            queue.enqueue(i);
        queue.createCircle();
        System.out.println("----------");

        int current = queue.getCurrent();
        System.out.println(current + "?");
        current = queue.nextNode();
        System.out.println(current);
        queue.remove();
        System.out.println(queue.getCurrent());
        System.out.println(queue);
    }

}
