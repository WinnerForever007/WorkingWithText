public class RegexPractice2 {
    public static void main(String[] args) {
        System.out.println("doggie".matches("......"));
        System.out.println("doggie".matches("..."));
        System.out.println("12345".matches("^.....$"));
        System.out.println("12345".matches("^..$"));
        System.out.println("cat dog".matches("...\\b\\s\\b..."));
        System.out.println("cat dog".matches("...\\b..."));

        System.out.println("cat".matches("\\W\\W\\W"));
        System.out.println("---".matches("\\W\\W\\W"));
        System.out.println("123".matches("\\W\\W\\W"));
        System.out.println("abc".matches("\\D\\D\\D"));
        System.out.println(".".matches("\\S"));
        System.out.println("".matches("\\S"));


    }
}
