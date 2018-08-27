package io.github.slawomirr.calculator.services;

import io.github.slawomirr.calculator.model.CalculatorDisplay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Service
public class CalculatorService {

    private static final Logger LOG = LoggerFactory.getLogger(CalculatorService.class);
    private CalculatorDisplay calculatorDisplay;

    public CalculatorService(CalculatorDisplay calculatorDisplay) {
        this.calculatorDisplay = calculatorDisplay;
    }

    public void clearDisplay() {
        calculatorDisplay.setCalculatorDisplay("");
    }

    public String showOnDisplay() {
        return calculatorDisplay.getCalculatorDisplay();
    }

    public void addNumber(String number) {
        calculatorDisplay.setCalculatorDisplay(calculatorDisplay.getCalculatorDisplay() + number);
    }

    public void addSymbol(String sign) {
        switch (sign) {
            case "divide":
                calculatorDisplay.setCalculatorDisplay(calculatorDisplay.getCalculatorDisplay() + "/");
                break;
            case "multiply":
                calculatorDisplay.setCalculatorDisplay(calculatorDisplay.getCalculatorDisplay() + "*");
                break;
            case "minus":
                calculatorDisplay.setCalculatorDisplay(calculatorDisplay.getCalculatorDisplay() + "-");
                break;
            case "plus":
                calculatorDisplay.setCalculatorDisplay(calculatorDisplay.getCalculatorDisplay() + "+");
                break;
            default:
                System.out.println("WARNING: CalculatorService addSymbol() - something unexpected: " + sign);
        }
    }

    public String calculate() {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            return engine.eval(calculatorDisplay.getCalculatorDisplay()).toString();
        } catch (ScriptException e) {
            LOG.error("calculate() method of : ", e);
            return "Expression ERROR";
        }
    }
}
