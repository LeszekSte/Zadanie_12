package zadanie_2;

import java.util.ArrayList;

public class CalcClass {
    private ArrayList<Integer> tabelka = new ArrayList<>();

    void sumaLiczb(int[] ints, int podzialTab) throws ArrayIndexOutOfBoundsException {
        double ilLiczb = (double) ints.length / podzialTab;

        if (ilLiczb > (int) ilLiczb) {
            ilLiczb = (int) ilLiczb + 1;
        }
        int ktoraLiczbaWTab = 0;
        for (int i = 0; i < podzialTab; i++) {
            int sum = 0;
            int przesuniecie = (int) ilLiczb * i;
            for (int z = 0; z < ilLiczb; z++) {
                try {
                    if (ktoraLiczbaWTab >= ints.length) {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                    sum += ints[z + przesuniecie];
                    ktoraLiczbaWTab++;

                } catch (ArrayIndexOutOfBoundsException e) {
                }

//                if (ktoraLiczbaWTab < ints.length) {
//                    sum += ints[z + przesuniecie];
//                    ktoraLiczbaWTab++;
//                }
            }
            tabelka.add(sum);
        }
    }

    void printSum(ArrayList tab) {
        System.out.print("[");
        for (int i = 0; i < tab.size(); i++) {
            System.out.print(tabelka.get(i) + ",");
        }
        System.out.println("]");
    }

    public ArrayList<Integer> getTabelka() {
        return tabelka;
    }

    public void setTabelka(ArrayList<Integer> tabelka) {
        this.tabelka = tabelka;
    }
}
