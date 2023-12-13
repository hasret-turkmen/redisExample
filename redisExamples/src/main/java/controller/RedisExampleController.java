package controller;

import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.ProductDao;

import java.util.List;

@RestController
@RequestMapping("/product")
public class RedisExampleController {

    @Autowired
    private ProductDao productDao;

    //save the product object
    @PostMapping
    public Product save(@RequestBody Product product){
        return productDao.save(product);
    }

    //get all products
    @GetMapping
    public List<Object> getAll(){
        return productDao.findAll();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable int id) {
        return productDao.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productDao.deleteProduct(id);
    }

}
