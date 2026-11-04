import java.util.Locale;

public class LearnStrings {
    public static void main(String[] args) {
        String fruit = "Apple";
        String anotherFruit = "Apple";
        String vegetable = new String("Broccoli");
        String anotherVegetable = new String("Broccoli");
        System.out.println(fruit == anotherFruit);
        System.out.println(vegetable == anotherVegetable);
        System.out.println(vegetable.equals(anotherVegetable));
        System.out.println(fruit.equals(anotherFruit));

        String myText = "abcdefg";
        System.out.println(myText.toUpperCase());
        String myText2 = "ABCDEFG";
        System.out.println(myText2.toLowerCase());
        String state = "ny";
        state = state.toUpperCase();
        System.out.println(state);
        String input = "ny";
        System.out.println(input.equalsIgnoreCase("NY"));
        System.out.println(input.toUpperCase().equals("NY"));
        System.out.println("öffnen".toUpperCase());
        System.out.println("ÉCOLE".toLowerCase());
        System.out.println("straße".toUpperCase());

        System.out.println("TITLE".toUpperCase(Locale.of("tr")));
        System.out.println("title".toUpperCase(Locale.of("tr")));
        System.out.println("title".toUpperCase(Locale.ROOT));

        myText = "";
        System.out.println(myText.isEmpty());
        System.out.println(myText.length());
        myText = " ";
        System.out.println(myText.isEmpty());
        System.out.println(myText.length());
        System.out.println(myText.isBlank());

        //Exercise 1
        String a = "Java";
        String b = "Java";
        String c = new String("Java");
        System.out.println((a == b) + " " + (a == c) + " " +
                a.equals(c) + " " + b.equals(c));
        //Exercise 2
        String first = "Ja";
        String joined = first + "va";
        System.out.println((joined == "Java") + " " + "Java".equals(joined));

        //Exercise 3
        String ca = "ca";
        String ny = "Ny";
        String tx = "tX";
        ca = ca.toUpperCase();
        ny = ny.toUpperCase();
        tx = tx.toUpperCase();
        System.out.println(ca + " " + ny + " " + tx);

        //Exercise 4
        String s = "hello";
        s = s.toUpperCase();
        System.out.println(s);

        //Exercise 5
        String input1 = "Yes";
        System.out.println("yes".equalsIgnoreCase(input1));

        //Exercise 6
        System.out.println("straße".length() + " " + "straße".toUpperCase().length());

        //Exercise 7
        System.out.println("istanbul".toUpperCase() + " " +
                "istanbul".toUpperCase(Locale.of("tr")) + " " +
                "istanbul".toUpperCase(Locale.ROOT));

        //Exercise 8
        System.out.println("".length() + " " + "".isEmpty() + " " + "".isBlank());
        System.out.println(" ".length() + " " + " ".isEmpty() + " " + " ".isBlank());
        System.out.println("\t".length() + " " + "\t".isEmpty() + " " + "\t".isBlank());
        System.out.println("Ann".length() + " " + "Ann".isEmpty() +
                " " + "Ann".isBlank());
        System.out.println(" Ann ".length() + " " + " Ann ".isEmpty() +
                " " + " Ann ".isBlank());

        //Exercise 9
        System.out.println(isValidName(null) + " " + isValidName("") +
                " " + isValidName(" ") + " " + isValidName("Ann"));

        //Exercise 10
        System.out.println("\u00A0".isBlank() + " " + " ".isBlank());

    }

    public static boolean isValidName(String name) {
        if(name == null || name.isBlank()) {
            return false;
        } else {
            return true;
        }
    }
}
