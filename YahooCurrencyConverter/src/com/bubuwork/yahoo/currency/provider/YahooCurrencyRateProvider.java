package com.bubuwork.yahoo.currency.provider;

import java.io.IOException;
import java.util.Map;

import com.bubuwork.yahoo.currency.bean.CurrencyConvertBean;

public class YahooCurrencyRateProvider implements CurrencyRateProvider{

  public Map<String, CurrencyConvertBean> loadCurrencyRateMap() throws IOException {
    YahooCurrencyParser parser = new YahooCurrencyParser();
    return parser.getCurrencyRateMap(parser.parse());
  }

}
