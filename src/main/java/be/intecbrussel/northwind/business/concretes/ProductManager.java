package be.intecbrussel.northwind.business.concretes;

import be.intecbrussel.northwind.business.abstacts.ProductService;
import be.intecbrussel.northwind.dataAccess.abstacts.ProductDao;
import be.intecbrussel.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return this.productDao.findAll();
    }
}
