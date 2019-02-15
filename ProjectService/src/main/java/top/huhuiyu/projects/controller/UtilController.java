package top.huhuiyu.projects.controller;

import java.io.OutputStream;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.huhuiyu.api.utils.ImageCode;
import top.huhuiyu.projects.model.UtilModel;
import top.huhuiyu.projects.service.UtilService;

/**
 * 工具类控制器
 * 
 * @author 胡辉煜
 */
@RestController
@RequestMapping("/util")
public class UtilController {

  @Autowired
  private UtilService utilService;

  @RequestMapping("/validate.jpg")
  public void imageCode(UtilModel model, HttpServletResponse response) throws Exception {
    // {}
    // 自定义应答类型为图片
    response.setContentType("image/jpeg");
    // 获取图片校验码
    String code = utilService.makeImageCode(model);
    // 将图片通过response输出
    OutputStream os = response.getOutputStream();
    ImageIO.write(ImageCode.makeImage(code), "jpeg", os);
    os.close();
  }

}
