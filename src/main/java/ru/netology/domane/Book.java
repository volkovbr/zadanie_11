package ru.netology.domane;

public class Book extends Product{
   protected String author;

    public Book(int id, String nameProduct,int prise,String author){
        super(id, nameProduct,prise);
        this.author=author;
    }
    public Book(){

    }
}
