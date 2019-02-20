package zadanie_1;

import java.util.Objects;

public class Product {
    private String name;
    private String producer;
    private double price;

    public Product(){}

    public Product(String name, String producer, double price) {
        this.producer = producer;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getProducer(), product.getProducer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProducer());
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    void productNull() {
        name =null;
        producer =null;
        price=0;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                '}';
    }
}