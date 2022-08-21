import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


// 1. Объявить и инициализировать словарь hashMap<String, String>
// 2. Добавить в словарь 10 пар "Ключ - Значение". Автор и название книги например.
// 3. Пройти по словарю и добавить к значениям символ "!" 
// 4. Добавить нового автора и название книги если соответствующего ключа не было.
// 5. Если ключ, указанный в запросе, имеется, вырезать из соответствующего ключу значения первое слово.
// 6. *Пройти по словарю другим, не таким как в пункте 3, методом и вывести пары ключ значение в консоль.
// 7. ** Пройти по словарю другим, не таким как в пункте 3 и 6, методом. Добавить к значениям строку "(просмотрен)" и вывести в консоль.

public class Seminar5HWJava {
    public static void main(String[] args) {
      
        HashMap<String, String> firstTask = new HashMap<>();
        HashMap<String, String> secondTask = putValuesToMap(firstTask);
        HashMap<String, String> thirdTask = addSymbToElem(secondTask); // foreach + entrySet
        HashMap<String, String> fourthTask = putIfAbsent(thirdTask);
        String neededKey = "Nikolay Nosov";
        HashMap<String, String> fifthTask = computeIfPresent(fourthTask, neededKey); // первый способ
        // HashMap<String, String> fifthTask = changeIfPresent(fourthTask, neededKey); // второй способ
        ForEach(secondTask); // sixthTask                              // Метод ForEach
        Iterator(secondTask); // sixthTask                             // Iterator + entrySet
        ForPlusKeySet(secondTask); // seventhTask                      // foreach + keySet
    }   

    public static HashMap<String, String> putValuesToMap(HashMap<String, String> collbooks) {
        
        collbooks.put("Lev Tolstoy", "Childhood");
        collbooks.put("Nikolay Nosov", "Dunno on the Moon");
        collbooks.put("Viktor Dragunsky", "The Adventures of Dennis");
        collbooks.put("Anton Chekhov", "Kashtanka");
        collbooks.put("Kir Bulychev", "The Girl From Earth");
        collbooks.put("Sergey Aksakov", "The Little Scarlet Flower");
        collbooks.put("Arkadiy Gaydar", "The blue cup"); 
        collbooks.put("William Golding", "Lord of the Flies");   
        collbooks.put("Hans Andersen", "The Snow Queen");  
        collbooks.put("Joanne Rowling", "Harry Potter and the Deathly Hallows"); 
        
        System.out.println(collbooks + "\n");
        return collbooks;
    }
    public static HashMap<String, String> addSymbToElem(HashMap<String, String> collb) {
        
        for(HashMap.Entry<String, String> item : collb.entrySet()){
         
            collb.replace(item.getKey(), item.getValue(), (item.getValue() + "!"));
        }
        // System.out.println(collb.values() + "\n");
        return collb;
    }
    public static HashMap<String, String> putIfAbsent(HashMap<String, String> col) {
        
        col.putIfAbsent("Eno Raud", "Naksitrallid");
        // System.out.println(col.values() + "\n");
        return col;
    }
    // public static HashMap<String, String> changeIfPresent(HashMap<String, String> bk, String k) {
         
    //     if (bk.containsKey(k)) {
    //         String tempvalue = bk.get(k);
    //         ArrayList<String> sb = new ArrayList<>(Arrays.asList(tempvalue.split(" ")));
    //         sb.remove(0);
    //         String result = String.join(" ", sb);
            
    //         bk.put(k, result);
    //     }
    //     System.out.println(bk.values());
    //     return bk;
    // } 
    public static HashMap<String, String> computeIfPresent(HashMap<String, String> bk, String k) {
        
        bk.computeIfPresent(k, (key,value) -> func(bk, k));
        // System.out.println(bk.values());
        return bk;
    }
    private static String func(HashMap<String, String> some, String smth) {
        String result = "";
        if (some.containsKey(smth)) {
            String tempvalue = some.get(smth);
            ArrayList<String> sb = new ArrayList<>(Arrays.asList(tempvalue.split(" ")));
            sb.remove(0);
            result = String.join(" ", sb);
        }
        return result;
    }
    public static void ForEach(HashMap<String, String> colOfBook) {
        
        colOfBook.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));
    }

    public static void Iterator(HashMap<String, String> colOfBook) {
        
        Iterator<Map.Entry<String, String>> iter = colOfBook.entrySet().iterator();
        while (iter.hasNext()){
            Map.Entry<String, String> keyandvalue = iter.next(); // важный момент, чтобы обращаться именно к ключам и значениям
            System.out.println("Key: " + keyandvalue.getKey() + "Value: " + keyandvalue.getValue());
        }
    }
    public static void ForPlusKeySet(HashMap<String, String> colOfBook) {
        for (String key : colOfBook.keySet()) {
            colOfBook.put(key, (colOfBook.get(key) + " - viewed"));
        }
        System.out.println(colOfBook.values());
    }
}
