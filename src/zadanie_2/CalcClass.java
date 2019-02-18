package zadanie_2;



public class CalcClass {


    int [] sumaLiczb(int[] ints, int podzialTab) throws ArrayIndexOutOfBoundsException {
        double ilLiczb = (double) ints.length / podzialTab;

        int [] tab = new int [podzialTab];
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
            tab[i]=sum;

        }return tab;
    }

}
