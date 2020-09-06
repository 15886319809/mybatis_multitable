package com.lagou.plug;

import net.sf.jsqlparser.util.deparser.StatementDeParser;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.lang.annotation.Annotation;
import java.sql.Connection;
import java.util.Properties;

@Intercepts({
        @Signature(type = StatementHandler.class,method = "prepare",
                args = {Connection.class,Integer.class})
})
public class MyPluging implements Interceptor {
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("执行方法增强");
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        Object wrap = Plugin.wrap(target, this);
        return wrap;
    }

    public void setProperties(Properties properties) {
        System.out.println("参数为："+properties);
    }
}
