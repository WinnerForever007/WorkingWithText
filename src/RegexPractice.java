public class RegexPractice {
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


    }
}
