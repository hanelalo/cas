package com.hanelalo.cas.server.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class CasApplicationContext implements ApplicationContextAware {

  private static ApplicationContext context;

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    if(context == null){
      context = applicationContext;
    }
  }

  public static <T> T getBean(Class<T> clazz){
    return context.getBean(clazz);
  }

}
