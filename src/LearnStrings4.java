public class LearnStrings4 {
    public static void main(String[] args) {
        String myText = "Four score and seven years ago";
        System.out.println(myText.indexOf("seven"));
        String abc = "ABCDEFGABCDEFG";
        System.out.println(abc.indexOf("car"));
        System.out.println(abc.indexOf("ABC"));
        System.out.println(abc.indexOf("abc"));
        System.out.println(abc.indexOf(65));
        System.out.println(abc.indexOf('A'));
        System.out.println(abc.indexOf(122));

        System.out.println(abc.lastIndexOf("A"));
        System.out.println(abc.indexOf('A', 2));
        System.out.println(abc.indexOf('A', 0));

        String phoneNumber = "(234) 333-5551";
        System.out.println(parseAreaCode(phoneNumber) + " "
        + parseExchange(phoneNumber) + " " + parseLineNumber(phoneNumber));

        String colors = "red,green,blue";
        String[] parts = colors.split(",");
        System.out.println(parts.length);
        System.out.println(parts[0]);
        System.out.println(parts[2]);

        String text = """
                Flintstone, Fred, 1/1/1900, 123 Rock St, Bedrock, CA
                Rubble, Barney, 2/2/1905, 456 Stone Ave, Bedrock, CA
                Jetson, George, 3/3/2062, 555 No St, Orbit City, NY
                """;
        String[] people = text.split("\n");
        System.out.println(people.length);
        System.out.println(people[2]);
        String[] george = people[2].split(",");
        System.out.println(george[3]);
        String[] limited = text.split("\n", 2);
        System.out.println(limited.length);
        System.out.println(limited[1]);

        System.out.println("1.2.3".split(".").length);
        System.out.println("1.2.3".split("\\.").length);

        String fileName = "myfile.txt";
        System.out.println(fileName.endsWith("txt"));
        System.out.println(fileName.endsWith(".txt"));
        System.out.println(fileName.endsWith("doc"));
        fileName = "file001.txt";
        System.out.println(fileName.startsWith("file"));
        System.out.println("zfile001.txt".startsWith("file"));

        fileName = " file001.txt".strip();
        System.out.println(fileName.startsWith("file"));

        String firstText = "Apple";
        StringBuilder secondText = new StringBuilder("Apple");
        System.out.println(firstText.contentEquals(secondText));
        System.out.println(firstText.equals(secondText));

        //Exercise 1
        myText = "the cat sat on the mat";
        System.out.println(myText.indexOf("the") + " " + myText.lastIndexOf("the") +
                " " + myText.indexOf("dog") + " " +
                myText.indexOf("at", myText.indexOf("at") + 1));

        //Exercise 2
        myText = "Ada King Lovelace";
        int firstSpace = myText.indexOf(" ");
        int secondSpace = myText.lastIndexOf(" ");
        String middleName = myText.substring(firstSpace + 1, secondSpace);
        System.out.printf("%d %d %s%n", firstSpace, secondSpace, middleName);

        //Exercise 3
        String email = "jake@example.com";
        System.out.println(getUser(email) + " " + getDomain(email));

        //Exercise 4
        phoneNumber = "234-333-5551";
        phoneNumber = phoneNumber.substring(0, phoneNumber.indexOf("-")) +
                phoneNumber.substring(phoneNumber.indexOf("-") + 1,
                        phoneNumber.lastIndexOf("-")) +
                phoneNumber.substring(phoneNumber.lastIndexOf("-") + 1);
        System.out.println(phoneNumber);

        //Exercise 5
        //parseAreaCode("234 333-5551");
        //Exercise 6
        myText = "Java is really fun";
        String[] myArray = myText.split(" ");
        System.out.println(myArray.length + " " + myArray[myArray.length - 1]);

        //Exercise 7
        text = """
                Flintstone, Fred, 1/1/1900, 123 Rock St, Bedrock, CA
                Rubble, Barney, 2/2/1905, 456 Stone Ave, Bedrock, CA
                Jetson, George, 3/3/2062, 555 No St, Orbit City, NY
                """;
        String[] people1 = text.split("\n");
        String[] fred1 = people1[0].split(", ");
        String[] rubble1 = people1[1].split(", ");
        String[] george1 = people1[2].split(", ");
        System.out.printf("%s %s%n %s %s%n %s %s%n", fred1[1], fred1[4],
                rubble1[1], rubble1[4], george1[1], george1[4]);

        //Exercise 8
        myText = "192.168.1.10";
        String[] ipNumbers = myText.split("\\.");
        System.out.printf("%s %s %s %s%n", ipNumbers[0], ipNumbers[1],
                ipNumbers[2], ipNumbers[3]);

        //Exercise 9
        myText = "Report_2026.PDF";
        String myTextLowerCase = myText.toLowerCase();
        System.out.println(myTextLowerCase.startsWith("report") + " " +
                myTextLowerCase.endsWith(".pdf"));

        //Exercise 10
        String javaString = "Java";
        StringBuilder javaStringBuilder = new StringBuilder("Java");
        System.out.printf("%b %b %b%n", javaString.equals(javaStringBuilder),
                javaString.contentEquals(javaStringBuilder),
                javaStringBuilder.toString().equals(javaString));

        //Exercise 11
        String name = "John";
        int age = 21;
        System.out.println("%s is %d years old".formatted(name, age));


    }

    public static String getUser(String email) {
        if(!email.contains("@")) {
            return "";
        }
        return email.substring(0, email.indexOf("@"));
    }

    public static String getDomain(String email) {
        if(!email.contains("@")) {
            return "";
        }
        return email.substring(email.indexOf("@") + 1);
    }

    public static String parseAreaCode(String text) {
        return text.substring(text.indexOf("(") + 1, text.indexOf(")"));
    }

    public static String parseExchange(String text) {
        text = text.strip();
        return text.substring(text.indexOf(" ") + 1, text.indexOf("-"));
    }

    public static String parseLineNumber(String text) {
        return text.substring(text.indexOf("-") + 1);
    }

}
