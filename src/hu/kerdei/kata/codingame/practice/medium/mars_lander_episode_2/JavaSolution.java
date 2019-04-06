import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

class Lander {

    boolean landing;
    boolean freeFall;

    Point pos;
    int hSpeed;
    int vSpeed;
    int fuel;
    int angle;
    int power;

    Output output;

    double verticalForce = 0;
    double verticalForceFromLastTurn = 0;


    Lander(Point pos, int hSpeed, int vSpeed, int fuel, int angle, int power) {
        this.pos = pos;
        this.hSpeed = hSpeed;
        this.vSpeed = vSpeed;
        this.fuel = fuel;
        this.angle = angle;
        this.power = power;
        output = new Output(angle, power);
    }
}

class Output {

    int angle;
    int power;

    Output(int angle, int power) {
        this.angle = angle;
        this.power = power;
    }
}

class Point {

    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Player {


    private static final double MARS_GRAVITY_MS = 3.711;
    private static final double PRE_CALCULATED_ANGLE_UNIT = 0.013_101_8;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        ArrayList<Point> marsSurface = new ArrayList<>();

        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            marsSurface.add(new Point(landX, landY));
        }
        Point landableSurface = searchForCenterPointOfTheLandingSite(marsSurface);

        // game loop
        while (true) {


            Lander lander = new Lander(
                    new Point(in.nextInt(), in.nextInt())
                    , in.nextInt()
                    , in.nextInt()
                    , in.nextInt()
                    , in.nextInt()
                    , in.nextInt());

            int forseeUntil = Math.abs(lander.hSpeed + lander.vSpeed);

            for (int i = 0; i < forseeUntil; i++) {
                play(lander, landableSurface);
                if (lander.pos.y < 0 || lander.landing || lander.freeFall) break;
            }
            System.out.println(lander.output.angle + " " + lander.output.power);

        }
    }

    private static Point searchForCenterPointOfTheLandingSite(ArrayList<Point> marsSurface) {
        //supposing that there is only one
        for (int i = 1; i < marsSurface.size(); i++) {

            Point pointBefore = marsSurface.get(i - 1);
            Point pointActual = marsSurface.get(i);
            if (pointBefore.y == pointActual.y) {

                int i1 = pointActual.x - pointBefore.x;
                if (i1 % 2 == 0) {
                    return new Point(pointBefore.x + i1 / 2, pointBefore.y);
                } else {
                    return new Point(pointBefore.x + 1 + i1 / 2, pointBefore.y);
                }
            }
        }
        return null;
    }

    //We want to forsee  the movement of the lander, so we have to simulate next turn
    private static void play(Lander lander, Point centerPointOfLandingSite) {
        //Choosing the right power from 0-4
        power(lander, centerPointOfLandingSite);
        //Choosing the right angle from -90 - 90
        rotate(lander, centerPointOfLandingSite);
        //Calculating new vectors
        move(lander);
        //adding the engine and environmental forces to the vectors
        end(lander);
    }

    //unique area of flat ground on the surface of Mars, which is at least 1000 meters wide.
    //landing site should be the center of this point
    private static boolean isNearLandingSite(Lander lander, Point centerPointOfLandingSite) {
        return (lander.pos.x < (centerPointOfLandingSite.x + 400)) && (lander.pos.x > (centerPointOfLandingSite.x - 400));
    }

    private static void power(Lander lander, Point centerPointOfLandingSite) {

        //If we are far from the landingPoint.Y we can inc  speed
        lander.freeFall = lander.pos.y > centerPointOfLandingSite.y + 1500 && Math.abs(lander.hSpeed) < 20;

        //Can safely accelerate
        if (lander.freeFall && lander.landing) {
            if (lander.vSpeed < -40) {
                lander.output.power = 4;
            } else {
                lander.output.power = 3;
            }
        } else {
            if (lander.vSpeed < -20) {
                lander.output.power = 4;
            } else {
                lander.output.power = 3;
            }
        }

        //Each turn the value of the actual power is limited to the value of the previous turn +/- 1.
        if (lander.output.power > lander.power) {
            lander.output.power = lander.power + 1;
        }
        if (lander.output.power < lander.power) {
            lander.output.power = lander.power - 1;
        }
    }


    private static void rotate(Lander lander, Point centerPointOfLandingSite) {

        if (isNearLandingSite(lander, centerPointOfLandingSite) && (Math.abs(lander.hSpeed) < 10)) {
            lander.output.angle = 0;
            lander.landing = true;
        } else if (lander.pos.x > centerPointOfLandingSite.x - 250) {
            if (lander.hSpeed > 50) {
                lander.output.angle = 30;
            } else {
                lander.output.angle = 22;
            }
        } else if (lander.pos.x < centerPointOfLandingSite.x + 250) {
            if (lander.hSpeed < -50) {
                lander.output.angle = -30;
            } else {
                lander.output.angle = -22;
            }
        }

        if (lander.landing) {
            lander.output.angle = 0;
        }
    }

    private static void move(Lander lander) {
        lander.pos.x += lander.hSpeed;
        lander.pos.y += lander.vSpeed;
    }

    private static void end(Lander lander) {

        //subtracting mars's gravity force from the vertical force,
        // and subtracting the ~horizontal force from the vertical force
        lander.verticalForce = (lander.power - MARS_GRAVITY_MS);
        double acc = Math.abs(lander.angle * PRE_CALCULATED_ANGLE_UNIT);
        lander.verticalForce -= acc;

        lander.verticalForceFromLastTurn += lander.verticalForce;

        //Calculating vSpeed and hSpeed for estimation
        while (lander.verticalForceFromLastTurn > 1) {
            lander.verticalForceFromLastTurn -= 1;
            lander.vSpeed++;
        }
        while (lander.verticalForceFromLastTurn < -1) {
            lander.verticalForceFromLastTurn += 1;
            lander.vSpeed--;
        }

        lander.power = lander.output.power;
        lander.angle = lander.output.angle;
    }
}



