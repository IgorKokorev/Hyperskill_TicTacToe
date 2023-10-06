class ThreadProcessor {
    public static void findAndStartThread(Thread... threads) throws InterruptedException {
        // implement this method
        for (Thread thread: threads) {
            if (thread.getState().equals(Thread.State.NEW)) {
                thread = thread;
                thread.start();
                thread.join();
                break;
            }
        }
    }
}
