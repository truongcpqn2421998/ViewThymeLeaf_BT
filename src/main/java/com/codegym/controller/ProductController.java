package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
//    @Autowired
    private IProductService productService = new ProductService();

    @GetMapping("")
    public ModelAndView list(){
        List<Product> products=productService.findAll();
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("products",products);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        Product product=productService.findById(id);
        model.addAttribute("product",product);
        return "edit";
    }

    @PostMapping("/set")
    public String update(@ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("success","update success");
        return "redirect:/product";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id,RedirectAttributes redirectAttributes){
        productService.remove(id);
        redirectAttributes.addFlashAttribute("success","delete complete");
        return "redirect:/product";
    }

    @GetMapping("/create")
    public String create(Model model){
        Product product=new Product();
        model.addAttribute("product",product);
        return "/create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Product product,RedirectAttributes redirectAttributes){
        productService.save(product);
        redirectAttributes.addFlashAttribute("success","create complete");
        return "redirect:/product";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable int id,Model model){
        Product product=productService.findById(id);
        model.addAttribute("product",product);
        return "view";
    }

    @GetMapping("/search")
    public String search(@RequestParam String search,Model model){
        List<Product> products=productService.search(search);
        model.addAttribute("products",products);
        return "index";

    }

}
