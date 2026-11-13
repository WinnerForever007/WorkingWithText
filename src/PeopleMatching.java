import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PeopleMatching {
    public static void main(String[] args) {
        String people = """
                Flintstone, Fred, 1/1/1900
                Rubble, Barney, 2/2/1905
                Flintstone, Wilma, 3/3/1910
                Rubble, Betty, 4/4/1915
                """;
        String regex = "^(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*" +
                "(?<dob>\\d{1,2}/\\d{1,2}/\\d{4})$";

        Pattern pat = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher mat = pat.matcher(people);
        while(mat.find()) {
           System.out.printf("%s %s, born %s%n", mat.group("firstName"),
                   mat.group("lastName"), mat.group("dob"));
           //Exercise 10
            System.out.printf("%s %d %d %s%n", mat.group("firstName"),
                    mat.start("firstName"), mat.end("firstName"),
                    people.substring(mat.start("firstName"), mat.end("firstName")));
        }
        mat.find(25);
        System.out.println(mat.group("firstName"));
        mat.find(52);
        System.out.println(mat.group("firstName"));

        System.out.println(mat.start());
        System.out.println(mat.end());
        System.out.println(mat.start("firstName"));
        System.out.println(mat.end("firstName"));

        //Exercise 1
        regex = "\\$\\d{1,2}[.]\\d{2}";
        String text = "$20.01";
        pat = Pattern.compile(regex);
        mat = pat.matcher(text);
        if(mat.matches()) {
            System.out.println(mat.group(0));
        }

        //Exercise 2
        pat = Pattern.compile("""
           # Parses the parts of a phone number
           (?:(?<countryCode>\\d{1,3})[-.,\\s]?)?   # gets country code
           (?:(?<areaCode>\\(\\d{3}\\)|\\d{3})[-.,\\s]?)         # gets area code
           (?:(?<exchange>\\d{3})[-.,\\s]?)         # gets exchange
           (?<lineNumber>\\d{4})                    # gets line number
            """, Pattern.COMMENTS);
        String phoneNumber = "(232) 333-2365";
        mat = pat.matcher(phoneNumber);
        if(mat.matches()) {
            System.out.printf("Country code: %s%n", mat.group("countryCode"));
            System.out.printf("Area code: %s%n", mat.group("areaCode"));
            System.out.printf("Exchange: %s%n", mat.group("exchange"));
            System.out.printf("Line number: %s%n", mat.group("lineNumber"));
        }

        //Exercise 3
        System.out.println("cat".matches("c.t"));
        System.out.println("coat".matches("c.t"));
        System.out.println("coat".matches("c.*t"));
        System.out.println("ct".matches("c.+t"));

        //Exercise 4
        regex = "cat";
        text = "cat concatenate cat, catalog cat";
        pat = Pattern.compile(regex);
        mat = pat.matcher(text);
        int count = 0;
        while(mat.find()) {
            count++;
        }
        System.out.println("Exercise 4: 1) " + count);
        count = 0;
        regex = "\\bcat\\b";
        pat = Pattern.compile(regex);
        mat = pat.matcher(text);
        while(mat.find()) {
            count++;
        }
        System.out.println("Exercise 4: 2) " + count);

        //Exercise 5
        regex = "\\S{5}";
        text = "12_fg";
        pat = Pattern.compile(regex);
        mat = pat.matcher(text);
        if(mat.matches()) {
            System.out.println(mat.group(0));
        }

        //Exercise 6 and 7
        //See TranscriptParser.java

        //Exercise 8
        regex = "\\[.+\\]";
        text = "[one] and [two]";
        pat = Pattern.compile(regex);
        mat = pat.matcher(text);
        while(mat.find()) {
            System.out.println("Greedy: " + mat.group(0));
        }
        regex = "\\[.+?\\]";
        pat = Pattern.compile(regex);
        mat = pat.matcher(text);
        while(mat.find()) {
            System.out.println("Lazy: " + mat.group(0));
        }
        regex = "\\[[^\\]]+\\]";
        pat = Pattern.compile(regex);
        mat = pat.matcher(text);
        while(mat.find()) {
            System.out.println("New: " + mat.group(0));
        }

        //Exercise 9
        regex = "\\b\\S+?@\\S+?\\.\\S+\\b";
        text = "dgfd@mail.ru fghfhgg fghfg try234@gmail.com";
        pat = Pattern.compile(regex);
        mat = pat.matcher(text);
        System.out.println("Exercise 9:");
        while(mat.find()) {
            System.out.println(mat.group(0));
        }

        //Exercise 10
        //see line 20

        //Exercise 11
        people = """
                Flintstone, Fred, 1/1/1900
                Rubble, Barney, 2/2/1905
                Flintstone, Wilma, 3/3/1910
                Rubble, Betty, 4/4/1915
                """;
        regex = "^(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*" +
                "(?<dob>\\d{1,2}/\\d{1,2}/\\d{4})$";

        pat = Pattern.compile(regex, Pattern.MULTILINE);
        mat = pat.matcher(people);
        if(mat.find(1)) {
            System.out.println(mat.group("lastName"));
        }



    }
}
