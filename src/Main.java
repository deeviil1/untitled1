import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String string = scanner.nextLine();
                String[] str = string.split(" ");

                if (string.equalsIgnoreCase("End")) {
                    throw new Exception("Программа завершила работу");

                }
                if (str.length != 3){
                    throw new Exception("Неверный формат выражения");
                }

                Calc.check(str);
                System.out.println(Calc.calc(str));


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static class Calc {
        static String res;
        static String a;
        static String b;
        static String c;
        static int num;

        static String calc(String[] strings) throws Exception {
            if (strings[1].equals("+")) {
                a = strings[0].substring(0, strings[0].length() - 1);
                b = strings[2].substring(1);
                //"100" + "500"
                res = a + b;
                return res;
            }

            if (strings[1].equals("-")) {
                a = strings[0];
                b = strings[2];
                //"Bye-bye!" - "World!"

                res = a.replace(b, "");
                return res;
            }
            // if (strings[2].equals("-")){
            //   a = strings[0];
            // b = strings[3];
            //c = strings[1];
            //"Hi World!" - "World!"


            //res = a.replace(b," ");
            //return res + "\"";


            // }
            if (strings[1].equals("*")) {
                a = strings[0];
                num = Integer.parseInt(strings[2]);
                if (num >= 10) {
                    throw new Exception("Число должно быть от 1 до 10");

                }
                //"Java" * 5

                res = a.repeat(num).replaceAll("\"", "");
                return "\"" + res + "\"";


            }
            if (strings[1].equals("/")) {
                a = strings[0];
                num = Integer.parseInt(strings[2]);
                if (num > 10){
                    throw new Exception("Число должно быть от 1 до 10");
                }
                if (!"1 - 10".contains(strings[2])){
                    throw new Exception("Делить должен быть числом");

                }

                //"Example!!!" / 3

                res = a.substring(0, strings[0].length() / num);
            }

            return res + "\"";


        }


        static void check(String[] error) throws Exception {

            if (10 < error[0].length() && error[1].length() > 10 && error[2].length() > 10 && error[4].length() > 10) {
                throw new Exception("Неверная длина строки");

            }
            if ("A-z".contains(error[0])){
                throw new Exception("Строка должна содержать только буквы и символы");
            }


        }


    }
}

