//https://www.codewars.com/kata/exes-and-ohs/

public class XO {

    public static boolean getXO(String str) {

        long xCount = str.toLowerCase().chars().boxed().filter(x -> x == 'x').count();
        long oCount = str.toLowerCase().chars().boxed().filter(x -> x == 'o').count();

        return oCount == xCount;
    }
}