package com.bubuwork.yahoo.currency.bean;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

@XStreamAlias(value="field")
@XStreamConverter(value=ToAttributedValueConverter.class, strings={"value"})
public class CurrencyRateField implements Serializable{
  
  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;

  private String name;
  
  private String value;

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(String value) {
    this.value = value;
  }
  
}
