/**
 * Test RecursionHanoi and IterationHanoi
 * @author H9
 * @version 1.0
 */
public class HanoiTest{
    /**
     * Uses two way to play Hanoi
     * @param args A reference to a string array containing command-line arguments
     */
    public static void main(String[] args){
        //Runtime r = Runtime.getRuntime();
        //long t1 = r.totalMemory()/1024;
        //long f1 = r.freeMemory()/1024;
        long start_time1 = System.currentTimeMillis();
        System.out.println("Recursion:");
        new RecursiveHanoi(15);
        long end_start1 = System.currentTimeMillis();
        //long t2 = r.totalMemory()/1024;
        //long f2 = r.freeMemory()/1024;


        //Runtime r2 = Runtime.getRuntime();
        //long t12 = r2.totalMemory()/1024;
        //long f12 = r2.freeMemory()/1024;
        long start_time2 = System.currentTimeMillis();
        System.out.println("Iteration:");
        new IterativeHanoi(15);
        long end_start2 = System.currentTimeMillis();
        //long t22 = r.totalMemory()/1024;
        //long f22 = r.freeMemory()/1024;

        System.out.println("The time taken by the recursion algorithm is:" + (end_start1 - start_time1));
        System.out.println("The time taken by the iterative algorithm is:" + (end_start2 - start_time2));
        //System.out.println((t2-f2)-(t1-f1));
        //System.out.println((t22-f22)-(t12-f12));

    }
}