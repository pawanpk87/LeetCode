class Foo {
    private boolean oneDone;
    private boolean secondDone;
    
    public Foo() {
        oneDone = false;
        secondDone = false;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        oneDone = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while(!oneDone) {
            wait();
        }
        printSecond.run();
        secondDone = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        while(!secondDone) {
            wait();
        }
        printThird.run();
    }
}