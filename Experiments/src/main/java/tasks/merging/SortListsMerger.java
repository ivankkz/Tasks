package tasks.merging;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortListsMerger {
    public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        final int lenB = b.size();
        final int lenA = a.size();
        int iB = 0;  //index for ArrayList<Integer> d_b
        int iTempA = 0;  //index for temporary tempA
        ArrayList<Integer> tempA = (ArrayList<Integer>) a.clone();

        a.clear(); // чистим массив для заполнения с нуля
        a.ensureCapacity(lenA + lenB); // расширяем до нужного размера

        // идём по массивам и добавляем их пока один из массивов не кончиться
        while (iTempA < lenA && iB < lenB) {
            int temp = tempA.get(iTempA).compareTo(b.get(iB));
            switch (temp) {
                case -1:
                    a.add(tempA.get(iTempA++));
                    break;
                case 0:
                    a.add(tempA.get(iTempA++));
                case 1:
                    a.add(b.get(iB++));
            }
        }

        // перекидываем в temp ссылки на массив B и индекс, если закончился массив temp
        // если B не закончился, то действия не требуются так как в массиве temp уже будет нужная информация
        if (iB < lenB) {
            tempA = b;
            iTempA = iB;
        }

        // докидываем последние элементы с одного массива
        for (final int len = tempA.size(); iTempA < len; iTempA++) {
            a.add(tempA.get(iTempA));
        }
    }

    public static void merge2(ArrayList<Integer> a, ArrayList<Integer> b) {
        final int lenB = b.size();

        for (int indexB = 0, indexA = 0; indexB < lenB; indexA++) {
            if (indexA < a.size()) {
                if (a.get(indexA) > b.get(indexB)) {
                    a.add(indexA, b.get(indexB++));
                }
            } else {
                a.add(b.get(indexB++));
            }
        }
    }

    public static void merge3(ArrayList<Integer> listA, ArrayList<Integer> listB) {
        listA.addAll(listB);
        Collections.sort(listA);
    }

    public static void merge4(ArrayList<Integer> listA, ArrayList<Integer> listB) {
        List<Integer> temp = Stream.concat(listA.stream(), listB.stream())
                .sorted()
                .collect(Collectors.toList());
        listA.clear();
        listA.addAll(temp);
    }
}
