package com.apesing.chd;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


@Aspect
@Component
public class MyAspect {
    private final LoggerService logger;

    @Autowired
    public MyAspect(LoggerService logger) {
        this.logger = logger;
    }


    /**
     * 定义切点
     */
    @Pointcut("execution(public * com.apesing.chd.controller..*Controller.*(..))")
    public void controller() {
    }


    /**
     * 围绕切面前后
     *
     * @param joinPoint 切点
     * @return retValue
     */
    @Around("controller()")
    public Object aroundController(ProceedingJoinPoint joinPoint) {
        //定义返回值
        JSONObject returnValue;
        //获取方法信息
        Signature signature = joinPoint.getSignature();
        MethodSignature ms = (MethodSignature) signature;
        Method m = ms.getMethod();
        //获取方法参数列表
        Parameter[] parameters = m.getParameters();
        StringBuilder methodParam = new StringBuilder();
        LocalVariableTableParameterNameDiscoverer lvtpn = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = lvtpn.getParameterNames(m);
        for (int i = 0; i < parameters.length; i++) {
            Parameter temp = parameters[i];
            methodParam.append(", ").append(temp.getType().getSimpleName()).append(" ").append(paramNames[i]);
        }
        //获取传入参数
        Object[] objects = joinPoint.getArgs();
        StringBuilder paramValue = new StringBuilder();
        for (Object str : objects) {
            paramValue.append(", ").append(str);
        }


        String actionName = m.getName();
        String actionParam = ("".equals(methodParam.toString()) ? "" : methodParam.substring(2));
        String inputParam = ("".equals(paramValue.toString()) ? "" : paramValue.substring(2));
        try {
            //执行切点方法
            returnValue = (JSONObject) joinPoint.proceed(objects);
            logger.autoInfo(actionName, actionParam, inputParam, returnValue, null, this.getClass());
        } catch (Throwable throwable) {
            returnValue = new JSONObject();
            returnValue.put("code", "9999");
            throwable.printStackTrace();
            returnValue.put("error", throwable.getCause().getMessage());
            logger.error(actionName, actionParam, inputParam, returnValue, throwable, null, this.getClass());
        }
        returnValue.put("msg", sysCodeMsg(returnValue.getString("code")));
        return returnValue;
    }


    private static String sysCodeMsg(String code) {
        String msg;
        switch (code) {
            case "0000":
                msg = "请求成功";
                break;
            case "9001":
                msg="用户名已存在";
                break;
            case "9002":
                msg="该邮箱已被注册";
                break;
            case "9100":
                msg="邮箱密令错误";
                break;
            case "9998":
                msg = "请完整填写";
                break;
            case "9999":
                msg = "系统错误请联系管理员";
                break;
            default:
                msg = "发现未定义的错误:" + code;
                break;
        }
        return msg;
    }
}
