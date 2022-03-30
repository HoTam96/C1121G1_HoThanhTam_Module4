package codegym.repository.impl;


import codegym.repository.ICaculator;
import org.springframework.stereotype.Controller;

@Controller
public class Caculator implements ICaculator {


    @Override
    public double plus(double a, double b) {
        return a+b;
    }

    @Override
    public double minus(double a, double b) {
        return a-b;
    }

    @Override
    public double mutiplication(double a, double b) {
        return a * b ;
    }

    @Override
    public double division(double a, double b) {
        return a / b;
    }
}
