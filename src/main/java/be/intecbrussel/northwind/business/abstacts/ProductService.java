package be.intecbrussel.northwind.business.abstacts;

import be.intecbrussel.northwind.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
}
