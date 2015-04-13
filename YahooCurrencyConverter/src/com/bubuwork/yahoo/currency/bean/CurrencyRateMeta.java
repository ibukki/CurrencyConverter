package com.bubuwork.yahoo.currency.bean;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("meta")
public class CurrencyRateMeta implements Serializable{
  
  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;
  
  @XStreamAlias("type")
  private String type;

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }
  
}
