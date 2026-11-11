import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPractice {

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("""
           # Parses the parts of a phone number
           (?:(?<countryCode>\\d{1,3})[-.,\\s]?)?   # gets country code
           (?:\\(?(?<areaCode>\\d{3})\\)?[-.,\\s]?)         # gets area code
           (?:(?<exchange>\\d{3})[-.,\\s]?)         # gets exchange
           (?<lineNumber>\\d{4})                    # gets line number
            """, Pattern.COMMENTS);

    //= Pattern.compile("232.333.2365");

    public static void main(String[] args) {
        System.out.println("cat".matches("cat"));
        System.out.println("Cat".matches("cat"));
        System.out.println("my cat".matches("cat"));
        System.out.println("Cat".matches("[cC]at"));
        System.out.println("cat".matches("[cC]at"));
        System.out.println("bat".matches("[cC]at"));
        System.out.println("Bat".matches("[cCbB]at"));
        System.out.println("dat".matches("[a-f]at"));
        System.out.println("gat".matches("[a-f]at"));
        System.out.println("Fat".matches("[a-fA-F]at"));
        System.out.println("Yat".matches("[a-fA-Fw-zW-Z]at"));
        System.out.println("cat".matches("[^c]at"));
        System.out.println("Cat".matches("[^c]at"));
        System.out.println("&at".matches("[^c]at"));
        System.out.println("flat".matches("[^c]at"));
        System.out.println("lat".matches("[^a-z]at"));
        System.out.println("Lat".matches("[^a-z]at"));

        System.out.println("lat".matches("\\wat"));
        System.out.println("_at".matches("\\wat"));
        System.out.println("7at".matches("\\wat"));
        System.out.println("-at".matches("\\wat"));
        System.out.println("éat".matches("\\wat"));

        System.out.println("1".matches("\\d"));
        System.out.println("z".matches("\\d"));
        System.out.println("321".matches("\\d\\d\\d"));

        String phone = "321-333-7652";
        System.out.println(phone.matches("\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d"));
        System.out.println(phone.matches("\\d{3}-\\d{3}-\\d{4}"));

        String regex = "\\d{3}[-.]\\d{3}[-.]\\d{4}";
        System.out.println("321.333.7652".matches(regex));
        System.out.println("321-333-7652".matches(regex));
        System.out.println("321,333,7652".matches(regex));
        regex = "\\d{3}[-.,\\s]\\d{3}[-.,\\s]\\d{4}";
        System.out.println("321 333 7652".matches(regex));
        System.out.println("321-333,7652".matches(regex));
        regex = "\\d{3}[-.,\\s]+\\d{3}[-,.\\s]+d{4}";
        System.out.println("321   333   7652".matches(regex));
        System.out.println("3213337652".matches(regex));
        regex = "\\d{3}[-.,\\s]*\\d{3}[-.,\\s]*\\d{4}";
        System.out.println("3213337652".matches(regex));
        System.out.println("321 333   7652".matches(regex));
        System.out.println("321z333 7652".matches(regex));
        regex = "\\d{3}[-.,\\s]?\\d{3}[-.,\\s]?\\d{4}";
        System.out.println("321 333 7652".matches(regex));
        System.out.println("3213337652".matches(regex));
        System.out.println("321  333 7652".matches(regex));
        regex = "\\d{3}[-.,\\s]?\\d{3}[-.,\\s]\\d{3,4}";
        System.out.println("321-333-765".matches(regex));
        System.out.println("321-333-76522".matches(regex));
        regex = "(\\d{3}[-.,\\s]?){2}\\d{4}";
        System.out.println("321-333-7652".matches(regex));
        System.out.println("333-7652".matches(regex));
        regex = "(\\d{3}[-.,\\s]?){1,2}\\d{4}";
        System.out.println("333-7652".matches(regex));
        System.out.println("321.333.7652".matches(regex));

        regex = "\\d[-.,\\s]?(\\d{3}[-.,\\s]?){1,2}\\d{4}";
        System.out.println("1.321.333.7652".matches(regex));

        regex = "(1[-.,\\s]?)?(\\d{3}[-.,\\s]?){1,2}\\d{4}";
        System.out.println("1.321.333.7652".matches(regex));
        System.out.println("321.333.7652".matches(regex));
        System.out.println("4.321.333.7652".matches(regex));

        //Exercise 1
        regex = "colou?r";
        System.out.println("colouur".matches(regex));

        //Exercise 2
        regex = "[gG]r[ea]y";
        System.out.println("Gray".matches(regex) + " " + "gray".matches(regex) +
                " " + "Groy".matches(regex));

        //Exercise 3
        regex = "[aeiouy]";
        System.out.println("a".matches(regex) + " " +"b".matches(regex));

        //Exercise 4
        regex = "\\D{3}";
        System.out.println("1bc".matches(regex) + " " + "aF-".matches(regex));

        //Exercise 5
        regex = "\\d{5}(-\\d{4})?";
        System.out.println("90210".matches(regex) + " " + "90210-1234".matches(regex) +
                " " + "90210.1234".matches(regex));

        //Exercise 6
        regex = "\\d{1,2}:\\d{2}";
        System.out.println("9:05".matches(regex) + " " + "14:30".matches(regex) +
                " " + "14:1".matches(regex));

        //Exercise 7
        regex = "\\w{3,16}";
        System.out.println("Hi".matches(regex) + " " + "Group345".matches(regex));

        //Exercise 8
        regex = "[A-Z]{3}-\\d{5}-[A-Z]";
        System.out.println("ABC-12345-X".matches(regex) + " " + "abc-12345-X".matches(regex));

        //Exercise 9
        regex = "[hH]ello\\s* world";
        System.out.println("hello world".matches(regex) + " " + "hello   world".matches(regex));

        //Exercise 10
        regex = "(1[-.,\\s]?)?(\\d{3}[-.,\\s]?){1,2}\\d{4}";
        System.out.println("1.222.3333.123".matches(regex));
        System.out.println("2.321.333.7652".matches(regex));
        System.out.println("1-321-456,4321".matches(regex));
        System.out.println("1,333,222,5678".matches(regex));
        System.out.println("1.-222--333323".matches(regex));
        System.out.println("2,321,366.3652".matches(regex));
        System.out.println("1,321,456,4321".matches(regex));
        System.out.println("1.333.222.234d".matches(regex));
        System.out.println("13214564321".matches(regex));
        System.out.println("1-(321)-456-4321".matches(regex));

        //Exercise 11
        regex = "1\\.5";
        System.out.println("1.5".matches(regex) + " " + "1x5".matches(regex));


        //The sixth lecture: Extracting with Capture Groups
        regex = "(1[-.,\\s]?)?(\\d{3}[-.,\\s]?){1,2}\\d{4}";
        String phoneNumber = "232.333.2365";
        System.out.println(phoneNumber.matches(regex));
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(phoneNumber);
        if(mat.matches()) {
            System.out.println(mat.group(1));
            System.out.println(mat.group(2));
            System.out.println(mat.group(0));
        }

        regex = "(1[-.,\\s]?)?(\\d{3}[-.,\\s]?)(\\d{3}[-.,\\s]?)(\\d{4})";
        phoneNumber = "1.232.333.2365";
        pat = Pattern.compile(regex);
        mat = pat.matcher(phoneNumber);
        if(mat.matches()) {
            System.out.println(mat.group(0));
            System.out.println(mat.group(1));
            System.out.println(mat.group(2));
            System.out.println(mat.group(3));
            System.out.println(mat.group(4));
        }

        //regex = "((\\d{1,3})[-.,\\s]?)?((\\d{3})[-.,\\s]?)((\\d{3})[-.,\\s]?)(\\d{4})";
        //regex = "(?:(\\d{1,3})[-.,\\s]?)?(?:(\\d{3})[-.,\\s]?)(?:(\\d{3})[-.,\\s]?)(\\d{4})";
        regex = "(?:(?<countryCode>\\d{1,3})[-.,\\s]?)?(?:(?<areaCode>\\d{3})[-.,\\s]?)" +
                "(?:(?<exchange>\\d{3})[-.,\\s]?)(?<lineNumber>\\d{4})";
        phoneNumber = "12.232.333.2365";
        pat = Pattern.compile(regex);
        mat = pat.matcher(phoneNumber);
        if(mat.matches()) {
            System.out.printf("Country code: %s%n", mat.group(1));
            System.out.printf("Area code: %s%n", mat.group(2));
            System.out.printf("Exchange: %s%n", mat.group(3));
            System.out.printf("Line number: %s%n", mat.group(4));
            System.out.printf("Country code: %s%n", mat.group("countryCode"));
            System.out.printf("Area code: %s%n", mat.group("areaCode"));
            System.out.printf("Exchange: %s%n", mat.group("exchange"));
            System.out.printf("Line number: %s%n", mat.group("lineNumber"));
        }

        pat = Pattern.compile(regex, Pattern.COMMENTS);
        boolean b = Pattern.compile("I am good", Pattern.COMMENTS).
                matcher("I am good").matches();
        System.out.println(b);
        b = Pattern.compile("I\\sam\\sgood", Pattern.COMMENTS).
                matcher("I am good").matches();
        System.out.println(b);

        regex = """
           # Parses the parts of a phone number
           (?:(?<countryCode>\\d{1,3})[-.,\\s]?)?   # gets country code
           (?:(?<areaCode>\\d{3})[-.,\\s]?)         # gets area code
           (?:(?<exchange>\\d{3})[-.,\\s]?)         # gets exchange
           (?<lineNumber>\\d{4})                    # gets line number
            """;

        phoneNumber = "12.232.333.2365";
        pat = Pattern.compile(regex, Pattern.COMMENTS);
        mat = pat.matcher(phoneNumber);
        if(mat.matches()) {
            System.out.printf("Country code: %s%n", mat.group("countryCode"));
            System.out.printf("Area code: %s%n", mat.group("areaCode"));
            System.out.printf("Exchange: %s%n", mat.group("exchange"));
            System.out.printf("Line number: %s%n", mat.group("lineNumber"));
        }

        System.out.println("CAT".matches("(?i)cat"));

        //Exercise 1
        regex = "((a) (b(c)))";
        String abc = "abc";
        mat = getMatcher(regex, abc);
        if(mat.matches()) {
            System.out.println(mat.group(0));
            System.out.println(mat.group(1));
            System.out.println(mat.group(2));
            System.out.println(mat.group(3));
            System.out.println(mat.group(4));
        }

        //Exercise 2
        regex = "(\\w\\w-?){3}";
        String text = "ab-cd-ef";
        mat = getMatcher(regex, text);
        if(mat.matches()) {
            System.out.println(mat.group(1));
        }

        //Exercise 3
        regex = "(?<year>\\d{4})-(?<month>0[1-9]|1[0-2])-(?<day>0[1-9]|[12]\\d|3[01])";
        text = "2026-09-27";
        mat = getMatcher(regex, text);
        if(mat.matches()) {
            System.out.println(mat.group("year"));
            System.out.println(mat.group("month"));
            System.out.println(mat.group("day"));
        }

        //Exercise 4
        regex = "(?<year>\\d{4})(?<sep>[-./])(?<month>0[1-9]|1[0-2])" +
                "\\k<sep>(?<day>0[1-9]|[12]\\d|3[01])";
        text = "2026.09.27";
        mat = getMatcher(regex, text);
        if(mat.matches()) {
            System.out.println(mat.group("year"));
            System.out.println(mat.group("month"));
            System.out.println(mat.group("day"));
        }

        //Exercise 5
        regex = "(?<user>[\\w.]+)@(?<domain>[\\w.]+)";
        text = "jake@example.com";
        mat = getMatcher(regex, text);
        if(mat.matches()) {
            System.out.println(mat.group(0));
            System.out.println(mat.group("user"));
            System.out.println(mat.group("domain"));
        }

        //Exercise 6
        regex = """
           # Parses the parts of a phone number
           (?:(?<countryCode>\\d{1,3})[-.,\\s]?)?   # gets country code
           (?:\\(?(?<areaCode>\\d{3})\\)?[-.,\\s]?)         # gets area code
           (?:(?<exchange>\\d{3})[-.,\\s]?)         # gets exchange
           (?<lineNumber>\\d{4})                    # gets line number
            """;
        phoneNumber = "(232) 333-2365";
        mat = getMatcher(regex, phoneNumber);
        if(mat.matches()) {
            System.out.printf("Country code: %s%n", mat.group("countryCode"));
            System.out.printf("Area code: %s%n", mat.group("areaCode"));
            System.out.printf("Exchange: %s%n", mat.group("exchange"));
            System.out.printf("Line number: %s%n", mat.group("lineNumber"));
        }

        //Exercise 7
        System.out.println("Exercise 7");
        printPhoneParts("(232) 333-2365");
        printPhoneParts("12.232.333.2365");
        printPhoneParts("1.232.333.2365");

        //Exercise 8
        regex = "[a-z]{3}\\d{2}";
        text = "abc12";
        pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        mat = pat.matcher(text);
        if(mat.matches()) {
            System.out.println(mat.group(0));
        }
        text = "ABC12";
        mat = pat.matcher(text);
        if(mat.matches()) {
            System.out.println(mat.group(0));
        }
        regex = "(?i)[a-z]{3}\\d{2}";
        pat = Pattern.compile(regex);
        mat = pat.matcher(text);
        if(mat.matches()) {
            System.out.println(mat.group(0));
        }
        text = "abc12";
        mat = pat.matcher(text);
        if(mat.matches()) {
            System.out.println(mat.group(0));
        }

        //Exercise 9
        regex = "hello\\sworld";
        text = "hello world";
        pat = Pattern.compile(regex, Pattern.COMMENTS);
        mat = pat.matcher(text);
        if(mat.matches()) {
            System.out.println(mat.group(0));
        }
        regex = "hello\\ world";
        pat = Pattern.compile(regex, Pattern.COMMENTS);
        mat = pat.matcher(text);
        if(mat.matches()) {
            System.out.println(mat.group(0));
        }

        //Exercise 10
        regex = """
                (?<year>\\d{4})(?<sep>[-./])              # gets year
                (?<month>0[1-9]|1[0-2])                     # gets month
                \\k<sep>(?<day>0[1-9]|[12]\\d|3[01])    # gets day
        """;
        text = "2026.09.27";
        mat = getMatcher(regex, text);
        if(mat.matches()) {
            System.out.println(mat.group("year"));
            System.out.println(mat.group("month"));
            System.out.println(mat.group("day"));
        }



    }

    public static void printPhoneParts(String phoneNumber) {
        Matcher mat = PHONE_PATTERN.matcher(phoneNumber);
        if(mat.matches()) {
            System.out.printf("Country code: %s%n", mat.group("countryCode"));
            System.out.printf("Area code: %s%n", mat.group("areaCode"));
            System.out.printf("Exchange: %s%n", mat.group("exchange"));
            System.out.printf("Line number: %s%n", mat.group("lineNumber"));
        }
    }

    public static Matcher getMatcher(String regex, String text) {
        Pattern pat = Pattern.compile(regex, Pattern.COMMENTS);
        return pat.matcher(text);
    }

}
