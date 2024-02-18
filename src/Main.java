import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String string = scanner.nextLine();
                String[] str = string.split(" +?(?=([^\"]*\"[^\"]*\")*[^\"]*$)");


                if (string.equalsIgnoreCase("End")) {
                    throw new Exception("Программа завершила работу");
                }
                if (str.length != 3) {
                    throw new Exception("Неверный формат выражения");
                }
                if (10 < str[0].length() || str[2].length() > 10) {
                    throw new Exception("Неверная длина строки");
                }
                if (str[2].contains("\"")){
                    throw new Exception("строка должна быть числом");
                }

                if(str[0].contains("\"")) {
                    System.out.println(Main.calc(str));
                }
                    else{
                    throw new Exception("Операнд должен быть строкой");
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

            static String calc(String[] strings) throws Exception {
                String res = null;
                String a = strings[0].replaceAll("\"", "");
                String b = strings[2].replaceAll("\"", "");
                int num = Integer.parseInt(strings[2]);

                if (strings[1].equals("+")) {
                    //"100" + "500"
                    res = (a + b);

                }

                if (strings[1].equals("-")) {
                    //"Bye-bye!" - "World!"
                    res = a.replace(b, "");

                }

                if (strings[1].equals("*")) {
                    if (num > 10) {
                        throw new Exception("Число должно быть от 1 до 10");

                    }
                    //"Java" * 5

                    res = a.repeat(num);


                }
                if (strings[1].equals("/")) {
                    if (num > 10) {
                        throw new Exception("Число должно быть от 1 до 10");
                    }
                    if ("1 - 10".contains(strings[2])) {
                        throw new Exception("Делить на ноль нельзя");
                    }
                    //"Example!!!" / 3

                    res = a.substring(0, strings[0].length() / num);
                }

                if (res.length() > 40){
                    res = res.substring(0,40) + "...";
                }
                    return "\"" + res + "\"";
                }
        }





