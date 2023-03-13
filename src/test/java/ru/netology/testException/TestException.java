package ru.netology.testException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Exception.AlreadyExistsException;
import ru.netology.Exception.NotFoundException;
import ru.netology.domane.Book;
import ru.netology.domane.Product;
import ru.netology.domane.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.RepositoryProduct;

public class TestException {
    public RepositoryProduct repo = new RepositoryProduct();
    public ProductManager man = new ProductManager(repo);
    Book product1 = new Book(1, "война и мир", 1200, "толстой");
    Book product2 = new Book(2, "темная башня", 500, "стивен кинг");
    Book product3 = new Book(3, "стрелок", 120, "стивен кинг");
    Book product4 = new Book(4, "под куполом", 1300, "стивен кинг");
    Smartphone product15 = new Smartphone(1, "samsung", 12000, "samsung");

    @Test
    public void testRepoRemoveById() {
        man.add(product1);
        man.add(product2);
        man.add(product3);
        man.add(product4);
        repo.removeById(2);
        Product[] expected = {product1, product3, product4};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotFoundId() {
        man.add(product1);
        man.add(product2);
        man.add(product3);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });
    }


    @Test
    public void testRepoSave() {
        man.add(product1);
        man.add(product2);
        man.add(product3);
        man.add(product4);

        Product[] expected = {product1, product2, product3, product4};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testNotFoundId1() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            man.add(product1);man.add(product15);
        });
    }
}


