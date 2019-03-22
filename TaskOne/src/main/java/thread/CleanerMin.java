package thread;

import data.CustomArray;

public class CleanerMin<E extends Comparable<E>> extends Thread {
    private CustomArray<E> data;

    public CleanerMin(CustomArray<E> data) {
        super(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                    }

                    E temp = data.getAndDeleteMin();
                    if (temp == null) {
                        System.out.println("The cleaner can't delete min element. Data is empty.");
                    } else {
                        System.out.println("The cleaner deleted min element. It is " + temp.toString());
                    }
                }
            }
        });
        this.data = data;
    }
}
