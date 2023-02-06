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

import com.lawencon.demo.model.Product;
import com.lawencon.demo.service.ProductService;

@Controller
@RequestMapping("products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

}
