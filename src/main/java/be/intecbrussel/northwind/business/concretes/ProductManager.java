package be.intecbrussel.northwind.business.concretes;

import be.intecbrussel.northwind.business.abstacts.ProductService;
import be.intecbrussel.northwind.core.utilities.results.DataResult;
import be.intecbrussel.northwind.core.utilities.results.Result;
import be.intecbrussel.northwind.core.utilities.results.SuccessDataResult;
import be.intecbrussel.northwind.core.utilities.results.SuccessResult;
import be.intecbrussel.northwind.dataAccess.abstacts.ProductDao;
import be.intecbrussel.northwind.entities.concretes.Product;
import be.intecbrussel.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public DataResult<List<Product>> getAllSorted() {
        Sort sort =Sort.by(Sort.Direction.DESC, "productName");
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort), "Succeed");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
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
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Data listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Data listed");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories), "Data listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName), "Data listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName), "Data listed");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId), "Data listed");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(), "Data listed");
    }
//
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId){
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(String productName));
    }

    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId){
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(String productName));
    }

    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId){
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(String productName));
    }
}
