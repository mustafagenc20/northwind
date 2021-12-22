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

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>(this.productDao.getByProductName(productName), "Data listed");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategoryId(productName, categoryId), "Data listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategoryId(productName, categoryId), "Data listed");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return null;
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return null;
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return null;
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return null;
    }
}
