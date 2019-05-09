import java.util.*;
import java.io.*;
import java.math.*;

class LightInfo {
    int distance;
    int duration;

    public LightInfo(int distance, int duration) {
        this.distance = distance;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "untilNextLight{" +
                "distance=" + distance +
                ", duration=" + duration +
                '}';
    }
}

class Solution {

    public static void main(String args[]) {

        ArrayList<LightInfo> untilNextLights = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int speed = in.nextInt();
        int lightCount = in.nextInt();

        System.err.println("maxspeed: " + speed);
        System.err.println("lightcount: " + lightCount);

        System.err.println("Lights info:");
        for (int i = 0; i < lightCount; i++) {
            untilNextLights.add(new LightInfo(in.nextInt(), in.nextInt()));
            System.err.println(untilNextLights);
        }

        int maxSpeed = speed;
        while (!everyLightIsGreenWhenArrive(untilNextLights, maxSpeed)) {
            maxSpeed -= 1;
        }
        System.out.println(maxSpeed);
    }

    private static boolean everyLightIsGreenWhenArrive(ArrayList<LightInfo> untilNextLights, int maxSpeed) {
        for (LightInfo untilNextLight : untilNextLights) {
            System.err.println(untilNextLight);

            double timeToReachNextLight = untilNextLight.distance / (maxSpeed / 3.6);
            System.err.println(timeToReachNextLight);

            int duration = untilNextLight.duration;
            System.err.println(timeToReachNextLight > duration);
            if (timeToReachNextLight > duration) {
                int i = 0;

                double currentDuration;
                for (currentDuration = duration; currentDuration <= timeToReachNextLight; currentDuration += duration) {
                    i++;
                }
                if (i % 2 == 1) return false;
            }
        }
        return true;
    }
}