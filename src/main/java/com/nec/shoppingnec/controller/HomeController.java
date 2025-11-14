// java
package com.nec.shoppingnec.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "ShoppingNec API is running. Use /api/products (or your endpoints) to interact.";
    }
}
