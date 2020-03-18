package com.hanelalo.cas.server.service;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CasHandlerRegistry {

  private List<PreHandler> preHandlers = Lists.newArrayList();
  private List<PostHandler> postHandlers = Lists.newArrayList();

  public void addPreHandler(PreHandler preHandler){
    preHandlers.add(preHandler);
  }

  public void addPostHandler(PostHandler postHandler){
    postHandlers.add(postHandler);
  }

  public void preExecute(){
    preHandlers.forEach(PreHandler::preHandle);
  }

  public void postExecute(){
    postHandlers.forEach(PostHandler::postHandle);
  }

}
