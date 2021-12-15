package be.intecbrussel.northwind.api.controllers;

import be.intecbrussel.northwind.business.abstacts.ProductService;
import be.intecbrussel.northwind.core.utilities.results.Result;
import be.intecbrussel.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public List<Product> getAll(){
        return this.productService.getAll();
    }

    @PostMapping("/add")
    public Result add(Product product){
        return new Result(true,"Product added");
    }
}
