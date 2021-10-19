package Chapter14.最初定义;


import java.text.ParseException;

public class Test {
    public static void main(String[] args) {
        try {
            Args arg = new Args("l,p#,d*", args);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
