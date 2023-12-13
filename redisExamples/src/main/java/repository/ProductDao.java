package repository;

import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public class ProductDao implements Serializable {
    public static final String HASH_KEY = "Product";
   @Autowired
   private RedisTemplate<String, Object> redisTemplate; // Corrected the autowired field type
    public Product save(Product product) {
        redisTemplate.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }


    //returna all products
    public List<Object> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY);
    }

    //return a product by id
    public Product findProductById(int id) {
        return (Product) redisTemplate.opsForHash().get(HASH_KEY, id);
    }

    //delete a product based on id
    public String deleteProduct(int id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        return "Product removed !!";
    }
}
