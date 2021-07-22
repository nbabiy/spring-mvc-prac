package com.nbabiy.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author nazariibabii
 */
@Service
public class CalculatorService {

    public int add(int a, int b) {
        return a+b;
    }

    public int sub(int a, int b) {
        return a-b;
    }

    public int mul(int a, int b) {
        return a*b;
    }

    public int div(int a, int b) {
        return a/b;
    }

}
