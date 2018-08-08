package com.yang.springbootintegrated.task.timed;

import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 测试定时任务
 * 
 * @Description:TestTimedTask
 * @author:yanglin
 * @time:2018年8月8日 下午10:48:08
 */
@Component
public class TestTimedTask {
	// 表示方法执行完成后5秒
	@Scheduled(fixedDelay = 5000)
	public void fixedDelayJob() throws InterruptedException {
		System.out.println("fixedDelay 每隔5秒" + new Date());
	}

	// 表示每隔3秒
	@Scheduled(fixedRate = 3000)
	public void fixedRateJob() {

		System.out.println("fixedRate 每隔3秒" + new Date());
	}

	/**
	 * 表示每天3时15分0秒执行---关于cron表达式写法，可以参考 http://cron.qqe2.com/
	 */
	@Scheduled(cron = "0 15 3 * * ?")
	public void cronJob() {
		System.out.println(new Date() + " ...>>cron....");
	}
}
