class FooBar {
    private int n;
    private Object lock;
    private Boolean isFooTurn;

    public FooBar(int n) {
        this.n = n;
        this.lock = new Object();
        this.isFooTurn = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while(isFooTurn == false) {
                    lock.wait();
                }

                printFoo.run();

                isFooTurn = false;

                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while(isFooTurn == true) {
                    lock.wait();
                }

                printBar.run();

                isFooTurn = true;

                lock.notifyAll();
            }
        }
    }
}