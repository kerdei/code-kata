class TenMinWalk {

    public static boolean isValid(char[] walk) {

        if (walk.length != 10) {
            return false;
        }

        int x = 0;
        int y = 0;

        for (char c : walk) {
            switch (c) {
                case 'n':
                    y++;
                    break;
                case 's':
                    y--;
                    break;
                case 'e':
                    x++;
                    break;
                case 'w':
                    x--;
                    break;
            }
        }
        return x == 0 && y == 0;
    }

}
