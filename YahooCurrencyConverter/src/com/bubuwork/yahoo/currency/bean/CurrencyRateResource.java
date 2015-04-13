package com.bubuwork.yahoo.currency.bean;

import java.io.Serializable;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("resource")
public class CurrencyRateResource implements Serializable{
  
  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;

  @XStreamAsAttribute
  private String classname;
  
  @XStreamImplicit(itemFieldName="field")
  private List<CurrencyRateField> fields;
  
  
  /**
   * @return the classname
   */
  public String getClassname() {
    return classname;
  }

  /**
   * @param classname the classname to set
   */
  public void setClassname(String classname) {
    this.classname = classname;
  }

  /**
   * @return the fields
   */
  public List<CurrencyRateField> getFields() {
    return fields;
  }

  /**
   * @param fields the fields to set
   */
  public void setFields(List<CurrencyRateField> fields) {
    this.fields = fields;
  }
  
}
