package kodlamio.northwind.api.controllers;

import kodlamio.northwind.business.abstracts.ProductService;
import kodlamio.northwind.core.utilities.results.DataResult;
import kodlamio.northwind.core.utilities.results.Result;
import kodlamio.northwind.entities.concretes.Product;
import kodlamio.northwind.entities.concretes.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin
public class ProductsController {

    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll(){

        return this.productService.getAll();
    }

    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){

        return this.productService.getProductWithCategoryDetails();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){

        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);

    }
    @GetMapping("getByProductNameAndCategory")
    public DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategory(productName,categoryId);
    }
    @GetMapping("getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }

    @GetMapping("getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int padeSize){
        return this.productService.getAll(pageNo,padeSize);
    }

    @GetMapping("getAllDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }

}
