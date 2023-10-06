class ThreadUtil {
    static void printNameOfTerminatedThread(Thread[] threads) {
        // implement the method
        for (Thread thread: threads) {
            if (thread.getState().equals(Thread.State.TERMINATED)) {
                System.out.printf(thread.getName());
            }
        }
    }
}
