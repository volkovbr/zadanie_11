package ru.netology.repository;

import ru.netology.Exception.AlreadyExistsException;
import ru.netology.Exception.NotFoundException;
import ru.netology.domane.Product;

public class RepositoryProduct {
    private Product product=new Product();
    private Product[] items = new Product[0];

    public void save(Product item) {
        if(findById(item.getId())!=null){
            throw new AlreadyExistsException("такой id уже есть:");
        }
        Product[] tmp = new Product[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }
    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id)==null){
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public Product[] getItems() {
        return items;
    }
}
