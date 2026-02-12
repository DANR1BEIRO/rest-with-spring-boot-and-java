package com.github.danr1beiro.rest_spring_java.controller;

import com.github.danr1beiro.rest_spring_java.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/sum/{number1}/{number2}")
    public Double sum(@PathVariable("number1") String strNumber1, @PathVariable("number2") String strNumber2) {

        if (!isNumeric(strNumber1) || !isNumeric(strNumber2)) {
            throw new UnsupportedMathOperationException("set a numeric value");
        }
        return convertToDouble(strNumber1) + convertToDouble(strNumber2);
    }

    private Double convertToDouble(String strNumber) {
        String number = strNumber.replaceAll(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty()) return false;
        return strNumber.replaceAll(",", ".").matches("[+-]?[0-9]*\\.?[0-9]+");
    }
}

