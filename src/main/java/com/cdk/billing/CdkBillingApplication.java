package com.cdk.billing;

import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cdk.billing.config.YamlReader;
import com.cdk.billing.entity.Discount;
import com.cdk.billing.entity.enums.CustomerType;

@SpringBootApplication
public class CdkBillingApplication implements CommandLineRunner {
  private static final Logger LOG = LogManager.getLogger(CdkBillingApplication.class);


  @Autowired
  private YamlReader yamlReader;
  @Autowired
  private DiscountCalculator discountCalculator;

  public static void main(String[] args) {
    SpringApplication.run(CdkBillingApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    try {
      LOG.info("Input Customer and Purcchase Amount :: eg Regular 12345");

      List<Discount> discountList = yamlReader.readYaml();
      Scanner in = new Scanner(System.in);
      String text = in.nextLine();
      String customerType = null;
      float purchaseAmount = 0.0f;

      String temp[] = text.split(" ");
      if (temp.length == 2) {
        customerType = temp[0];
        purchaseAmount = Float.parseFloat(temp[1]);
      }

      CustomerType customerType2 = CustomerType.getCustomerType(customerType);

      if (purchaseAmount < 0) {
        LOG.info("No Purchase, No discount :P");
      }

      LOG.info("Customer is :: {} and Purchase is {}", customerType2, purchaseAmount);
      float discountedBill =
          discountCalculator.getDiscountedBill(customerType2, purchaseAmount, discountList);
      LOG.info(discountedBill);
    } catch (java.util.InputMismatchException e) {
      LOG.info("No Purchase, No discount :P");

    } catch (Exception e) {
      LOG.info("Something Bad Happened ..." + e.getMessage());
      System.exit(0);
    }
    System.exit(0);
  }

}
