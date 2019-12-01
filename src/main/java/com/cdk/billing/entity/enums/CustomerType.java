
package com.cdk.billing.entity.enums;

import java.util.Arrays;
import java.util.Optional;

public enum CustomerType {

  Regular("regular"),Premium("premium"),New("new");
  
  private String type;
  
  CustomerType(String type) {
    this.type=type;
  }

  public static CustomerType getCustomerType(String customerType) throws Exception {
   Optional<CustomerType> findFirst = Arrays.stream( CustomerType.values()).filter(p -> p.type.equalsIgnoreCase(customerType)).findFirst();
  if(findFirst.isPresent()) {
    return findFirst.get();
  }
 throw new Exception("Invalid Customer Type");
  }
  
}
