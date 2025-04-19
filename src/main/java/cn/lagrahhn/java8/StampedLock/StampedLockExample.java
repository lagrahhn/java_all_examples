package cn.lagrahhn.java8.StampedLock;

public class StampedLockExample {
    public static void main(String[] args) {
        // StampedLock支持乐观读锁和悲观读锁的升级和降级
        StampedLockFunc func = new StampedLockFunc();
        func.writeData(5);
        System.out.println("Optimistic Read: " + func.readDataOptimistically());
    }
}
