package top.huhuiyu.projects.schedule;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.huhuiyu.projects.service.UtilService;

/**
 * 定时任务
 * 
 * @author 胡辉煜
 */
@Component
public class ScheduleTask {

  private static final Logger log = LoggerFactory.getLogger(ScheduleTask.class);

  @Autowired
  private UtilService utilService;

  @Scheduled(initialDelay = 3 * 1000, fixedDelay = 5 * 60 * 1000)
  public void deleteTokens() {
    try {
      log.debug("正在删除过期的token");
      int result = utilService.deleteTokens();
      log.debug(String.format("删除过期的token完成，数量为：%s", result));
    }
    catch (Exception ex) {
      log.error("删除过期的token发生错误", ex);
    }
  }

  @Scheduled(initialDelay = 1 * 1000, fixedDelay = 1 * 60 * 1000)
  public void queryNow() {
    try {
      Date now = utilService.queryNow();
      log.debug(String.format("数据库当前时间%tF %tT", now, now));
    }
    catch (Exception ex) {
      log.error("查询时间发生错误", ex);
    }
  }
}
