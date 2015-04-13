package com.bubuwork.yahoo.currency.bean;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("resources")
public class CurrencyRateResources {
  
  @XStreamImplicit(itemFieldName="resource")
  private List<CurrencyRateResource> resources;
  
  @XStreamAsAttribute
  private int start;
  
  @XStreamAsAttribute
  private int count;

  /**
   * @return the resources
   */
  public List<CurrencyRateResource> getResources() {
    return resources;
  }

  /**
   * @param resources the resources to set
   */
  public void setResources(List<CurrencyRateResource> resources) {
    this.resources = resources;
  }

  /**
   * @return the start
   */
  public int getStart() {
    return start;
  }

  /**
   * @param start the start to set
   */
  public void setStart(int start) {
    this.start = start;
  }

  /**
   * @return the count
   */
  public int getCount() {
    return count;
  }

  /**
   * @param count the count to set
   */
  public void setCount(int count) {
    this.count = count;
  }
  
}
