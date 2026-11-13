import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TranscriptParser {
    public static void main(String[] args) {
        String transcript = """
                Student Number: 1234598872          Grade:       11
                Birthdate:      01/02/2000          Gender:      M
                State ID:       8923827123
                Graduation:     06/15/2019
                
                Cumulative GPA (Weighted)           3.82
                Cumulative GPA (Unweighted)         3.46
                """;

        String regex = """
        Student\\sNumber:\\s(?<studentNum>\\d{10}).*    # grab student number
        Grade:\\s+(?<grade>\\d{1,2}).*                  # grab grade
        Birthdate:\\s+(?<birthMonth>\\d{2})/(?<birthDay>\\d{2})/(?<birthYear>\\d{4}).* # grab birth date
        Gender:\\s+(?<gender>\\w+)\\b.*                 # grab gender
        State\\sID:\\s+(?<stateID>\\d+)\\b.*?            # grab state ID
        Graduation:\\s+(?<graduationMonth>\\d{2})/(?<graduationDay>\\d{2})/(?<graduationYear>\\d{4})\\b.*?
        Cumulative.*?(?<weightedGPA>[\\d.]+)\\b.*?        
        Cumulative.*?(?<unweightedGPA>[\\d.]+)\\b.*
        """;
        Pattern pat = Pattern.compile(regex, Pattern.DOTALL | Pattern.COMMENTS);
        Matcher mat = pat.matcher(transcript);
        if(mat.matches()) {
            //System.out.println(mat.group(0));
            System.out.println(mat.group("studentNum"));
            System.out.println(mat.group("grade"));
            System.out.println(mat.group("birthMonth"));
            System.out.println(mat.group("birthDay"));
            System.out.println(mat.group("birthYear"));
            System.out.println(mat.group("gender"));
            System.out.println(mat.group("stateID"));
            System.out.println(mat.group("graduationMonth"));
            System.out.println(mat.group("graduationDay"));
            System.out.println(mat.group("graduationYear"));
            System.out.println(mat.group("weightedGPA"));
            System.out.println(mat.group("unweightedGPA"));

        }

    }
}
