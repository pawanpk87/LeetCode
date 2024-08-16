class Foo {
    CountDownLatch waitForFirst;
    CountDownLatch waitForSecond;
    
    public Foo() {
        this.waitForFirst = new CountDownLatch(1);
        this.waitForSecond = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        waitForFirst.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        waitForFirst.await();
        printSecond.run();
        waitForSecond.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        waitForSecond.await();
        printThird.run();
    }
}