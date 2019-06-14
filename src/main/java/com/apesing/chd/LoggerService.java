package com.apesing.chd;

import com.alibaba.fastjson.JSONObject;
import com.apesing.chd.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 日志记录服务
 *
 * @author pp
 **/
@Service
public class LoggerService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 日志记录
     *
     * @param actionName  方法名称
     * @param actionParam 传入参数列表
     * @param inputParam  传入参数
     * @param retuValue   返回结果
     * @param others      其他信息
     * @param logClass    记录类名
     */
    public void info(String actionName, String actionParam, String inputParam, JSONObject retuValue
            , JSONObject others, Class logClass) {
        log(actionName, actionParam, inputParam, retuValue
                , null, others, "info", logClass);
    }

    /**
     * 切面自动日志记录
     *
     * @param actionName  方法名称
     * @param actionParam 传入参数列表
     * @param inputParam  传入参数
     * @param retuValue   返回结果
     * @param others      其他信息
     * @param logClass    记录类名
     */
    public void autoInfo(String actionName, String actionParam, String inputParam, JSONObject retuValue
            , JSONObject others, Class logClass) {
        log(actionName, actionParam, inputParam, retuValue
                , null, others, "auto", logClass);
    }

    /**
     * 错误日志记录
     *
     * @param actionName  方法名称
     * @param actionParam 传入参数列表
     * @param inputParam  传入参数
     * @param retuValue   返回结果
     * @param throwable   报错信息
     * @param others      其他信息
     * @param logClass    记录类名
     */
    public void error(String actionName, String actionParam, String inputParam, JSONObject retuValue
            , Throwable throwable, JSONObject others, Class logClass) {
        log(actionName, actionParam, inputParam, retuValue
                , throwable, others, "error", logClass);
    }

    /**
     * 日志记录
     *
     * @param actionName  方法名称
     * @param actionParam 传入参数列表
     * @param inputParam  传入参数
     * @param retuValue   返回结果
     * @param throwable   报错信息
     * @param others      其他信息
     * @param type        日志类型
     * @param logClass    记录类名
     */
    private void log(String actionName, String actionParam, String inputParam, JSONObject retuValue
            , Throwable throwable, JSONObject others, String type, Class logClass) {
        JSONObject json = new JSONObject();
        //微服务名称
        String serverName = "chd";
        json.put("ServerName", serverName);
        json.put("ActionName", actionName);
        json.put("ActionParam", actionParam);
        json.put("InputParam", inputParam);
        json.put("ReturnValue", retuValue.toJSONString());
        json.put("Type", type);
        json.put("LogClass", logClass.getName());
        json.put("Others", others);
        json.put("ActionTime", TimeUtil.getCurrentDate(null));
        //获取详细错误列表
        StringBuilder sOut = new StringBuilder();
        if (throwable != null) {
            StackTraceElement[] trace = throwable.getStackTrace();
            for (StackTraceElement ste : trace) {
                sOut.append("\t\tat ").append(ste).append("\r\n");
            }
        }
        json.put("Error", sOut.toString());
        String logStr = json.toJSONString();
        switch (type) {
            case "info":
            case "auto":
                logger.info(logStr);
                break;
            case "error":
                logger.error(logStr);
                break;
            default:
                logger.info(logStr);
        }
    }
}
