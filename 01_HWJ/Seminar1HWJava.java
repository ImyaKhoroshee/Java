
// ДЗ 1

// 1.	Выбросить случайное целое число и сохранить в i
// 2.	Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
// 3.	Найти все кратные n числа большие i и сохранить в массив m1
// 4.	Найти все некратные n числа меньшие i и сохранить в массив m2
// 5.	Сохранить оба массива в файлы с именами m1 и m2 соответственно.

// Пункты реализовать в методе main
// *Пункты реализовать в разных методах
// **Реализовать один из пунктов рекурсией

import java.io.FileWriter;
import java.util.Arrays;

public class Seminar1HWJava {
    public static void main(String[] arg) throws Exception {

        byte i = (byte) (Math.abs(Math.random() * 256 - 128)); // Генерируем случайное число типа byte в диапазоне от
                                                               // -128 до 127
        System.out.println("Random number = " + i); 

        int n = mostSignificantBit(i); // Вызов метода по определению старшего значащего бита
        int countm1 = countm1(n, i); // Вызов метода для подсчета длины массива m1
        int m1[] = multipleArray(countm1, i, n); // Вызов метода для записи кратных чисел в массив m1
        int countm2 = countm2(n, i); // Вызов метода для подсчета длины массива m2
        int m2[] = multipleArray2(countm2, i, n); // Вызов метода для записи некратных чисел в массив m2
        writer(m1); // Вызов метода для записи массива m1 в файл
        writer2(m2); // Вызов метода для записи массива m2 в файл
    }

    public static int mostSignificantBit(byte number) {
        String n = Integer.toBinaryString(number); // Переводим выпавшее число в двоичную систему счисления
        int temp1 = n.length(); // Определяем старший значащий бит
        System.out.println("MSB = " + temp1);
        
        return n.length();
    }

    public static int countm1(int lenght, byte number) {
        byte index = Byte.MAX_VALUE; // Определяем максимальное число для данного типа 
        int count1 = 0;
        
        while (index > number) {
            if (index % lenght == 0) {count1++;} // Определяем длину массива
            index--;
        }
        System.out.println("Length of max: " + count1);    
        
        return count1;
    }
    public static int[] multipleArray(int lenght, byte number, int num) {
        int number1 = number + 1;
        int[] m1Array = new int[lenght]; // инициализируем массив с зарезервированной длиной  
        byte max = Byte.MAX_VALUE;
        
        for (int i = 0; i < lenght; i++) {
            while (max > number1) {
                if (number1 % num == 0) {
                    m1Array[i] = number1; // заполняем массив числами по условию
                    number1++;
                    break; // возможно, моя конструкция не самая лучшая, буду рада корректировке. Ничего в голову лучше не пришло :)
                }
                number1++;
            }
        }
        System.out.println(Arrays.toString(m1Array));
        return m1Array;
    }
    public static int countm2(int lenght, byte number) {
        byte index = Byte.MIN_VALUE; // Определяем минимальное число для данного типа
        int count2 = 0;
        
        while (index < number) {
            if (index % lenght != 0) {count2++;} 
            index++;
        }
        System.out.println("Length of min: " + count2);    
        
        return count2;
    }
    public static int[] multipleArray2(int lenght, byte number, int num) {

        int[] m2Array = new int[lenght];
        byte min = Byte.MIN_VALUE;
        
        for (int i = 0; i < lenght; i++) {
            while (min < number) {
                if (min % num != 0) {
                    m2Array[i] = min;
                    min++;
                    break;
                }
                min++;
            }
        }
        System.out.println(Arrays.toString(m2Array));
        return m2Array;
    }
    public static void writer(int[] args)  throws Exception {
        
        FileWriter m1 = new FileWriter("m1.txt"); // Объявление

        for (int i = 0; i < args.length; i++) {
           m1.write(String.valueOf(args[i]+"\t")); // Запись
        }
        
        m1.close(); // Закрытие
       
    }
    public static void writer2(int[] args2)  throws Exception {
        
        FileWriter m2 = new FileWriter("m2.txt");

        for (int i = 0; i < args2.length; i++) {
            m2.write(String.valueOf(args2[i]+"\t"));
         }

        m2.close();
    }
}
