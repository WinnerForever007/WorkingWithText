import java.util.Locale;

public class LearnStrings3 {
    public static void main(String[] args) {
        String myText = "Four score and seven years ago";
        System.out.println(myText.contains("seven"));
        System.out.println(myText.contains("sevens"));
        System.out.println(myText.contains("Seven"));
        System.out.println(myText.toLowerCase().contains("four score"));

        String text1 = "This is my text one";
        String text2 = "This is my text two";
        System.out.println(text1 + " " + text2);
        System.out.println("Total: " + (5 + 5));
        System.out.println(5 + 5 + " total");

        System.out.println(text1.concat(" ").concat(text2));
        System.out.println("Hello ".concat(text1));

        int totalLength = text1.length() + text2.length() + 1;
        String finalString = new StringBuilder(totalLength).append(text1).append(" ")
                .append(text2).toString();
        System.out.println(finalString);

        System.out.format("%s %s%n", text1, text2);
        String combined = String.format("%s %s", text1, text2);
        System.out.println(combined);

        myText = "Four score and seven years ago";
        System.out.println(myText.length());
        System.out.println("Fou".length());
        System.out.println("".length());

        myText = "Fou";
        int index = 100;
        if (index < myText.length()) {
            System.out.println(myText.charAt(index));
        }
        String secondText = "score";
        StringBuilder builder = new StringBuilder(myText.length() +
                secondText.length());
        builder.append(myText).append(secondText);
        System.out.println(builder);

        myText = "apple";
        System.out.println(myText.substring(0));
        System.out.println(myText.substring(1));
        System.out.println(myText.substring(0, 1));
        System.out.println(myText.substring(1, 3));
        System.out.println(myText.substring(2, 4));

        String date = "2026-09-27";
        String year = date.substring(0, 4);
        String month = date.substring(5, 7);
        String day = date.substring(8);

        myText = "apple";
        String myNewText = myText.substring(0, 1).toUpperCase() +
                myText.substring(1);
        System.out.println(myNewText);
        myNewText = myText.substring(0, 1).toUpperCase()
                .concat(myText.substring(1));
        System.out.println(myNewText);

        String firstPart = myText.substring(0, 1);
        String secondPart = myText.substring(1);
        String capitalFirstLetter = firstPart.toUpperCase();
        myNewText = capitalFirstLetter.concat(secondPart);

        totalLength = capitalFirstLetter.length() + secondPart.length();
        myNewText = new StringBuilder(totalLength).append(capitalFirstLetter)
                .append(secondPart).toString();

        //Exercise 1
        myText = "Please reset my password";
        System.out.println(myText.contains("password"));
        System.out.println(myText.contains("Password"));
        System.out.println(myText.toLowerCase().contains("password"));

        //Exercise 2
        String firstName = "Jake";
        String lastName = "Smith";
        System.out.println("Hello, " + firstName + " " + lastName + "!");
        String result = String.format("Hello, %s %s!", firstName, lastName);
        System.out.println(result);

        //Exercise 3
        System.out.println("Sum: " + 2 + 3);
        System.out.println(2 + 3 + " sum");
        System.out.println("Sum: " + (2 + 3));

        //Exercise 4
        StringBuilder sb1 = new StringBuilder();
        sb1.append("red, ");
        sb1.append("green, ");
        sb1.append("blue");
        System.out.println(sb1);

        //Exercise 5
        System.out.println(new StringBuilder().capacity());
        System.out.println(new StringBuilder().append("12345678901234567890").capacity());

        //Exercise 6
        System.out.println("Ihnat".length() + " " + "Ihnat".charAt("Ihnat".length() - 1));

        //Exercise 7
        System.out.println(safeCharAt("123123", 8));
        System.out.println(safeCharAt("123123", 3));

        //Exercise 8
        myText = "JavaScript";
        System.out.println(myText.substring(4) + " " + myText.substring(0, 4) +
                " " + myText.substring(2, 6) + " " + myText.substring(10));

        //Exercise 9
        myText = "ABC-12345-X";
        System.out.printf("%s %s %s%n", myText.substring(0, 3),
                myText.substring(4, 9), myText.substring(myText.length() - 1));

        //Exercise 10
        System.out.println(capitalize("jAVA") + " " + capitalize(null) +
                " " + capitalize(""));

        //Exercise 11
        myText = "ada lovelace";
        System.out.println(myText.substring(0, 1).toUpperCase() + "." +
                myText.substring(myText.indexOf(" ") + 1, myText.indexOf(" ") + 2)
                        .toUpperCase() + ".");

    }

    public static String capitalize(String word) {
        if(word != null && !word.isEmpty()){
            return word.substring(0, 1).toUpperCase() +
                    word.substring(1).toLowerCase();
        }
        return "";
    }

    public static char safeCharAt(String text, int index) {
        if(text != null && index < text.length() && index >= 0) {
            return text.charAt(index);
        } else {
            return '?';
        }
    }

}
