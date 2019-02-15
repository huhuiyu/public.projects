package top.huhuiyu.projects.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.huhuiyu.api.utils.mybase.INoToken;
import top.huhuiyu.api.utils.mybase.JsonMessage;
import top.huhuiyu.projects.base.IAdminAuth;
import top.huhuiyu.projects.base.IAuth;
import top.huhuiyu.projects.base.MyBaseModel;
import top.huhuiyu.projects.entity.TbAdmin;
import top.huhuiyu.projects.entity.TbToken;
import top.huhuiyu.projects.service.TbAdminService;
import top.huhuiyu.projects.service.UtilService;

/**
 * 控制器token切面
 * 
 * @author 胡辉煜
 */
@Aspect
@Component
public class ControllerToken extends BaseControllerAop {

  private static final Logger log = LoggerFactory.getLogger(ControllerToken.class);

  @Autowired
  private UtilService    utilService;
  @Autowired
  private TbAdminService tbAdminService;

  private boolean processAuthAdmin(ProceedingJoinPoint pjp) throws Exception {
    if (!(pjp.getTarget() instanceof IAdminAuth)) {
      return true;
    }
    MyBaseModel model = getMyBaseModel(pjp);
    if (model == null) {
      return true;
    }
    TbAdmin admin = tbAdminService.getTokenAdmin(model.makeTbTokenInfo());
    log.debug(String.format("admin=====>", admin));
    if (admin == null) {
      return false;
    }
    model.setLoginAdmin(admin);
    return true;
  }

  private MyBaseModel getMyBaseModel(ProceedingJoinPoint pjp) throws Exception {
    MyBaseModel model = null;
    Object[]    args  = pjp.getArgs();
    for (Object arg : args) {
      if (arg instanceof MyBaseModel) {
        model = (MyBaseModel) arg;
        break;
      }
    }
    return model;
  }

  private TbToken processToken(ProceedingJoinPoint pjp) throws Exception {
    if ((pjp.getTarget() instanceof INoToken)) {
      return null;
    }
    MyBaseModel model = getMyBaseModel(pjp);
    if (model != null) {
      TbToken token = model.makeTbToken();
      // 校验并更新token信息
      token = utilService.checkToken(token);
      model.setToken(token.getToken());
      return token;
    }
    return null;
  }

  @Around("controller()")
  public Object around(ProceedingJoinPoint pjp) throws Throwable {
    // token处理
    log.debug("控制器切面token处理");
    TbToken token = processToken(pjp);
    log.debug(String.format("token信息：%s", token));
    // admin登录处理
    if (!processAuthAdmin(pjp)) {
      return JsonMessage.getFail(IAuth.ADMIN, "需要登录");
    }

    Object result = pjp.proceed();
    // 如果应答为JsonMessage且token存在就应答回去
    if ((token != null) && (result instanceof JsonMessage)) {
      JsonMessage message = (JsonMessage) result;
      message.setToken(token.getToken());
    }
    return result;
  }

}
