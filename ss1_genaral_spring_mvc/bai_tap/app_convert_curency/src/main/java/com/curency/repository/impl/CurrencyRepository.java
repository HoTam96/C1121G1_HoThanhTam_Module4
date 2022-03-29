package com.curency.repository.impl;

import com.curency.repository.ICurrency;
import org.springframework.stereotype.Repository;

@Repository
public class CurrencyRepository implements ICurrency {


    @Override
    public double convert(int a) {
        return a * 23000;
    }
}
