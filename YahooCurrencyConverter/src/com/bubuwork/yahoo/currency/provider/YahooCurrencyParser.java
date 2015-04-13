package com.bubuwork.yahoo.currency.provider;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bubuwork.yahoo.currency.CurrencyConstant;
import com.bubuwork.yahoo.currency.bean.CurrencyConvertBean;
import com.bubuwork.yahoo.currency.bean.CurrencyRateField;
import com.bubuwork.yahoo.currency.bean.CurrencyRateList;
import com.bubuwork.yahoo.currency.bean.CurrencyRateMeta;
import com.bubuwork.yahoo.currency.bean.CurrencyRateResource;
import com.bubuwork.yahoo.currency.bean.CurrencyRateResources;
import com.bubuwork.yahoo.currency.reader.CurrencyReader;
import com.thoughtworks.xstream.XStream;

public class YahooCurrencyParser {
  
  public CurrencyRateList parse() throws IOException{
    String content = CurrencyReader.loadCurrenyQuote(false);
    if(content != null && content.length() > 0){
      XStream stream = new XStream();
      stream.alias("list", CurrencyRateList.class);
      stream.alias("meta",CurrencyRateMeta.class);
      stream.alias("resources", CurrencyRateResources.class);
      stream.alias("resource", CurrencyRateResource.class);
      stream.alias("field", CurrencyRateField.class);
      stream.autodetectAnnotations(true);
      
      CurrencyRateList list = (CurrencyRateList) stream.fromXML(content);
      return list;
    }
    return null;
  }
  
  
  public Map<String, CurrencyConvertBean> getCurrencyRateMap(CurrencyRateList list){
    Map<String, CurrencyConvertBean> currencyRateMap = new HashMap<String, CurrencyConvertBean>();
    if(list != null){
      List<CurrencyRateResource> resourceList = list.getResources().getResources();
      if(resourceList != null){
        for (CurrencyRateResource resource : resourceList) {
          List<CurrencyRateField> fieldList = resource.getFields();
          CurrencyConvertBean convertBean = null;
          
          for (CurrencyRateField field : fieldList) {
            String name = null;
            String rate = null;
            String ts = null;
            if( field.getName().equals(CurrencyConstant.FIELD_NAME_NAME)){
              name = field.getValue();
              if(name.startsWith("USD") && name.indexOf("/") > 0){
                String curs[] = name.split("/");
                convertBean = new CurrencyConvertBean();
                convertBean.setFromCurrency(curs[0]);
                convertBean.setToCurrency(curs[1]);
              }
            }
            if( field.getName().equals(CurrencyConstant.FIELD_NAME_PRRICE)){
              rate = field.getValue();
              if(convertBean != null){
                convertBean.setRate(Double.valueOf(rate));
              }
            }
            
            if( field.getName().equals(CurrencyConstant.FIELD_NAME_TS)){
              ts = field.getValue();
              if(convertBean != null){
                convertBean.setEffectiveDate(new Date(Long.parseLong(ts)));
              }
            }
            
            if(convertBean != null){
              currencyRateMap.put(convertBean.getToCurrency(), convertBean);
            }
          }
        }
      }
    }
    return currencyRateMap;
  }
  
  
  public static void main(String[] args) {
    YahooCurrencyParser parser = new YahooCurrencyParser();
    try {
      Map<String, CurrencyConvertBean> currencyRateMap = parser.getCurrencyRateMap(parser.parse());
      for (String key : currencyRateMap.keySet()) {
        System.out.println(key);
        System.out.println(currencyRateMap.get(key).getRate());
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
