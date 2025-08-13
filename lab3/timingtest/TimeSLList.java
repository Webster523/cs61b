package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static int FIX_OPS = 10000;

    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        var list = new AList<Integer>();
        list.addLast(1000);
        list.addLast(2000);
        list.addLast(4000);
        list.addLast(8000);
        list.addLast(16000);
        list.addLast(32000);
        list.addLast(64000);
        list.addLast(128000);

        var times = new AList<Double>();
        var opsCount = new AList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            opsCount.addLast(FIX_OPS);
            int N = list.get(i);
            var temp = new SLList<Integer>();
            for (int j = 0; j < N; j++) {
                temp.addLast(j);
            }
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < FIX_OPS; j++) {
                temp.getLast();
            }
            times.addLast(sw.elapsedTime());
        }

        printTimingTable(list, times, opsCount);
    }

}
