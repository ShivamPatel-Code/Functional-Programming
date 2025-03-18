package programming;

import java.util.stream.LongStream;

public class Parallelizing {

    public static void main(String[] args) {


        // w/o parallel, time = 380
        // w parallel, time = 107
        long time = System.currentTimeMillis();
        System.out.println(LongStream.range(0, 1000000000).parallel().sum());
        System.out.println(System.currentTimeMillis()-time);


    }
}
