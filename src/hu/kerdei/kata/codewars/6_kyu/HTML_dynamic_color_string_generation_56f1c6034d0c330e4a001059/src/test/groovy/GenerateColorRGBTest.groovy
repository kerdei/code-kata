import spock.lang.Specification

class GenerateColorRGBTest extends Specification {


    def "GenerateColor"() {
        setup:
            Random random = new Random()
        when:
            //Generate a valid randomly generated hexadecimal color string. Assume all of them always have 6 digits.
            List<String> codes = new ArrayList<>()
            for (i in 0..<10) {
                codes.add(GenerateColorRGB.generateColor(random))
            }

        then:
            codes.every {
                it.size() == 7
                it.matches("#([a-fA-F0-9]{6})")
            }
    }
}
