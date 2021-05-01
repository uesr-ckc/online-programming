package com.onlineProgramming.Utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author CKC
 * @DateTime 2021/4/24 12:59
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {
    private static ApplicationContext context;
    
    /**
     * 根据bean的名字获取工厂中指定bean的对象
     *
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
