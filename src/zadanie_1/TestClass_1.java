package zadanie_1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class TestClass_1 {


    private static Object Product;
    public static final int QUANTITY_PRODUCT = 10;

    public static void main(String[] args) throws IOException {

        Product[] products = new Product[QUANTITY_PRODUCT];
        products[0] = new Product("Czekolada Gorzka", "Wawel", 2.09);
        products[1] = new Product("Batonik", "Wawel", 1.58);
        products[2] = new Product("Mieszanka", "Wawel", 15.15);
        products[3] = new Product("Czekolada Mleczna", "Milka", 2.20);
        products[4] = new Product("Michałki", "Milka", 12.3);
        products[5] = new Product("Michłki Biłe", "Śnieżka", 12.3);
        products[6] = new Product("Trufle", "Wawel", 15.3);
        products[7] = new Product("Trufle", "Śnieżka", 130.23);
        products[8] = new Product("Czekalada", "Milka", 3.25);
        products[9] = new Product("Czekalada Nadziewana", "Milka", 3.25);

//        String plikMagazyn = "produkty.csv";
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(plikMagazyn);
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//
//        for (Product product : products) {
//            bufferedWriter.write(product.toString());
//            bufferedWriter.newLine();
//        }
//        bufferedWriter.close();

        InputOutput iO = new InputOutput();
        iO.outputCase(products);

        zadanie_1.Product product1 = new Product();

        for (Product product : products) {
            product1.productNull();
        }

        iO.inputCase(products,QUANTITY_PRODUCT);


        WorkClass workClass = new WorkClass();
        System.out.printf("Suma wszystkich cen wynosi %.2f zł\n", iO.getSumPrice());
        System.out.printf("Najdroższy produkt to - %s\n\n", products[workClass.intMaxPrice].toString());
        workClass.maxQuantiyProducer(products);
    }


}




