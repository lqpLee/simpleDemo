package org.lee.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时任务
 * <p>
 * Created by liqiangpeng on 2017/7/6.
 */
public class TimerTest extends TimerTask {

    private String jobName = "";

    private Integer count = 0;

    //定义天
    private static long day = 1 * 1000 * 60 * 60 * 24;
    //定义秒
    private static long second = 1 * 1000;


    public TimerTest(String jobName) {
        super();
        this.jobName = jobName;
    }


    /**
     * 在此处写业务代码
     */
    @Override
    public void run() {
        System.out.println("==============定时任务启动====================");
        System.out.println("第" + ++count + "次执行");
        System.out.println("任务名:" + jobName + "执行");
    }

    /**
     * 在此处写参数
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("=======程序开始执行=========");
        if (args.length == 3) {
            System.out.println("参数一：" + args[0]);
            System.out.println("参数一：" + args[1]);
            System.out.println("参数一：" + args[2]);
            Timer timer = new Timer();
            int excuteFirst = Integer.parseInt(args[1]);
            int excuteInterval = Integer.parseInt(args[2]);
            long delay = second * excuteFirst;
            long period = day * excuteInterval;
            //从现在开始 1 秒钟之后，每隔1秒种执行一次job1
            timer.schedule(new TimerTest(args[0]), delay, period);

        } else {
            System.out.println("！！！！！！！！参数输入错误！！！！！！！！");
        }
    }

}
