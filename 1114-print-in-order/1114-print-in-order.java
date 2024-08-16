class Foo {
    boolean isFirstPrinted;
    boolean isSecondPrinted;
    
    public Foo() {
        this.isFirstPrinted = false;
        this.isSecondPrinted = false;
    }

    synchronized public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        isFirstPrinted = true;
        notifyAll();
    }

    synchronized public void second(Runnable printSecond) throws InterruptedException {
        while(!isFirstPrinted) {
            wait();
        }
        printSecond.run();
        isSecondPrinted = true;
        notifyAll();
    }

    synchronized public void third(Runnable printThird) throws InterruptedException {
        while(!isSecondPrinted) {
            wait();
        }
        printThird.run();
    }
}