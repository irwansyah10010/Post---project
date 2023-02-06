package com.lawencon.demo.service;

import java.util.List;

import com.lawencon.demo.dto.BaseInsertRes;
import com.lawencon.demo.dto.BaseListRes;
import com.lawencon.demo.dto.BaseUpdateOrDeleteRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lawencon.demo.model.Product;
import com.lawencon.demo.repo.ProductRepo;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;

    public BaseListRes<Product> getAll(){
        BaseListRes<Product> baseListRes = new BaseListRes<>();

        List<Product> products = productRepo.getAll(Product.class,null,null);

        baseListRes.setData(products);
        baseListRes.setCountOfData(productRepo.countOfData(Product.class));

        return baseListRes;
    }

    public BaseInsertRes save(Product product){
        BaseInsertRes baseInsertRes = new BaseInsertRes();

        Product productInsert = productRepo.save(product);

        if(productInsert != null){
            baseInsertRes.setId(productInsert.getId());

            baseInsertRes.setMessage("Product has been added");
        }else{
            baseInsertRes.setMessage("Product isn't failed to save");
        }

        return baseInsertRes;
    }

    public BaseUpdateOrDeleteRes update(Product product){
        BaseUpdateOrDeleteRes baseUpdateOrDeleteRes = new BaseUpdateOrDeleteRes();

        if(!product.getId().equals(null)){

            Product productFind = productRepo.findById(Product.class,product.getId());

            if(productFind != null){
                Product productUpdate = productRepo.update(product);

                if(productUpdate != null){
                    baseUpdateOrDeleteRes.setMessage("Product has been updated");
                }else {
                    baseUpdateOrDeleteRes.setMessage("Product isn't failed to update");
                }
            }else{
                baseUpdateOrDeleteRes.setMessage("Product isn't found");
            }
        }

        return baseUpdateOrDeleteRes;
    }

    public BaseUpdateOrDeleteRes delete(Product product){
        BaseUpdateOrDeleteRes baseUpdateOrDeleteRes = new BaseUpdateOrDeleteRes();

        if(!product.getId().equals(null)){

            Product productFind = productRepo.findById(Product.class,product.getId());

            if(productFind != null){
                productRepo.delete(product);

                baseUpdateOrDeleteRes.setMessage("Product has been delete");

            }else{
                baseUpdateOrDeleteRes.setMessage("Product isn't found");
            }
        }

        return baseUpdateOrDeleteRes;
    }

}
