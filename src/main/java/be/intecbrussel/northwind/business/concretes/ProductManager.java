package be.intecbrussel.northwind.business.concretes;

import be.intecbrussel.northwind.business.abstacts.ProductService;
import be.intecbrussel.northwind.core.utilities.results.DataResult;
import be.intecbrussel.northwind.core.utilities.results.Result;
import be.intecbrussel.northwind.core.utilities.results.SuccessDataResult;
import be.intecbrussel.northwind.core.utilities.results.SuccessResult;
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
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data listed");
    }

    @Override
    public Result add(Product product){
        this.productDao.save(product);
        return new SuccessResult("Product added");
    }
}
