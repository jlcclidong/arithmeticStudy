package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 小亨买书 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        String isbns = scanner.nextLine();
        String[] split = isbns.split(" ");
        ArrayList<Integer> ints = new ArrayList<>();
        for (String aSplit : split) {
            ints.add(Integer.valueOf(aSplit));
        }
        quickSort(ints, 0, ints.size() - 1);
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < ints.size(); i++) {
            if (i == 0) {
                integers.add(ints.get(i));
            } else if (!ints.get(i).equals(ints.get(i - 1))) {
                integers.add(ints.get(i));
            }
        }
        System.out.println(integers.size());
        for (int i = 0; i < integers.size(); i++) {
            if (i != 0)
                System.out.print(" ");
            System.out.print(integers.get(i));
        }
    }

    private static void quickSort(List<Integer> a, int start, int end) {
        if (start >= end)
            return;
        int num = a.get(start);
        int left = start;
        int right = end;
        while (left != right) {
            while (a.get(right) >= num && left < right)
                right--;
            while (a.get(left) <= num && left < right)
                left++;
            if (left < right) {
                int c = a.get(left);
                a.set(left, a.get(right));
                a.set(right, c);
            }
        }
        a.set(start, a.get(left));
        a.set(left, num);
        quickSort(a, start, left - 1);
        quickSort(a, left + 1, end);
    }
}
