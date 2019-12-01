package com.cdk.billing.config;

import java.io.InputStream;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import com.cdk.billing.entity.ConfigDiscounts;
import com.cdk.billing.entity.Discount;
@Service
public class YamlReader {
  private static final Logger LOG = LogManager.getLogger(YamlReader.class);
  
  public List<Discount> readYaml() {
    Constructor constructor = new Constructor(ConfigDiscounts.class);
    TypeDescription configDesc = new TypeDescription(ConfigDiscounts.class);
    configDesc.putListPropertyType("things", Discount.class);
    constructor.addTypeDescription(configDesc);
    Yaml yaml = new Yaml(constructor);
    InputStream inputStream = this.getClass()
        .getClassLoader()
        .getResourceAsStream("discount.yml");
    ConfigDiscounts config = (ConfigDiscounts) yaml.load(inputStream);
    LOG.info("{}",config.getDiscounts());
    return config.getDiscounts();
    
  }

}
