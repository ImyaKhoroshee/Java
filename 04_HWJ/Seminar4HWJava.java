import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

// 1. Объявить и инициализировать связанный список в 10000 элементов случайным числом от -1024 до 1024
// 2. Пройти по списку и удалить все отрицательные элементы
// 3. Скопировать в переменные и удалить из списка первый и второй элементы, сложить переменные, результат сохранить в начало списка. 
// 4. Реализовать пункт №3 для всего списка.
// 5. Измерить время исполнения пунктов №2 и №3. 
// 6. *Реализовать пункты с первого по пятый но с ArrayList. Сравнить время исполнения.
// 7. **Оптимизировать реализацию заданий так, чтобы время выполнения LinkedList и ArrayList были наименьшим.

public class Seminar4HWJava {

    public static void main(String[] args) {
        LinkedList<Integer> firstTask = randomElemList();
        ArrayList<Integer> convert = new ArrayList<>(firstTask);
        LinkedList<Integer> secondTask = deleteNegElem(firstTask);
        LinkedList<Integer> thirdTask = pollPeekOffer(secondTask);
        LinkedList<Integer> fourthTask = pollPeekOfferAllList(firstTask);

        ArrayList<Integer> task1 = randomElemforArrayList();
        // System.out.println("Converted list: " + convert);
        ArrayList<Integer> task2 = deleteNegElemArrayList(convert);
        ArrayList<Integer> task3 = pollPeekOfferArrayList(task2);
        ArrayList<Integer> task4 = pollPeekOfferAllArrayList(task3);
    }

    private static Integer rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static LinkedList<Integer> randomElemList() {
        long start = System.currentTimeMillis();
        LinkedList<Integer> withRandomElem = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            withRandomElem.add(rnd(-1024, 1024));
        }
        String result = String.valueOf(System.currentTimeMillis() - start);
        System.out.println("Time for task 1 for LinkedList: " + result);
        // System.out.println(withRandomElem);

        return withRandomElem;
    }

    public static LinkedList<Integer> deleteNegElem(LinkedList<Integer> col) {
        long start = System.currentTimeMillis();
        
        // for (int i = 0; i < col.size(); i++) { 
            
        //     if (col.get(i) < 0) {
        //         col.remove(i);
        //         i = i-1;
        //     }  
        // }
        ListIterator<Integer> item = col.listIterator(); // Оптимизация
        while (item.hasNext()) {
            int s = item.next(); // вызывать до удаления
            if (s < 0) {
                item.remove();
            }
        }
    // col.removeIf(x -> x < 0); // еще один вариант оптимизации, но без цикла

    String result = String.valueOf(System.currentTimeMillis() - start);

    System.out.println("Time for task 2 for LinkedList: "+result);
    // System.out.println(col);

    return col;
    }

    public static LinkedList<Integer> pollPeekOffer(LinkedList<Integer> args) {
        long start = System.currentTimeMillis();

        int firstElem = args.peekFirst(); // getFirst() все "зеленые" методы мб использованы, но генерируют
        args.pollFirst(); // removeFirst() исключение NoSuchElementException, если этот список пуст.
        int secondElem = args.peekFirst();
        args.pollFirst();
        args.offerFirst(firstElem + secondElem); // addFirst()

        String result = String.valueOf(System.currentTimeMillis() - start);

        System.out.println("Time for task 3 for LinkedList: " + result);
        // System.out.println(args);

        return args;
    }

    public static LinkedList<Integer> pollPeekOfferAllList(LinkedList<Integer> args2) {
        long start = System.currentTimeMillis();

        for (int index = 1; index < args2.size(); index++) { // для оптимизации нужен цикл Iterator
            int firstElem = args2.get(index - 1);           // оставила вопрос для семинара
            int secondElem = args2.get(index);
            args2.remove(index - 1);
            args2.remove(index - 1);
            args2.add(index - 1, firstElem + secondElem); // Если список будет хранить нечетное кол-во элементов, нужно
                                                          // добавлять условия.
        }

        String result = String.valueOf(System.currentTimeMillis() - start);
        // System.out.println(args2);
        System.out.println("Time for task 4 for LinkedList: " + result + "\n");
        return args2;
    }

    public static ArrayList<Integer> randomElemforArrayList() {
        long start = System.currentTimeMillis();

        ArrayList<Integer> withRandomElemArray = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            withRandomElemArray.add(rnd(-1024, 1024));
        }

        String result = String.valueOf(System.currentTimeMillis() - start);
        System.out.println("Time for task 1 for ArrayList: " + result);
        // System.out.println(withRandomElemArray);
        return withRandomElemArray;
    }

    public static ArrayList<Integer> deleteNegElemArrayList(ArrayList<Integer> cols) {
        long start = System.currentTimeMillis();

        // for (int i = 0; i < cols.size(); i++) {

        //     if (cols.get(i) < 0) {  // 570
        //         cols.remove(i);
        //         i = i - 1;
        //     }
        // }
        cols.removeIf(x -> x < 0);

        String result = String.valueOf(System.currentTimeMillis() - start);

        System.out.println("Time for task 2 for ArrayList: " + result);
        // System.out.println(cols);
        return cols;
    }

    public static ArrayList<Integer> pollPeekOfferArrayList(ArrayList<Integer> argument) {
        long start = System.currentTimeMillis();

        int firstElem = argument.get(0);
        int secondElem = argument.get(1);
        argument.remove(0);
        argument.remove(0);
        argument.add(0, firstElem + secondElem);

        String result = String.valueOf(System.currentTimeMillis() - start);

        System.out.println("Time for task 3 for ArrayList: " + result);
        // System.out.println(argument);
        return argument;
    }

    public static ArrayList<Integer> pollPeekOfferAllArrayList(ArrayList<Integer> collection) {
        long start = System.currentTimeMillis();

        for (int index = 1; index < collection.size(); index++) {
            int firstElem = collection.get(index - 1);
            int secondElem = collection.get(index);
            collection.remove(index - 1);
            collection.set(index - 1, firstElem + secondElem); // оптимизиция remove и add на set 
                                                               // 
        }
        String result = String.valueOf(System.currentTimeMillis() - start);
        System.out.println("Time for task 4 for ArrayList: " + result);
        // System.out.println(collection);
        return collection;
    }
}
