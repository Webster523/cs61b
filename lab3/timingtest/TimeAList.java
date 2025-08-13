package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
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
        for (int i = 0; i < list.size(); i++) {
            int N = list.get(i);
            Stopwatch sw = new Stopwatch();
            var temp = new AList<Integer>();
            for (int j = 0; j < N; j++) {
                temp.addLast(j);
            }
            times.addLast(sw.elapsedTime());
        }

        printTimingTable(list, times, list);
    }
}
