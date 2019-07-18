public class DnaStrand {
    public static String makeComplement(String dna) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < dna.length(); i++) {
            switch (dna.charAt(i)) {

                case 'A':
                    stringBuilder.append('T');
                    break;
                case 'T':
                    stringBuilder.append('A');
                    break;
                case 'C':
                    stringBuilder.append('G');
                    break;
                case 'G':
                    stringBuilder.append('C');
                    break;
            }
        }
        return stringBuilder.toString();
    }
}