import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

class Lander {

    Point pos;
    int hSpeed;
    int vSpeed;
    int fuel;
    int rotate;
    int power;

    double actualTurnVerticalAcceleration = 0;
    double verticalAcceleration = 0;

    public Lander(Point pos, int hSpeed, int vSpeed, int fuel, int rotate, int power) {
        this.pos = pos;
        this.hSpeed = hSpeed;
        this.vSpeed = vSpeed;
        this.fuel = fuel;
        this.rotate = rotate;
        this.power = power;
    }

    double atan2(Point p1, Point p2) {
        return Math.atan2(p1.y - p2.y, p1.x - p2.x) * 180 / Math.PI;
    }
}

class Output {

    double angle;
    double power;

    public Output() {
    }

    public Output(double angle, double power) {
        this.angle = angle;
        this.power = power;
    }
}

class Point {

    int x;
    int y;

    public Point(int x, int y) {
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


    public static final double MARS_GRAVITY_MS = 3.711;
    public static final double PRE_CALCULATED_ANGLE_UNIT = 0.013_101_8;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        ArrayList<Point> marsSurface = new ArrayList<>();

        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            marsSurface.add(new Point(landX, landY));
        }
        Point landableSurface = searchForLandingPoint(marsSurface);


        // game loop
        while (true) {
            Lander lander = new Lander(
                    new Point(in.nextInt(), in.nextInt())
                    , in.nextInt()
                    , in.nextInt()
                    , in.nextInt()
                    , in.nextInt()
                    , in.nextInt());

            Output output = new Output();
            Lander before = lander;

            play(lander, landableSurface);

            System.err.println(landableSurface);

            //Foresee/simulate pod movements
            for (int i = 0; i < 25; i++) {
                play(lander, landableSurface);
                //  System.err.println(lander.pos);
            }

            output.power = lander.power;
            output.angle = lander.rotate;

            System.out.println(((int) output.angle) + " " + ((int) output.power));
        }
    }

    private static Point searchForLandingPoint(ArrayList<Point> marsSurface) {

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

    private static void play(Lander lander, Point landingSite) {
        rotate(lander, landingSite);
        power(lander, landingSite);
        move(lander);
        end(lander);
    }

    private static void end(Lander lander) {
        lander.actualTurnVerticalAcceleration = (lander.power - MARS_GRAVITY_MS);
        double acc = Math.abs(lander.rotate * PRE_CALCULATED_ANGLE_UNIT);

        lander.actualTurnVerticalAcceleration -= acc;
        //System.err.println("Vacc" + lander.actualTurnVerticalAcceleration);
        int y = (int) lander.actualTurnVerticalAcceleration;
        lander.pos.y -= y;


        lander.verticalAcceleration += lander.actualTurnVerticalAcceleration;
        while (lander.verticalAcceleration > 1) {
            lander.verticalAcceleration -= 1;
            lander.hSpeed++;
        }
    }

    private static void move(Lander lander) {
        lander.pos.x += lander.hSpeed;
        lander.pos.y += lander.vSpeed;
    }

    private static void power(Lander lander, Point landingSite) {

        int oldPower = lander.power;


        //TODO


        if (oldPower > lander.power) {
            lander.power = oldPower - 1;
        }
        if (oldPower < lander.power) {
            lander.power = oldPower + 1;
        }

    }


    private static void rotate(Lander lander, Point landingSite) {

        //TODO


    }
}

import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

class Lander {

    Point pos;
    int hSpeed;
    int vSpeed;
    int fuel;
    int rotate;
    int power;

    double actualTurnVerticalAcceleration = 0;
    double verticalAcceleration = 0;

    public Lander(Point pos, int hSpeed, int vSpeed, int fuel, int rotate, int power) {
        this.pos = pos;
        this.hSpeed = hSpeed;
        this.vSpeed = vSpeed;
        this.fuel = fuel;
        this.rotate = rotate;
        this.power = power;
    }

    double atan2(Point p1, Point p2) {
        return Math.atan2(p1.y - p2.y, p1.x - p2.x) * 180 / Math.PI;
    }
}

class Output {

    double angle;
    double power;

    public Output() {
    }

    public Output(double angle, double power) {
        this.angle = angle;
        this.power = power;
    }
}

class Point {

    int x;
    int y;

    public Point(int x, int y) {
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


    public static final double MARS_GRAVITY_MS = 3.711;
    public static final double PRE_CALCULATED_ANGLE_UNIT = 0.013_101_8;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        ArrayList<Point> marsSurface = new ArrayList<>();

        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            marsSurface.add(new Point(landX, landY));
        }
        Point landableSurface = searchForLandingPoint(marsSurface);


        // game loop
        while (true) {
            Lander lander = new Lander(
                    new Point(in.nextInt(), in.nextInt())
                    , in.nextInt()
                    , in.nextInt()
                    , in.nextInt()
                    , in.nextInt()
                    , in.nextInt());

            Output output = new Output();
            Lander before = lander;

            play(lander, landableSurface);

            System.err.println(landableSurface);

            //Foresee/simulate pod movements
            for (int i = 0; i < 25; i++) {
                play(lander, landableSurface);
                //  System.err.println(lander.pos);
            }

            output.power = lander.power;
            output.angle = lander.rotate;

            System.out.println(((int) output.angle) + " " + ((int) output.power));
        }
    }

    private static Point searchForLandingPoint(ArrayList<Point> marsSurface) {

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

    private static void play(Lander lander, Point landingSite) {
        rotate(lander, landingSite);
        power(lander, landingSite);
        move(lander);
        end(lander);
    }

    private static void end(Lander lander) {
        lander.actualTurnVerticalAcceleration = (lander.power - MARS_GRAVITY_MS);
        double acc = Math.abs(lander.rotate * PRE_CALCULATED_ANGLE_UNIT);

        lander.actualTurnVerticalAcceleration -= acc;
        //System.err.println("Vacc" + lander.actualTurnVerticalAcceleration);
        int y = (int) lander.actualTurnVerticalAcceleration;
        lander.pos.y -= y;


        lander.verticalAcceleration += lander.actualTurnVerticalAcceleration;
        while (lander.verticalAcceleration > 1) {
            lander.verticalAcceleration -= 1;
            lander.hSpeed++;
        }
    }

    private static void move(Lander lander) {
        lander.pos.x += lander.hSpeed;
        lander.pos.y += lander.vSpeed;
    }

    private static void power(Lander lander, Point landingSite) {

        int oldPower = lander.power;


        //TODO


        if (oldPower > lander.power) {
            lander.power = oldPower - 1;
        }
        if (oldPower < lander.power) {
            lander.power = oldPower + 1;
        }

    }


    private static void rotate(Lander lander, Point landingSite) {

        //TODO


    }
}

