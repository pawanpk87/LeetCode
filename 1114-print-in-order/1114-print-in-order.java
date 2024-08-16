class Foo {
    private int count;
    
    public Foo() {
        this.count = 1;    
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (this) {
            printFirst.run();
            count++;
            notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while(count < 2) {
                wait();
            }
            printSecond.run();
            count++;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while(count < 3) {
                wait();
            }
            printThird.run();
        }
    }
}