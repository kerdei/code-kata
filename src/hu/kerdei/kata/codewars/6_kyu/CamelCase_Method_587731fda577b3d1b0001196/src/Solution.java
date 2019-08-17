public class Solution {

    public static String camelCase(String str) {
        String[] strings = str.split(" ");

        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > 0) {
                StringBuilder stringBuilder = new StringBuilder(strings[i]);
                stringBuilder.setCharAt(0, Character.toUpperCase(strings[i].charAt(0)));
                strings[i] = stringBuilder.toString();
            }
        }
        return String.join("", strings);
    }

}


//public class Solution {
//
//    public static String camelCase(String str) {
//        String[] strings = str.split(" ");
//
//        for (int i = 0; i < strings.length; i++) {
//            if (strings[i].length() > 0) {
//                strings[i] = Character.toUpperCase(strings[i].charAt(0)) + strings[i].substring(1);
//            }
//        }
//        return String.join("", strings);
//    }
//
//}

