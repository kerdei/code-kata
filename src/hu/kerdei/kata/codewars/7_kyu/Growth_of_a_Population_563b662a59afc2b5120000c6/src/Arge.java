class Arge {
    public static int nbYear(int p0, double percent, int aug, int p) {
        int count = 0;
        double percentDivided = percent / 100;
        while (p0 < p) {
            p0 += p0 * percentDivided + aug;
            count++;
        }
        return count;
    }
}