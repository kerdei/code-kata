import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Meeting {

    static class Name {

        String firstName;
        String lastName;

        @Override
        public String toString() {
            return "(" + lastName + ", " + firstName + ")";
        }

        Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        String getFirstName() {
            return firstName;
        }

        String getLastName() {
            return lastName;
        }
    }

    public static String meeting(String s) {
        return Stream.of(s.toUpperCase().split(";"))
                .map(x -> {
                    String[] split = x.split(":");
                    return new Name(split[0], split[1]);
                }).sorted(Comparator.comparing(Name::getLastName).thenComparing(Name::getFirstName))
                .map(Name::toString).collect(Collectors.joining());
    }
}
