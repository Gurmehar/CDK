package com.cdk.billing;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import com.cdk.billing.entity.Discount;
import com.cdk.billing.entity.enums.CustomerType;

@Service
public class DiscountCalculator {
  private static final Logger LOG = LogManager.getLogger(DiscountCalculator.class);
  public Float getDiscountedBill(CustomerType customerType,float bill,List<Discount> _list) {
    float discountedBill=bill;
    long discountAmount=0L;
    
    
   for(Discount dis:_list) {
    if(customerType.equals(dis.getCustomerType())) {
      if(bill>dis.getUpperBound()) {
        discountAmount+=getDiscountedAmount((dis.getUpperBound()-dis.getLowerBound()),dis.getiDiscount());
      }else  {
        discountAmount+=getDiscountedAmount( bill-dis.getLowerBound(),dis.getiDiscount());
        break;
      }
    }
   }
   discountedBill-=discountAmount;
   LOG.info(" values of discount is{}, final amount is {} ::  {}",discountAmount,discountAmount);
    return discountedBill;
    
    
  }

  private float getDiscountedAmount(float amount, float discount) {
    LOG.info("amount is {} and discount is {}",amount,discount);
    return  ((amount*discount)/100);
  }
  
}
