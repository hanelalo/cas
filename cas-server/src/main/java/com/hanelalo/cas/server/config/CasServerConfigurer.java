package com.hanelalo.cas.server.config;

import com.hanelalo.cas.server.service.CasHandlerRegistry;

public interface CasServerConfigurer {

  void addHandler(CasHandlerRegistry registry);


}
