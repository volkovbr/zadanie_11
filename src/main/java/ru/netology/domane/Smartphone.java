package ru.netology.domane;

public class Smartphone extends Product{
protected String manufacturer;

    public Smartphone(int id, String nameProduct,int prise,String manufacturer){
        super(id, nameProduct,prise);
        this.manufacturer=manufacturer;
    }
    public Smartphone(){

    }
}
