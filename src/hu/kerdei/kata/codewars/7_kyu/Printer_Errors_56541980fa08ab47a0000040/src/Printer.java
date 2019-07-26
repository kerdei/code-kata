public class Printer {

    public static String printerError(String s) {
        long badCount =  s.chars().filter(x -> x > 109).count();
        return badCount + "/" + s.length();
    }
}