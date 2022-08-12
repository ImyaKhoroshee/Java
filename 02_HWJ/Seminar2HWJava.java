import java.util.ArrayList;

// 1.	Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
// 2.	Напишите программу на Java, чтобы проверить, являются ли две данные строки вращением друг друга.
// 3.	*Напишите программу на Java, чтобы перевернуть строку с помощью рекурсии.
// 4.	Дано два числа, например 3 и 56, необходимо составить следующие строки: 
//      3 + 56 = 59 
//      3 – 56 = -53 
//      3 * 56 = 168. 
//      Используем метод StringBuilder.append(). 
// 5.	Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(), StringBuilder.deleteCharAt(). 
// 6.	*Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
// 7.	**Сравнить время выполнения пункати 6 со строкой содержащей 10000 символов "=" средствами String  и StringBuilder.

public class Seminar2HWJava {
    public static void main(String[] args) {
        
        String minWindow = minWindow("Ja + Ja = Java + Java = JavaJava + Java = JavaJavaJava", "Java");
        
        boolean result = isPalindrom("KUULILENNUTEETUNNELILUUK","KUULILENNUTEETUNNELILUUK"); // Самое длинное слово палиндром :)
        System.out.println("Is KUULILENNUTEETUNNELILUUK palindrom? " + result);
        
        String recurcion = reverseWithRecursion("Recurcion");
        System.out.println("Recurcion vs  " + recurcion);
        
        String mathExmp1 = stringMathExmp1(3, 56);
        String mathExmp2 = stringMathExmp2(3, 56);
        String mathExmp3 = stringMathExmp3(3, 56);
        System.out.printf("%s\n%s\n%s\n", mathExmp1, mathExmp2, mathExmp3);
        
        String changedMathExmp1 = insertAndDeleteCharAt(mathExmp1);
        String changedMathExmp2 = insertAndDeleteCharAt(mathExmp2);
        String changedMathExmp3 = insertAndDeleteCharAt(mathExmp3);
        System.out.printf("%s\n%s\n%s\n", changedMathExmp1, changedMathExmp2, changedMathExmp3);
        
        String replacedMathExmp1 = replace(mathExmp1);
        String replacedMathExmp2 = replace(mathExmp2);
        String replacedMathExmp3 = replace(mathExmp3);
        System.out.printf("%s\n%s\n%s\n", replacedMathExmp1, replacedMathExmp2, replacedMathExmp3);
        
        time();
    }

    public static String minWindow(String str, String substring) {
            
        StringBuilder text = new StringBuilder(str);
        System.out.println("String: " + text);
        StringBuilder needToFind = new StringBuilder(substring);
        System.out.println("Substring: " + needToFind);
        StringBuilder temp = new StringBuilder();
    
        ArrayList<String> list  = new ArrayList<>(); // "Удобный массив" для хранения всех найденных окон
        
        int i = 0;
        while (i < text.length()-(needToFind.length()-1)) {             
            if (text.substring(i, i+4).equals(needToFind.toString())) {      // Сравниваем срез равный длине слова, которое ищем
                temp.append(needToFind); // Записываем во временный объект
                i += needToFind.length(); 
            } else {
                if (temp.isEmpty()) { 
                 i++;   
                } else {
                    list.add(temp.toString()); // Собираем все окна в массиве
                    temp.delete(0, temp.length()); // Обнуляем объект для хранения
                    i++; 
                }   
            }
            if (i == text.length()-(needToFind.length()-1)) { // Если уже невозможно сделать срез
                list.add(temp.toString());
                temp.delete(0, temp.length());
            }
        }
        if (!temp.isEmpty()) { // Эта проверка нужна, чтобы 'пусто' не добавлялось в последний элемент
            list.add(temp.toString()); 
        } 
        System.out.println("All windows: " + list);
        String find = "";
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).equals(needToFind.toString()) || list.size() == 1) { // Ищем в массиве мин длину элемента - элемент с наименьшей длиной, будет минимальным окном.
                find += list.get(k) + " "; // Но таких элементов мб не один
            } 
        }
        System.out.println("Minimum window(s): " + find);
        return find;
    }
 
    public static boolean isPalindrom(String str1, String str2) {

        if (str1.length() == str2.length() && str1.concat(str2).indexOf(str2) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public static String reverseWithRecursion(String arg) {

        if (arg.length() <= 1) {
            return arg;
        }
        return reverseWithRecursion(arg.substring(1)) + arg.charAt(0);
    }

    public static String stringMathExmp1(int num1, int num2) {
        
        StringBuilder firstExample = new StringBuilder("");
        firstExample.append(num1).append(" + ").append(num2).append(" = ").append(num1+num2);
        
        return firstExample.toString();
    }

    public static String stringMathExmp2(int num1, int num2) {
        
        StringBuilder secondExample = new StringBuilder("");
        secondExample.append(num1).append(" - ").append(num2).append(" = ").append(num1-num2);
        
        return secondExample.toString();
        
    }

    public static String stringMathExmp3(int num1, int num2) {
        
        StringBuilder thirdExample = new StringBuilder("");
        thirdExample.append(num1).append(" * ").append(num2).append(" = ").append(num1*num2);
        
        return thirdExample.toString();
        
    }

    public static String insertAndDeleteCharAt(String str) {
        
        StringBuilder changedString = new StringBuilder(str);
        changedString.deleteCharAt(7).insert(7, "equal"); // возвращает измененный объект StringBuilder
        
        return changedString.toString();
        
    }

    public static String replace(String str) {
        
        StringBuilder replacedString = new StringBuilder(str);
        replacedString.replace(7, 8, "equal"); // (откуда-вкл, докуда-невкл, что), возвращает измененный объект StringBuilder
        
        return replacedString.toString();
        
    }

    public static void time() {
        long startForStr = System.currentTimeMillis();

        String manyEquals = "";
        for (int i = 0; i < 10000; i++) {
            manyEquals += "=";
        }
        manyEquals.replace("=", "equal");

        long finishForStr = System.currentTimeMillis();

        String resultForStr = String.valueOf(finishForStr - startForStr);
        System.out.printf("Time for String: %s", resultForStr + "\n");
        
        long startForSB = System.currentTimeMillis();

        StringBuilder manyEqualsSB = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            manyEqualsSB.append("=");
        }

        for (int i = 0; i < 10000*5; i+=5) {
            manyEqualsSB.replace(i, i+1, "equal");
        }
    
        long finishForSB = System.currentTimeMillis();

        String resultForSB = String.valueOf(finishForSB - startForSB);
        System.out.printf("Time for StringBuilder: %s", resultForSB);
    }
}
