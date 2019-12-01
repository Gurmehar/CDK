package com.cdk.billing;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cdk.billing.config.YamlReader;
import com.cdk.billing.entity.Discount;
import com.cdk.billing.entity.enums.CustomerType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CdkBillingApplicationTests {
  private static final Logger LOG = LogManager.getLogger(CdkBillingApplicationTests.class);
  @Autowired
  private YamlReader yamlReader;
  @Autowired
  private DiscountCalculator discountCalculator;
  private List<Discount> _list=new ArrayList<>();
  
  @Before
  public void init() {
    _list=yamlReader.readYaml();
  }
  
	@Test
	void contextLoads() {
	 discountCalculator.getDiscountedBill(CustomerType.Regular, 5000L, _list);
	 discountCalculator.getDiscountedBill(CustomerType.Regular, 10000L, _list);
	 discountCalculator.getDiscountedBill(CustomerType.Regular, 20000L, _list);
	}

}
