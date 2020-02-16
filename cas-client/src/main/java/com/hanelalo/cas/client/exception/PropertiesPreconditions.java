package com.hanelalo.cas.client.exception;

import com.google.common.base.Strings;
import com.hanelalo.cas.client.config.CasClientProperties;
import com.hanelalo.cas.client.context.CasClientApplicationContext;

public class PropertiesPreconditions {

  public static void checkClientProperties() {
    CasClientProperties properties =
        CasClientApplicationContext.getBean(CasClientProperties.class);
    if(Strings.isNullOrEmpty(properties.getClientId())
        || Strings.isNullOrEmpty(properties.getClientSecret())
        || Strings.isNullOrEmpty(properties.getTokenPath())
        || Strings.isNullOrEmpty(properties.getTokenInfoPath())
        || Strings.isNullOrEmpty(properties.getRefreshTokenPath())){
      throw new CasClientException(CasClientExceptionEnum.SERVER_ERROR);
    }
  }

  public static void checkClientProperties(CasClientProperties properties){
    if(Strings.isNullOrEmpty(properties.getClientId())
        || Strings.isNullOrEmpty(properties.getClientSecret())
        || Strings.isNullOrEmpty(properties.getTokenPath())
        || Strings.isNullOrEmpty(properties.getTokenInfoPath())
        || Strings.isNullOrEmpty(properties.getRefreshTokenPath())){
      throw new CasClientException(CasClientExceptionEnum.NULL_PROPERTY_SET);
    }
  }

}
