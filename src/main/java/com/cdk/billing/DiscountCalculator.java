package com.cdk.billing;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.cdk.billing.entity.Discount;
import com.cdk.billing.entity.enums.CustomerType;

@Service
public class DiscountCalculator {
  
  public Long getDiscountedBill(CustomerType customerType,Long bill,List<Discount> _list) {
    
    Optional<Discount> findFirst = _list.parallelStream().filter(p ->p.getCustomerType().equals(customerType))
    .filter(p-> p.getLowerBound()<=bill)
    .filter(p->p.getUpperBound()>=bill).findFirst();
    if(findFirst.isPresent()) {
      Discount discount=findFirst.get();
      return ((long) (bill- ((bill * discount.getiDiscount())/100)));
    }
    return bill;
    
    
  }
  
}
