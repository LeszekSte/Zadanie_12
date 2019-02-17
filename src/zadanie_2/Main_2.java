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
        int podzial = scanner.nextInt();

        try {
            if (podzial > dlugoscTab)
                throw new ArrayIndexOutOfBoundsException();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Tablica ma tylko " + dlugoscTab + " elementów");
        } finally {
            if (podzial > dlugoscTab / 2) {
                podzial = (int) dlugoscTab / 2 + dlugoscTab % 2;
                System.out.println("Tablica zostanie podzielona na " + podzial + " części");
            }
        }


        CalcClass calcClass = new CalcClass();
        calcClass.sumaLiczb(tab, podzial);
        calcClass.printSum(calcClass.getTabelka() );


    }

}
