class FooBar {
    private int n;
    private boolean fooTurn = true;
    public FooBar(int n) {
        this.n = n;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            while (!fooTurn) {
                wait();
            }

            printFoo.run();
            fooTurn = false;
            notifyAll();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            while (fooTurn) {
                wait();
            }

            printBar.run();
            fooTurn = true;
            notifyAll();
        }
    }
}