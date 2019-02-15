package top.huhuiyu.projects.converter;

import org.springframework.core.convert.converter.Converter;
import top.huhuiyu.api.utils.StringUtils;

/**
 * 字符串转换器（去空）
 * 
 * @author 胡辉煜
 */
public class StringConverter implements Converter<String, String> {

  @Override
  public String convert(String source) {
    return StringUtils.trim(source);
  }

}
