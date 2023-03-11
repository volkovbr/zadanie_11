package ru.netology.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domane.Book;
import ru.netology.domane.Product;
import ru.netology.domane.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.RepositoryProduct;

public class TestProduct {
    public RepositoryProduct repo = new RepositoryProduct();
    public ProductManager man = new ProductManager(repo);
    Book product1 = new Book(1, "война и мир", 1200, "толстой");
    Book product2 = new Book(2, "темная башня", 500, "стивен кинг");
    Book product3 = new Book(3, "стрелок", 120, "стивен кинг");
    Book product4 = new Book(4, "под куполом", 1300, "стивен кинг");
    Book product5 = new Book(5, "белый клык", 1600, "джек лондон");
    Smartphone product6 = new Smartphone(6, "iphone12", 40_000, "aple");
    Smartphone product7 = new Smartphone(7, "iphone13", 50_000, "aple");
    Smartphone product8 = new Smartphone(8, "galaxi S22", 45_000, "samsung");
    Smartphone product9 = new Smartphone(9, "redmi note", 30_000, "xiaomi");
    Smartphone product10 = new Smartphone(10, "galaxi", 60_000, "samsung");
    Product product11=new Product();
    Smartphone product12 = new Smartphone();
    Book product13 = new Book();


    @Test
    public void testRepoSave() {
        man.add(product1);
        man.add(product2);
        man.add(product3);
        man.add(product4);
        man.add(product5);
        man.add(product6);
        man.add(product7);
        man.add(product8);
        man.add(product9);
        man.add(product10);
        Product[] expected = {product1, product2, product3, product4, product5, product6, product7, product8, product9, product10};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRepoSaveNullProduct() {

        man.add(product11);
        Product[] expected = {product11};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testRepoSaveNullBook() {

        man.add(product13);
        Product[] expected = {product13};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testRepoSaveNullSmartphone() {

        man.add(product12);
        Product[] expected = {product12};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testRepoRemoveById(){
        man.add(product1);
        man.add(product2);
        man.add(product3);
        man.add(product4);
        man.add(product5);
        man.add(product6);
        man.add(product7);
        man.add(product8);
        man.add(product9);
        man.add(product10);
        repo.removeById(2);
        Product[] expected = {product1, product3, product4, product5, product6, product7, product8, product9, product10};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSeatrchBy(){
        man.add(product1);
        man.add(product2);
        man.add(product3);
        man.add(product4);
        man.add(product5);
        man.add(product6);
        man.add(product7);
        man.add(product8);
        man.add(product9);
        man.add(product10);

        Product[] expected = {product4};
        Product[] actual = man.searchBy("под куполом");
        Assertions.assertArrayEquals(expected, actual);

    }

}



