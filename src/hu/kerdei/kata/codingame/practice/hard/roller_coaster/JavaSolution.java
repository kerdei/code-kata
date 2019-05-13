import java.util.*;

class Solution {

    private static Scanner in = new Scanner(System.in);
    private static ArrayDeque<Integer> queue;

    private static int L;  // Spaces in the rollleeercoaster
    private static int C;  // This many times the rolercoaster can function in one day
    private static int N;  // This many groups

    public static void main(String args[]) {
        readInput();
        long earnedMoney = calculateEarning();
        System.out.println(earnedMoney);
    }

    private static long calculateEarning() {
        long earnedMoney = 0;
        int firstInQueue;
        int remainingSpace;
        int groupNumberOnCoaster;

        for (int i = 0; i < C; i++) {

            remainingSpace = L;
            groupNumberOnCoaster = 0;

            while ((firstInQueue = queue.pollFirst()) <= remainingSpace && groupNumberOnCoaster < N) {
                remainingSpace -= firstInQueue;
                earnedMoney += firstInQueue;
                groupNumberOnCoaster++;
                queue.addLast(firstInQueue);
            }

            queue.addFirst(firstInQueue);
        }
        return earnedMoney;
    }

    private static void readInput() {
        L = in.nextInt();
        C = in.nextInt();
        N = in.nextInt();
        queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            queue.addLast(in.nextInt());
        }
    }
}