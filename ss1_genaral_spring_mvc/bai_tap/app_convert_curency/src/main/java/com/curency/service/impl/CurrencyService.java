package com.curency.service.impl;

import com.curency.service.ICurrency;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrency {


    @Override
    public double convert(int a) {
        return a * 23000;
    }
}
