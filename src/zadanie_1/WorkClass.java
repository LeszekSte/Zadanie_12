package zadanie_1;

import java.util.ArrayList;

public class WorkClass {
    public int intMaxPrice = 0;
    public double maxPrice = 0;

    void maxQuantiyProducer(Product[] products) {
        ArrayList<String> prodcentNazwa = new ArrayList<>();
        prodcentNazwa.add(products[0].getProducer());

        boolean ok;
        int i;

        for (Product product : products) {
            ok = false;
            i = 0;
            do {
                if (product.getProducer().equals(prodcentNazwa.get(i))) {
                    ok = true;
                }
                i++;
            } while (!ok && i < prodcentNazwa.size());
            if (!ok) {
                prodcentNazwa.add(product.getProducer());
            }
        }
        maxNazwa(prodcentNazwa, products);
    }

    void maxNazwa(ArrayList arrayList, Product[] product1) {
        int indeksMax = 0;
        int nrIndexMax = 0;

        for (int i = 0; i < arrayList.size(); i++) {
            int indeks = 0;
            for (zadanie_1.Product product : product1) {
                if (arrayList.get(i).equals(product.getProducer())) {
                    indeks++;
                    if (indeksMax < indeks) {
                        indeksMax = indeks;
                        nrIndexMax = i;
                    }
                }
            }
        }
        System.out.println("Najwięcej produktów jest producenta - " + arrayList.get(nrIndexMax));
    }

    void testPrice(Product productTest, int indeks) {
        if (maxPrice < productTest.getPrice()) {
            maxPrice = productTest.getPrice();
            intMaxPrice = indeks;
        }
    }
}
