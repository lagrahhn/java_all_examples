package cn.lagrahhn.java8.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockFunc {
    private final StampedLock lock = new StampedLock();
    private int data = 0;

    public void writeData(int newData) {
        long stamp = lock.writeLock(); // 获取写锁
        try {
            data = newData;
        } finally {
            lock.unlock(stamp); // 释放写锁
        }
    }

    public int readDataOptimistically() {
        long stamp = lock.tryOptimisticRead(); // 获取乐观读锁
        int data = this.data;
        if (!lock.validate(stamp)) { // 检查乐观读锁是否有效
            stamp = lock.readLock(); // 获取悲观读锁
            try {
                data = this.data;
            } finally {
                lock.unlock(stamp); // 释放悲观读锁
            }
        }
        return data;
    }
}
