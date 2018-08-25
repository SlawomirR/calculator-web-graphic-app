package io.github.slawomirr.calculator.model;

import org.springframework.stereotype.Component;

@Component
public class CalculatorDisplay {

    private String calculatorDisplay;

    public CalculatorDisplay(String calculatorDisplay) {
        this.calculatorDisplay = calculatorDisplay;
    }

    public CalculatorDisplay() {
        calculatorDisplay = "";
    }

    public String getCalculatorDisplay() {
        return calculatorDisplay;
    }

    public void setCalculatorDisplay(String calculatorDisplay) {
        this.calculatorDisplay = calculatorDisplay;
    }
}
