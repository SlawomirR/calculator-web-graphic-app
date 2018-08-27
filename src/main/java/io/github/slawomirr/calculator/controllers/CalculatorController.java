package io.github.slawomirr.calculator.controllers;

import io.github.slawomirr.calculator.services.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatorController.class);
    private CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(value = {"/", "/index", "/index.html"})
    public String index(Model model) {
        String showOnDisplay = calculatorService.showOnDisplay();
        LOG.debug("HTTP.GET - index(" + showOnDisplay + ")");
        model.addAttribute("displayString", showOnDisplay);
        return "index";
    }

    @GetMapping("/result")
    public String result(Model model) {
        String calculate = calculatorService.calculate();
        LOG.debug("HTTP.GET - result(" + calculate + ")");
        model.addAttribute("displayString", calculate);
        calculatorService.clearDisplay();
        return "index";
    }

    @PostMapping("/addNumber/{number}")
    public String addNumber(@PathVariable String number) {
        LOG.debug("HTTP.POST - addNumber(" + number + ")");
        calculatorService.addNumber(number);
        return "redirect:/";
    }

    @PutMapping("/addOperation/{sign}")
    public String addSign(@PathVariable String sign) {
        LOG.debug("HTTP.PUT - addSign(" + sign + ")");
        calculatorService.addSymbol(sign);
        return "redirect:/";
    }

    @DeleteMapping("/clearDisplay")
    public String clearDisplay() {
        LOG.debug("HTTP.DELETE - clearDisplay()");
        calculatorService.clearDisplay();
        return "redirect:/";
    }
}
