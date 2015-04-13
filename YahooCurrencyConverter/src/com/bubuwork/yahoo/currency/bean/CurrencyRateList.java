package com.bubuwork.yahoo.currency.bean;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("list")
public class CurrencyRateList implements Serializable{
  
  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;

  @XStreamAlias("meta")
  private CurrencyRateMeta meta;
  
  @XStreamAlias("resources")
  private CurrencyRateResources resources;

  /**
   * @return the meta
   */
  public CurrencyRateMeta getMeta() {
    return meta;
  }

  /**
   * @param meta the meta to set
   */
  public void setMeta(CurrencyRateMeta meta) {
    this.meta = meta;
  }

  /**
   * @return the resources
   */
  public CurrencyRateResources getResources() {
    return resources;
  }

  /**
   * @param resources the resources to set
   */
  public void setResources(CurrencyRateResources resources) {
    this.resources = resources;
  }
  
}
