import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static java.lang.Exception Exception;

    public static void main(String[] args) throws Exception {

        String result = new String();
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();


        //System.out.println(data);
        String[] datas = data.split("\"");
        //System.out.println(datas[0]);
        //System.out.println(datas[1]);
        //System.out.println(datas[2]);
        //System.out.println(datas[3]);


        if (ending(data) && datas[2].equals(" + ")) {
            System.out.println("\"" + cocnatination(data) + "\"");


        } else if (ending(data) && datas[2].equals(" - ")) {
            System.out.println("\"" + minus(data) + "\"");

        } else if (!ending(data)) {
            System.out.println("\"" + repeatandcut(data) + "\"");
        }


        //System.out.println(ending(data));


    }

    public static boolean ending(String input) {
        //char lastchar = input.charAt(input.length() - 1);
        //String lstch = String.valueOf(lastchar);
        //char note = input.charAt(0);

        return input.endsWith("\"");//lstch.equals("\"");

    }


    public static String cocnatination(String input) throws Exception {
        String[] datas = input.split("\"");
        if (datas[1].length() <= 10 && datas[3].length() <= 10) {
            return datas[1] + datas[3];
        }
        else {
            throw Exception;
        }
    }

    public static String minus(String input) throws Exception {
        String[] datas = input.split("\"");
        if (datas[1].length() <= 10 && datas[3].length() <= 10) {
            return datas[1].contains(datas[3]) ? datas[1].replaceAll(datas[3], "") : datas[1];
        }
        else {
            throw Exception;
        }
    }

    public static String repeatandcut(String input) throws Exception {
        String[] datas = input.split(" ");
        int num = Integer.parseInt(datas[2]);
        if ((1 <= num && num <= 10) && (datas[0].length() <= 10) && (datas[0].startsWith("\""))) {
            String text = datas[0].replace("\"", "");
            if (datas[1].equals("*")) {
                return otvet(text.repeat(num));
            } else if (datas[1].equals("/")) {
                int newleg = datas[0].length() / num;
                text = datas[0].substring(1, newleg);
                return text;
            }
        } else {
            throw Exception;
        }
        return null;
    }

    public static String otvet(String input) {
        if (input.length() > 40) {
            return input.substring(0, 40) + "...";

        } else {
            return input;
        }

    }
}
