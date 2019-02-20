package zadanie_1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class TestClass_1 {


    public static void main(String[] args) throws IOException {
        List<Product> list = new ArrayList<>(100);
        readData(list);
        printList(list);
        System.out.printf("Suma cen wszystkich produktów wynosi %.2f\n", sumPrice(list));
        System.out.printf("Najdroższy produkt to %S \n", list.get(mostExpensiveProduct(list)));
        System.out.println( maxNumberOfproducer(list));
    }

    private static String maxNumberOfproducer(List<Product> list) {
        String nameMaxProducer = null;
        int sumMaxProcucer = 0;
        int sumProducer;

        for (int i = 0; i < list.size(); i++) {
            String tempProducer = list.get(i).getProducer();
            sumProducer = 0;

            for (int i1 = 0; i1 < list.size(); i1++) {

                if (tempProducer.equals(list.get(i1).getProducer())) {
                    sumProducer++;
                }
            }
            if (sumProducer> sumMaxProcucer) {
                nameMaxProducer = tempProducer;
                sumMaxProcucer=sumProducer;
            }
        }
        return nameMaxProducer;
    }


    private static int mostExpensiveProduct(List<Product> list) {
        int maxIndexPrice = 0;
        double maxPrice = 0;
        for (int i = 0; i < list.size(); i++) {
            double tempPrice = list.get(i).getPrice();

            if (tempPrice > maxPrice) {
                maxIndexPrice = i;
                maxPrice = tempPrice;
            }
        }

        return maxIndexPrice;
    }

    private static double sumPrice(List<Product> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getPrice();
        }
        return sum;
    }

    private static void printList(List<Product> list) {
        for (Product product : list) {
            System.out.println(product.toString());
        }

    }

    private static List<Product> readData(List<Product> listInput) throws IOException {
        FileReader fileReader = new FileReader("produkty.csv");
        BufferedReader bfr = new BufferedReader(fileReader);
        String line = null;
        int ithm = 0;

        while ((line = bfr.readLine()) != null) {
            // System.out.println(line);
            String[] position = line.split(";");
            Product product = new Product(position[0], position[1], Double.valueOf(position[2]));
            listInput.add(product);
        }
        bfr.close();
        return listInput;
    }

}



