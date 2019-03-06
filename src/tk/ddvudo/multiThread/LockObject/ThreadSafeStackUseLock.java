package tk.ddvudo.multiThread.LockObject;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeStackUseLock<T> {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private LinkedList<T> list = new LinkedList<>();

    public T pull() {
        T t = null;
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                while (list.size() == 0) {
                    condition.await();
                }
                t = list.removeLast();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            condition.signalAll();
            lock.unlock();
        }
        return t;
    }

    public void push(T obj) {
        try {
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                while (list.size() >= 200) {
                    condition.await();
                }
                list.addLast(obj);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            condition.signalAll();
            lock.unlock();
        }
    }

    public int size() {
        return list.size();
    }

    public Object peek() {
        return list.getLast();
    }
}
