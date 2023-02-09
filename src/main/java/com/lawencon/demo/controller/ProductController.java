package com.lawencon.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lawencon.demo.dto.BaseListRes;
import com.lawencon.demo.model.Product;
import com.lawencon.demo.service.ProductService;

@Controller
@RequestMapping("products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("page/product/home-product");

        BaseListRes<Product> products = productService.getAll();

        modelAndView.addObject("products",products.getData());

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView("page/product/form-product");

        Product product = new Product();

        modelAndView.addObject("product",product);


        return modelAndView;
    }

    @PostMapping
    public RedirectView save(@ModelAttribute Product product){
        productService.save(product);

        return new RedirectView("/products");
    }
}
