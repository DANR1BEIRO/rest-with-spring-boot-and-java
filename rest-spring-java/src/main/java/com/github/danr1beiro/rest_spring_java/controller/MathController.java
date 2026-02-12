package com.github.danr1beiro.rest_spring_java.controller;

import com.github.danr1beiro.rest_spring_java.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/sum/{strNumber1}/{strNumber2}")
    public Double sum(
            @PathVariable("strNumber1") String strNumber1,
            @PathVariable("strNumber2") String strNumber2

    ) throws Exception {
        if (!isNumeric(strNumber1) || !isNumeric(strNumber2)) {
            throw new UnsupportedMathOperationException("");
        }
        return convertToDouble(strNumber1) + convertToDouble(strNumber2);
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }
}

