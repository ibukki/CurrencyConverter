package com.bubuwork.yahoo.currency.bean;

import java.util.Date;

public class CurrencyConvertBean {
  
  String fromCurrency;
  
  String toCurrency;
  
  Double rate;
  
  Date effectiveDate;

  /**
   * @return the fromCurrency
   */
  public String getFromCurrency() {
    return fromCurrency;
  }

  /**
   * @param fromCurrency the fromCurrency to set
   */
  public void setFromCurrency(String fromCurrency) {
    this.fromCurrency = fromCurrency;
  }

  /**
   * @return the toCurrency
   */
  public String getToCurrency() {
    return toCurrency;
  }

  /**
   * @param toCurrency the toCurrency to set
   */
  public void setToCurrency(String toCurrency) {
    this.toCurrency = toCurrency;
  }

  /**
   * @return the rate
   */
  public Double getRate() {
    return rate;
  }

  /**
   * @param rate the rate to set
   */
  public void setRate(Double rate) {
    this.rate = rate;
  }

  /**
   * @return the effectiveDate
   */
  public Date getEffectiveDate() {
    return effectiveDate;
  }

  /**
   * @param effectiveDate the effectiveDate to set
   */
  public void setEffectiveDate(Date effectiveDate) {
    this.effectiveDate = effectiveDate;
  }
  
}
