package com.cdk.billing.entity;

import org.springframework.util.ObjectUtils;
import com.cdk.billing.entity.enums.CustomerType;

public class Discount {
   private  CustomerType customerType;
   private Long lowerBound=0L;
   private Long upperBound=Long.MAX_VALUE;
   private float iDiscount=0f;
   
   
  public void setCustomerType(CustomerType customerType) {
    this.customerType = customerType;
  }
  public void setLowerBound(Long lowerBound) {
    this.lowerBound = lowerBound;
  }
  public void setUpperBound(Long upperBound) {
    if(ObjectUtils.isEmpty(upperBound))
    this.upperBound = Long.MAX_VALUE;
    else
      this.upperBound = upperBound;
  }
  
  
  
  public float getiDiscount() {
    return iDiscount;
  }
  public void setiDiscount(float iDiscount) {
    this.iDiscount = iDiscount;
  }
  public CustomerType getCustomerType() {
    return customerType;
  }
  public Long getLowerBound() {
    return lowerBound;
  }
  public Long getUpperBound() {
    return upperBound;
  }
  
  @Override
  public String toString() {
    return "Discount [customerType=" + customerType + ", lowerBound=" + lowerBound + ", upperBound="
        + upperBound + ", discount=" + iDiscount + "]";
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((customerType == null) ? 0 : customerType.hashCode());
    result = prime * result + Float.floatToIntBits(iDiscount);
    result = prime * result + ((lowerBound == null) ? 0 : lowerBound.hashCode());
    result = prime * result + ((upperBound == null) ? 0 : upperBound.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Discount other = (Discount) obj;
    if (customerType != other.customerType)
      return false;
    if (Float.floatToIntBits(iDiscount) != Float.floatToIntBits(other.iDiscount))
      return false;
    if (lowerBound == null) {
      if (other.lowerBound != null)
        return false;
    } else if (!lowerBound.equals(other.lowerBound))
      return false;
    if (upperBound == null) {
      if (other.upperBound != null)
        return false;
    } else if (!upperBound.equals(other.upperBound))
      return false;
    return true;
  }
   
    

}
