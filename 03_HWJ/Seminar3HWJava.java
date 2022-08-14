import java.util.ArrayList;
import java.util.Comparator;

// 1. Напишите программу, чтобы создать новый список массивов, добавить несколько цветов (строку) и вывести коллекцию на экран. 
// 2. Напишите программу для итерации всех элементов списка цветов и добавления к каждому символа '!'. 
// 3. Напишите программу для вставки элемента в список массивов в первой позиции. 
// 4. Напишите программу для извлечения элемента (по указанному индексу) из заданного списка. 
// 5. Напишите программу для обновления определенного элемента массива по заданному элементу. 
// 6. Напишите программу для удаления третьего элемента из списка массивов. 
// 7. Напишите программу для поиска элемента в списке массивов. 
// 8. Напишите программу для сортировки заданного списка массивов. 
// 9. Напишите программу для копирования одного списка массивов в другой. 

public class Seminar3HWJava {
    public static void main(String[] args) {

    ArrayList<String> firstTask = createAndAddStrList();
    ArrayList<String> secondTask = symbolAdd(firstTask);
    ArrayList<String> thirdTask = addToBeginning(secondTask);
    String fourthTask = getElement(thirdTask);
    ArrayList<String> fifthTask = elemChangeThroughSet(thirdTask);
    ArrayList<String> sixthTask = elemDelete(fifthTask);
    Boolean seventhTask = elemSearch(sixthTask,fourthTask);
    ArrayList<String> eighth = elemSort(sixthTask);
    ArrayList<String> ninth = listClone(eighth);
    }
    public static ArrayList<String> createAndAddStrList() {
        
        ArrayList<String> colours = new ArrayList<>();
        colours.add("Red");
        colours.add("Pink");
        colours.add("Yellow");
        colours.add("Black");
        
        System.out.println(colours);

        return colours;  // Возвращаем объект
    }
    public static ArrayList<String> symbolAdd(ArrayList<String> collection) {
        
        for (int i = 0; i < collection.size(); i++) {
        collection.set(i, collection.get(i) + "!");
        }
        
        System.out.println(collection);
        return collection;
    }
    public static ArrayList<String> addToBeginning(ArrayList<String> args) {
        
        args.add(0, "Blue");
    
        System.out.println(args);
        return args;
    }
    public static String getElement(ArrayList<String> list) {
        
        String neededElement = list.get(3);
        
        System.out.println(neededElement);
        return neededElement;
    }
    public static ArrayList<String> elemChangeThroughSet(ArrayList<String> collectionAgain) {
        
        collectionAgain.set(1, "new colour - Purple ");
        
        System.out.println(collectionAgain);
        return collectionAgain;
    }
    public static ArrayList<String> elemDelete(ArrayList<String> col) {
        
        col.remove(3);
        
        System.out.println(col);
        return col;
    }
    public static Boolean elemSearch(ArrayList<String> col1, String str) {
        
        Boolean result = col1.contains(str);
        System.out.println(result);
        return result;
    }
    public static ArrayList<String> elemSort(ArrayList<String> string) {
        
        string.sort(Comparator.naturalOrder()); // от A до Z
        // string.sort(Comparator.reverseOrder()); // от Z до A 

        System.out.println(string);
        return string;
    }
    public static ArrayList<String> listClone(ArrayList<String> listForClone) {
        
        listForClone.clone(); 
        
        System.out.println(listForClone);
        return listForClone;
    }

}
