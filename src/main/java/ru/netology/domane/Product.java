package ru.netology.domane;

public class Product {
    protected int id;
    protected String nameProduct;
    protected int prise;

    public int getId() {
        return id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public Product(int id, String nameProduct, int prise) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.prise = prise;
    }

    public Product() {

    }
}
