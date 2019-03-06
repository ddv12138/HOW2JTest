package tk.ddvudo.multiThread.ThreadState;

import java.util.LinkedList;
import java.util.Random;

public class ThreadSafeStack {

    LinkedList<String> heros = new LinkedList<String>();

    public static void main(String[] args) {

        ThreadSafeStack heroStack = new ThreadSafeStack();
        for (int i = 0; i < 5; i++) {
            String s = new Random().nextInt(10000) + "";
            System.out.println("压入 hero:" + s);
            heroStack.push(s);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("弹出 hero:" + heroStack.pull());
        }
    }

    public synchronized void push(String h) {
        heros.addLast(h);
    }

    public synchronized String pull() {
        return heros.removeLast();
    }

    public synchronized String peek() {
        return heros.getLast();
    }

}