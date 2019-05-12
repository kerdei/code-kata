
import java.util.*;

/**
 *  "Upon entering a room, depending on the type of the room and Indy's entrance point (TOP,LEFT, or RIGHT) he will either exit the room through a specific exit point"
 *
 *  <br><br>
 *
 *  In the {@code tunnelHashMap} we store for each tunneltype, all entrance point's, and the key will be the exit point.
 *
 */
class Player {

    final static Map<TunelInput, Direction> tunnelHashMap;

    //Filling up default map values
    static {
        HashMap<TunelInput, Direction> tmp =
                new HashMap<>();

        tmp.put(new TunelInput(1, Direction.TOP), Direction.BOTTOM);
        tmp.put(new TunelInput(1, Direction.LEFT), Direction.BOTTOM);
        tmp.put(new TunelInput(1, Direction.RIGHT), Direction.BOTTOM);

        tmp.put(new TunelInput(2, Direction.RIGHT), Direction.LEFT);
        tmp.put(new TunelInput(2, Direction.LEFT), Direction.RIGHT);

        tmp.put(new TunelInput(3, Direction.TOP), Direction.BOTTOM);

        tmp.put(new TunelInput(4, Direction.TOP), Direction.LEFT);
        tmp.put(new TunelInput(4, Direction.RIGHT), Direction.BOTTOM);

        tmp.put(new TunelInput(5, Direction.TOP), Direction.RIGHT);
        tmp.put(new TunelInput(5, Direction.LEFT), Direction.BOTTOM);

        tmp.put(new TunelInput(6, Direction.LEFT), Direction.RIGHT);
        tmp.put(new TunelInput(6, Direction.RIGHT), Direction.LEFT);

        tmp.put(new TunelInput(7, Direction.TOP), Direction.BOTTOM);
        tmp.put(new TunelInput(7, Direction.RIGHT), Direction.BOTTOM);

        tmp.put(new TunelInput(8, Direction.LEFT), Direction.BOTTOM);
        tmp.put(new TunelInput(8, Direction.RIGHT), Direction.BOTTOM);

        tmp.put(new TunelInput(9, Direction.LEFT), Direction.BOTTOM);
        tmp.put(new TunelInput(9, Direction.TOP), Direction.BOTTOM);

        tmp.put(new TunelInput(10, Direction.TOP), Direction.LEFT);

        tmp.put(new TunelInput(11, Direction.TOP), Direction.RIGHT);

        tmp.put(new TunelInput(12, Direction.RIGHT), Direction.BOTTOM);

        tmp.put(new TunelInput(13, Direction.LEFT), Direction.BOTTOM);

        tunnelHashMap = Collections.unmodifiableMap(tmp);

    }

    private static Scanner in = new Scanner(System.in);
    static Integer[][] map;


    public static void main(String args[]) {
        readInputs();

        while (true) {
            nextTurn();
        }
    }

    private static void readInputs() {
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.

        if (in.hasNextLine()) {
            in.nextLine();
        }

        map = new Integer[W][H];

        for (int i = 0; i < H; i++) {
            String LINE = in.nextLine(); // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            String[] split = LINE.split(" ");

            for (int j = 0; j < split.length; j++) {
                map[j][i] = Integer.parseInt(split[j]);
            }
        }
        int EX = in.nextInt(); //Not used, but still need to read.
    }

    private static void nextTurn() {

        //Current round's inputs
        int XI = in.nextInt();
        int YI = in.nextInt();
        String POS = in.next();
        //

        int currentTunnelType = map[XI][YI];
        ;
        Direction exitDirection = getExitDirection(POS, currentTunnelType);
        String solution;

        switch (exitDirection) {
            case TOP: {
                YI--;
                solution = XI + " " + YI;
                break;
            }
            case LEFT: {
                XI--;
                solution = XI + " " + YI;
                break;
            }
            case RIGHT: {
                XI++;
                solution = XI + " " + YI;
                break;
            }
            case BOTTOM: {
                YI++;
                solution = XI + " " + YI;
            }
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + exitDirection);
        }
        System.out.println(solution);
    }

    private static Direction getExitDirection(String direction, int currentTunnelType) {
        return tunnelHashMap.get(new TunelInput(currentTunnelType, Direction.valueOf(direction)));
    }

}

class TunelInput {
    int type;
    Direction inputDirection; // where Andy comes from

    public TunelInput(int type, Direction inputDirection) {
        this.type = type;
        this.inputDirection = inputDirection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TunelInput that = (TunelInput) o;
        return type == that.type &&
                inputDirection == that.inputDirection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, inputDirection);
    }
}

enum Direction {
    LEFT, RIGHT, TOP, BOTTOM
}