class Foo {
    boolean onedone;
    boolean twodone;

    public Foo() {
        onedone = false;
        twodone = false;
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        onedone = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {
        while(!onedone){
            wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        twodone = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        while(!twodone){
            wait();
        }
        printThird.run();
    }
}