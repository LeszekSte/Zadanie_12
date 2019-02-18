package zadanie_1;

import java.io.*;


public class InputOutput {

    String plikMagazyn = "produkty.csv";
    private double sumPrice = 0;

    public double getSumPrice() {
        return sumPrice;
    }

    void outputCase(Product[] product) throws IOException {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(plikMagazyn);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (Product product1 : product) {
            bufferedWriter.write(product1.toString());
            bufferedWriter.newLine();

        }
        bufferedWriter.close();
    }


    void inputCase(Product[] products, int quntity) throws IOException {
        FileReader fileReader = new FileReader(plikMagazyn);
        BufferedReader bfr = new BufferedReader(fileReader);
        String line = null;

        String[][] linijka = new String[quntity][] ;
        int i = 0;
        double price = 0;
        WorkClass workClass = new WorkClass();

        while ((line = bfr.readLine()) != null) {
            linijka[i] = line.split(";");
            products[i].setName(linijka[i][0]);
            products[i].setProducer(linijka[i][1]);
            price = Double.valueOf(linijka[i][2]).doubleValue();
            products[i].setPrice(price);

            workClass.testPrice(products[i], i);
            sumPrice += price;
            i++;
        }
        bfr.close();
    }
}
