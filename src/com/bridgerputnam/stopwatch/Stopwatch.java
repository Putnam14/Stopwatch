package com.bridgerputnam.stopwatch;

public class Stopwatch {
    public void run(Runnable r) {
        run(r, 1);
    }

    public void run(Runnable r, int samples) {
        long start;
        long end;
        int ms = 0;
        for(int i = 0; i < samples; i++) {
            start = System.nanoTime();
            r.run();
            end = System.nanoTime();
            ms += (int) (end - start)/1000;
        }
        if(samples > 1) {
            System.out.printf("Method took %dms on average, over %d calls.\n",ms/samples,samples);
        } else {
            System.out.printf("Method took %dms on average.\n", ms/samples);
        }
    }

    public static void main(String[] args) {
        new Stopwatch();
    }
}
