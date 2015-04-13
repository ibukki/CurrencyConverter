package com.bubuwork.yahoo.currency.exception;

public class CurrencyNotFoundException extends Exception {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;
  
  public CurrencyNotFoundException(String message){
    super(message);
  }

}
