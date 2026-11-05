import java.text.Collator;
import java.util.Locale;

public class LearnStrings2 {
    public static void main(String[] args) {
        String myText = "This is my awesome furf text. What a furf day!";
        System.out.println(myText);
        System.out.println(myText.replace("furf", "nice"));
        System.out.println(myText.replace("FURF", "nice"));
        System.out.println(myText.replace('e', 'z'));

        String firstName = "   Jake   ";
        System.out.printf("'%s'%n", firstName);
        System.out.printf("'%s'%n", firstName.strip());
        System.out.printf("'%s'%n", firstName.stripLeading());
        System.out.printf("'%s'%n", firstName.stripTrailing());
        String wide = "\u2003Jake\u2003";
        System.out.println(wide.trim().length());
        System.out.println(wide.trim());
        System.out.println(wide.strip().length());
        String html = "<div>\n" +
                "   <p>Hello</p>\n" +
                "</div>\n";
        String html2 = """
                <div>
                    <p>Hello</p>
                </div>
                """;
        System.out.println(html2);
        String raw = "   <div>\n    <p>Hi</p>\n   </div>";
        System.out.println(raw.stripIndent());

        System.out.printf("'%s'%n", strip(firstName));

        myText = "apples";
        System.out.println(myText.charAt(3));
        int length = myText.length();
        if(length > 9) {
            System.out.println(myText.charAt(9));
        }

        String firstWord = "Apple";
        String secondWord = "Banana";
        System.out.println(firstWord.compareTo(secondWord));

        System.out.println("Apple".compareTo("apple"));
        System.out.println("Apple".compareToIgnoreCase("apple"));
        System.out.println("가나".compareTo("나가"));
        System.out.println("가나".compareTo("가"));
        System.out.println("école".compareTo("fille"));

        Collator french = Collator.getInstance(Locale.FRENCH);
        System.out.println(french.compare("école", "fille"));

        System.out.println(compareToIgnoreCase("Apple", "apple"));

        //Exercise 1
        myText = "Darn it, this darn code!";
        myText = myText.toLowerCase().replace("darn", "****");
        System.out.println(myText);

        //Exercise 2
        myText = "Java is fun";
        myText = myText.replace(' ', '_');
        System.out.println(myText);

        //Exercise 3
        myText = " hello world ";
        System.out.printf("'%s' '%s' '%s'%n", myText.strip(), myText.stripLeading(),
                myText.stripTrailing());

        //Exercise 4
        myText = """
                12312 12321
                Hello
                123
                """;
        System.out.println(myText);

        //Exercise 5
        System.out.println(strip(" Mary Ann "));
        System.out.println(strip("\tJake"));

        //Exercise 6
        System.out.println(firstAndLast("apples"));
        System.out.println(firstAndLast("") + " " + firstAndLast(null));

        //Exercise 7
        firstName = "Jake";
        String lastName = "Smith";
        if ((firstName != null && !firstName.isEmpty()) ||
        (lastName != null && !lastName.isEmpty())) {
            String result = "" + firstName.charAt(0) + ".";
            result += lastName.charAt(0) + ".";
            System.out.println(result);
        }

        //Exercise 8
        System.out.println("cat".compareTo("dog") + " " + "dog".compareTo("cat") +
                " " + "Cat".compareTo("cat") + " " + "car".compareTo("cart") +
                " " + "Zoo".compareTo("apple"));

        //Exercise 9
        String var1 = "100";
        String var2 = "25";
        Integer iVar1 = Integer.parseInt(var1);
        Integer iVar2 = Integer.parseInt(var2);
        System.out.println(var1.compareTo(var2) + " " + var2.compareTo(var1) +
                " " + iVar1.compareTo(iVar2) + " " + iVar2.compareTo(iVar1));

        //Exercise 10
        Collator french1 = Collator.getInstance(Locale.FRENCH);
        System.out.println(french1.compare("été", "ferme"));
        System.out.println("été".compareTo("ferme"));


    }

    public static String firstAndLast(String text) {
        if("".equals(text) || text == null) {
            return "";
        }
        return "" + text.charAt(0) + text.charAt(text.length() - 1);
    }

    public static String strip(String text) {
        int start = 0;
        int end = text.length();
        while(start < end && Character.isWhitespace(text.charAt(start))) {
            start++;
        }
        while(end > start && Character.isWhitespace(text.charAt(end - 1))) {
            end--;
        }

        return text.substring(start, end);
    }

    public static int compareToIgnoreCase(String text1, String text2) {
        String lowerText1 = text1.toLowerCase();
        String lowerText2 = text2.toLowerCase();
        return lowerText1.compareTo(lowerText2);
    }

}
