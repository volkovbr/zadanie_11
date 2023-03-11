package ru.netology.manager;

import ru.netology.domane.Product;
import ru.netology.repository.RepositoryProduct;

public class ProductManager {
    private RepositoryProduct repo;

    public ProductManager(RepositoryProduct repo) {
        this.repo = repo;
    }

    public void add(Product item) {
        repo.save(item);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.getItems()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getNameProduct().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
