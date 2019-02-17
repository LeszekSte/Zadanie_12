package zadanie_2;

import java.util.ArrayList;

public class CalcClass {
    private ArrayList<Integer> tabelka = new ArrayList<>();

    void sumaLiczb(int[] ints, int podzialTab) {
        double ilLiczb = (double) ints.length / podzialTab;

        if (ilLiczb > (int) ilLiczb) {
            ilLiczb = (int) ilLiczb + 1;
        }
        int ktoraLiczba =0;
        for (int i = 0; i < podzialTab; i++) {
            int sum = 0;
            int przesuniecie = (int) ilLiczb * i;
            for (int z = 0; z < ilLiczb; z++) {
                if (ktoraLiczba < ints.length) {
                    sum += ints[z + przesuniecie];
                    ktoraLiczba++;
                }
            }
            tabelka.add(sum);
        }
    }
    void printSum(ArrayList tab ){
        System.out.print("[");
        for (int i = 0 ; i< tab.size();i++){
            System.out.print(tabelka.get(i)+ ",");
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
