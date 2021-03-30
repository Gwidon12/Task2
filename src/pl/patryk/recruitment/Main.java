package pl.patryk.recruitment;

import pl.patryk.recruitment.utils.IntegerComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        final int sum = 13;
        final int maxFirstValue = Math.floorDiv(sum, 2);

        List<Integer> integerList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter integer to continue or enter any non-integer value to finish");
        while (sc.hasNextInt()) {
            System.out.println("Enter next integer: ");
            int a = sc.nextInt();
            integerList.add(a);
        }

        if (integerList.isEmpty()) {
            System.out.println("List is empty. App will be closed");
        } else {
            System.out.println("Provided values: " + integerList);
            System.out.println("RESULT: ");
            Comparator<Integer> integerComparator = new IntegerComparator();
           integerList.sort(integerComparator);

            List<Integer> secondList = integerList.stream()
                    .filter(integer -> integer > maxFirstValue)
                    .sorted(integerComparator)
                    .collect(Collectors.toList());
            integerList.removeAll(secondList);

            for (Integer integer : integerList) {
                for (int i = 0; i < secondList.size(); i++) {
                    if (integer + secondList.get(i) == sum) {
                        System.out.println(integer + " " + secondList.get(i));
                        if (i < secondList.size() - 1 && !secondList.get(i).equals(secondList.get(i + 1))) {
                            break;
                        }
                    }

                }
            }


        }
    }
}

