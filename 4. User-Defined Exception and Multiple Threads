import java.util.concurrent.Semaphore;

class Foo {

    private Semaphore second;
    private Semaphore third;

    public Foo() {
        second = new Semaphore(0);
        third = new Semaphore(0);
    }

    public void first(Runnable printFirst) {
        // printFirst.run() outputs "first".
        printFirst.run();
        second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        second.acquire();
        // printSecond.run() outputs "second".
        printSecond.run();
        third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        third.acquire();
        // printThird.run() outputs "third".
        printThird.run();
    }
}

/**
 * Your Foo object will be instantiated and called as such:
 * Foo obj = new Foo();
 * obj.first(printFirst);
 * obj.second(printSecond);
 * obj.third(printThird);
 */
