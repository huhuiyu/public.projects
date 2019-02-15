package top.huhuiyu.projects.converter;

import java.math.BigDecimal;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import top.huhuiyu.api.utils.StringUtils;

/**
 * BigDecimal数值转换器
 * 
 * @author 胡辉煜
 */
@Component
public class DecimalConverter implements Converter<String, BigDecimal> {

  @Override
  public BigDecimal convert(String source) {
    if (StringUtils.isEmpty(source)) {
      return null;
    }
    source = StringUtils.trim(source);
    try {
      return new BigDecimal(source);
    }
    catch (Exception ex) {
    }
    return null;
  }

}
