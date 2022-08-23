import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeMap;
import java.util.TreeSet;

// 1. Объявить и инициализировать множества HashSet hs, LinkedHashSet lhs и TreeSet ts
// 2. Добавить в множества по 10 случайных целочисленных ключей.
// 3. Пройти по множеству hs и, при условии наличия соответствующего ключа в множестве lhs, удалить ключ из hs
// 4. Пройти по множеству lhs и, при условии отсутствия соответствующего ключа в множестве ts, добавит ключ в ts
// 5. Объявить и инициализировать множество TreeSet ts1 с компаратором Integer (-1 при значении %2==0 ;0 при ==;1 при значении %2!=0). Заполнить ts1 15 случайными числами и вывести на печать.
// 6. *Объявить и инициализировать множество TreeMap tm с компаратором Integer (-1 при значении  %2==0 ;0 при ==;1 при значении %2!=0). Заполнить tm 15 случайными числами и вывести на печать.

public class Seminar6HWJava {
    public static void main(String[] args) {
        HashSet<Integer> hsFisrtSecondTasks = hashSet();
        LinkedHashSet<Integer> lhsFisrtSecondTasks = linkedHashSet();
        TreeSet<Integer> tsFisrtSecondTasks = treeSet();
        HashSet<Integer> thirdTask = removeFromHsIfPresentInLhs(hsFisrtSecondTasks, lhsFisrtSecondTasks);
        TreeSet<Integer> fourthTask = addToTsIfAbsentInLhs(lhsFisrtSecondTasks, tsFisrtSecondTasks);
        treeSetWithComparator();
        treeMapWithComparator();
        
    }
    public static HashSet<Integer> hashSet() {
        HashSet<Integer> hs = new HashSet<>(14);
        while (hs.size() < 10) {
            int numberRandom = new Random().nextInt(100);
            if (!hs.contains(numberRandom)) {
                hs.add(numberRandom);  
            }
        }
        System.out.println("HashSet: " + hs);
        return hs;
    }
    public static LinkedHashSet<Integer> linkedHashSet() {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>(14);
        while (lhs.size() < 10) {
            int numberRandom = new Random().nextInt(100);
            if (!lhs.contains(numberRandom)) {
                lhs.add(numberRandom);  
            }
        }
        System.out.println("LinkedHashSet: " + lhs);
        return lhs;
    }
    public static TreeSet<Integer> treeSet() {
        TreeSet<Integer> ts = new TreeSet<>();
        while (ts.size() < 10) {
            int numberRandom = new Random().nextInt(100);
            if (!ts.contains(numberRandom)) {
                ts.add(numberRandom);  
            }
        }
        System.out.println("TreeSet: " + ts + "\n");
        return ts;
    }
    public static HashSet<Integer> removeFromHsIfPresentInLhs(HashSet<Integer> col, LinkedHashSet<Integer> arg) {
        
        col.removeIf(elem -> arg.contains(elem));
       
        // Iterator<Integer> item = col.iterator();
        // while (item.hasNext()) {
        //     if (arg.contains(item.next())) {
        //         item.remove(); 
        //     }
        // }
        System.out.println("HashSet after removing: " + col);
        return col;

    }
    public static  TreeSet<Integer> addToTsIfAbsentInLhs(LinkedHashSet<Integer> cll, TreeSet<Integer> intset) {
        
        for (Integer elem : cll) {
            if (!intset.contains(elem)) {
                intset.add(elem);  
            }
        }
        System.out.println("TreeSet after adding: " + intset);
        return intset;
    }
    public static TreeMap<Integer, String> treeMapWithComparator() {
        
        TreeMap<Integer, String> tm = new TreeMap<>(new Comparator<Integer>() {
            public int compare(Integer integer, Integer ts2) {
                if (integer == ts2 ) return 0;
                if (ts2 % 2 != 0) return 1; else return -1;
            }
        });

        for (int index = 0; index < 15; index++) {                  // для разнообразия :)
            tm.put(new Random().nextInt(100), "");  
        }
        System.out.println("tm: " + tm.keySet());
        return tm;
    }

    public static TreeSet<Integer> treeSetWithComparator() {
        
        TreeSet<Integer> ts1 = new TreeSet<>(new Comparator<Integer>() {
            public int compare(Integer integer, Integer ts2) {
                if (integer == ts2 ) return 0;
                if (ts2 % 2 != 0) return 1; else return -1;
            }
        });

        while (ts1.size() < 15) {                       // чтобы все 15 элементов были в множестве
            ts1.add(new Random().nextInt(100));  
        }
        System.out.println("ts1: " + ts1);
        return ts1;
    }
}