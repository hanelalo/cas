package com.hanelalo.cas.server.client;

import java.util.List;

/**
 * 客户端信息服务接口
 */
public interface ClientDetailService<T extends ClientDetails> {
  T getClientDetails(String clientId, String clientSecret);
  void addClient(T details);
  List<T> getAllClientDetails();
}
