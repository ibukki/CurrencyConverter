package com.bubuwork.yahoo.currency;

import java.io.IOException;
import java.util.Map;

import com.bubuwork.yahoo.currency.bean.CurrencyConvertBean;
import com.bubuwork.yahoo.currency.exception.CurrencyNotFoundException;
import com.bubuwork.yahoo.currency.provider.CurrencyRateProvider;
import com.bubuwork.yahoo.currency.provider.YahooCurrencyRateProvider;

public class CurrencyConverter {
  
  private Map<String, CurrencyConvertBean> currencyMap;
  
  private CurrencyRateProvider currencyRateProvider;
  
  public CurrencyConverter(CurrencyRateProvider provider){
    this.currencyRateProvider = provider;
  }
  
  public CurrencyConverter(){
    this.currencyRateProvider = new YahooCurrencyRateProvider();
  }
  
  public double convertAmout(String fromCurrency, String toCurrency, double fromAmount) throws CurrencyNotFoundException{
    double toAmount = 0d;
    try {
      if(currencyMap == null){
        currencyMap = this.currencyRateProvider.loadCurrencyRateMap();
      }
      
      if("USD".equalsIgnoreCase(fromCurrency)){
        CurrencyConvertBean convertBean = currencyMap.get(toCurrency);
        if(convertBean == null){
          throw new CurrencyNotFoundException("currency " + toCurrency + " is not found");
        }
        
        toAmount = fromAmount * convertBean.getRate();
      }
      
      if("USD".equalsIgnoreCase(toCurrency)){
        CurrencyConvertBean convertBean = currencyMap.get(fromCurrency);
        if(convertBean == null){
          throw new CurrencyNotFoundException("currency " + fromCurrency + " is not found");
        }
        toAmount = fromAmount / convertBean.getRate();
      }
      
      //for non USD convert, need to first convert it into USD
      if(!"USD".equalsIgnoreCase(fromCurrency) && !"USD".equalsIgnoreCase(toCurrency)){
        CurrencyConvertBean convertBean = currencyMap.get(fromCurrency);
        if(convertBean == null){
          throw new CurrencyNotFoundException("currency " + fromCurrency + " is not found");
        }
        double usdAmount = fromAmount / convertBean.getRate();
        
        convertBean = currencyMap.get(toCurrency);
        if(convertBean == null){
          throw new CurrencyNotFoundException("currency " + toCurrency + " is not found");
        }
        
        toAmount = usdAmount * convertBean.getRate();
      }
      
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return toAmount;
  }
  
  public static void main(String[] args) throws CurrencyNotFoundException {
    CurrencyConverter converter = new CurrencyConverter();
    double amount = converter.convertAmout("THB", "CNY", 1);
    System.out.println(amount);
  }
}
