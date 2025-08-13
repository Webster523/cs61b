package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        var buggyAList = new BuggyAList<Integer>();
        var noResizingList = new AListNoResizing<Integer>();

        buggyAList.addLast(4);
        buggyAList.addLast(5);
        buggyAList.addLast(6);

        noResizingList.addLast(4);
        noResizingList.addLast(5);
        noResizingList.addLast(6);

        buggyAList.removeLast();
        noResizingList.removeLast();
        assertEquals(buggyAList.get(0), noResizingList.get(0));
        assertEquals(buggyAList.get(1), noResizingList.get(1));

        buggyAList.removeLast();
        noResizingList.removeLast();
        assertEquals(buggyAList.get(0), noResizingList.get(0));

        buggyAList.removeLast();
        noResizingList.removeLast();
        assertEquals(buggyAList.size(), noResizingList.size());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        var buggyAList = new BuggyAList<Integer>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyAList.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                L.size();
                buggyAList.size();
            } else if (operationNumber == 2) {
                if (L.size() > 0) {
                    L.getLast();
                    buggyAList.getLast();
                }
            } else if (operationNumber == 3) {
                if (L.size() > 0) {
                    L.removeLast();
                    buggyAList.removeLast();
                }
            }
        }
    }
}
