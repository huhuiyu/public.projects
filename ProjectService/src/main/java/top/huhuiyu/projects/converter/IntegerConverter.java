package top.huhuiyu.projects.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import top.huhuiyu.api.utils.StringUtils;

/**
 * Integer数值转换器
 * 
 * @author 胡辉煜
 */
@Component
public class IntegerConverter implements Converter<String, Integer> {

  @Override
  public Integer convert(String source) {
    if (StringUtils.isEmpty(source)) {
      return null;
    }
    source = StringUtils.trim(source);
    try {
      return Integer.parseInt(source);
    }
    catch (Exception ex) {
    }
    return null;
  }

}
