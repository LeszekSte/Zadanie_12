package zadanie_2;

import java.util.Scanner;
import java.util.SortedMap;

public class Main_2 {
    public static void main(String[] args) {

        int[] tab = {1, 1, 1, 2, 2, 2, 3, 3, 3, 1};
        if (tab == null) {
            throw new NullPointerException();
        }

        int dlugoscTab = tab.length;
        System.out.println("Na ile części chcesz podzielić tablicę w zakresie od 1 do " + dlugoscTab);

        Scanner scanner = new Scanner(System.in);
        int podzialTab = scanner.nextInt();

        try {
            if (podzialTab > dlugoscTab)
                throw new ArrayIndexOutOfBoundsException();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Tablica ma tylko " + dlugoscTab + " elementów");
        } finally {
            if (podzialTab > dlugoscTab / 2) {
                podzialTab = (int) dlugoscTab / 2 + dlugoscTab % 2;
                System.out.println("Tablica zostanie podzielona na " + podzialTab + " części");
            }
        }

        CalcClass calcClass = new CalcClass();
        calcClass.sumaLiczb(tab, podzialTab);
        calcClass.printSum(calcClass.getTabelka() );


    }

}
