package zadanie_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class TestClass_1 {

  public   static int intMaxPrice = 0;
   public static double maxPrice = 0;
    private static Object Product;


    public static void main(String[] args) throws IOException {

        final int quantityProduct = 10;

        Product[] products = new Product[quantityProduct];
        products[0] = new Product("Czekolada Gorzka", "Wawel", 2.09);
        products[1] = new Product("Batonik", "Wawel", 1.58);
        products[2] = new Product("Mieszanka", "Wawel", 15.15);
        products[3] = new Product("Czekolada Mleczna", "Milka", 2.20);
        products[4] = new Product("Michałki", "Milka", 12.3);
        products[5] = new Product("Michłki Biłe", "Śnieżka", 12.3);
        products[6] = new Product("Trufle", "Milka", 15.3);
        products[7] = new Product("Trufle", "Milka", 130.23);
        products[8] = new Product("Czekalada", "Milka", 3.25);
        products[9] = new Product("Czekalada Nadziewana", "Milka", 3.25);

        String plikMagazyn = "produkty.csv";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(plikMagazyn);
        } catch (IOException e) {
            e.printStackTrace();

        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Product product : products) {
            bufferedWriter.write(product.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();

        for (Product product : products) {
            product.setName(null);
            product.setProducer(null);
            product.setPrice(0);
        }


        System.out.println(products[0].toString());

        FileReader fileReader = new FileReader(plikMagazyn);
        BufferedReader bfr = new BufferedReader(fileReader);
        String line = null;


        String[][] linijka = new String[quantityProduct][];
        int i = 0;
        double price = 0;
        double sumPrice = 0;


        while ((line = bfr.readLine()) != null) {
            linijka[i] = line.split(";");
            products[i].setName(linijka[i][0]);
            products[i].setProducer(linijka[i][1]);
            price = Double.valueOf(linijka[i][2]).doubleValue();
            products[i].setPrice(price);
            testPrice(products[i], i);
            sumPrice += price;
            i++;
        }
        bfr.close();


        System.out.printf("Suma wszystkich cen wynisi %.2f zł\n", sumPrice);
        System.out.printf("Najdroższy produkt to - %s\n\n", products[intMaxPrice].toString());
        maxQuantiyProducer(products);
    }


    static void maxQuantiyProducer(Product[] products) {
        int ileprod = 0;
        ArrayList<String> prodcentNazwa = new ArrayList<>();
        prodcentNazwa.add(products[0].getProducer());
        boolean ok;
        int i;
        boolean aa = false;

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

    static void maxNazwa(ArrayList arrayList, Product[] product1) {

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
        System.out.println("Najwięcej jest - "+arrayList.get(nrIndexMax));
    }

    static void testPrice(Product productTest, int indeks) {
        if (maxPrice < productTest.getPrice()) {
            maxPrice = productTest.getPrice();
            intMaxPrice = indeks;
        }
    }
}




