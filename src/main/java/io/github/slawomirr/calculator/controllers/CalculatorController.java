package io.github.slawomirr.calculator.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatorController.class);

    @GetMapping(value = {"/", "/index", "/index.html"})
    public String index() {
        LOG.debug("HTTP.GET - index()");

        return "index";
    }

    @GetMapping("/result")
    public String result() {
        LOG.debug("HTTP.GET - result()");

        return "index";
    }

    @PostMapping("/addNumber/{number}")
    public String addNumber(@PathVariable String number) {
        LOG.debug("HTTP.POST - addNumber()");

        return "redirect:/";
    }

    @PutMapping("/addOperation/{sign}")
    public String addSign(@PathVariable String sign) {
        LOG.debug("HTTP.PUT - addSign()");

        return "redirect:/";
    }

    @DeleteMapping("/clearDisplay")
    public String clearDisplay() {
        LOG.debug("HTTP.DELETE - clearDisplay()");

        return "redirect:/";
    }
}
