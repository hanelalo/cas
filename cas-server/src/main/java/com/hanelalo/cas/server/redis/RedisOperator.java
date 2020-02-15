package com.hanelalo.cas.server.redis;

import com.google.common.collect.Lists;
import com.hanelalo.cas.server.client.ClientDetailService;
import com.hanelalo.cas.server.client.ClientDetails;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.jwt.codec.Codecs;
import org.springframework.stereotype.Component;

@Component
public class RedisOperator {

  @Autowired
  private RedisTemplate redisTemplate;

  @Autowired
  private ClientDetailService<ClientDetails> clientDetailService;

  private static final String CLIENT_DETAILS_KEY = "Q0xJRU5UX0RFVEFJTFM=";

  public ClientDetails getClientDetails(String authorization){
    HashOperations<String,String,ClientDetails> opsForHash = redisTemplate.opsForHash();
    ClientDetails details = opsForHash.get(CLIENT_DETAILS_KEY, authorization);
    return details;
  }

  @PostConstruct
  public void loadClientDetails() {
    HashOperations<String,String,ClientDetails> opsForHash = redisTemplate.opsForHash();
    List<ClientDetails> details = clientDetailService.getAllClientDetails();
    opsForHash.putAll(CLIENT_DETAILS_KEY,buildDetailsMap(details));
  }

  private Map<String, ClientDetails> buildDetailsMap(List<ClientDetails> details) {
    Map<String, ClientDetails> map = new HashMap<>();
    details.forEach(clientDetails -> {
      byte[] key = (clientDetails.getClientId() + ":" + clientDetails.getClientSecret()).getBytes();
      String authorization = new String(Codecs.b64Encode(key));
      map.put(authorization, clientDetails);
    });
    return map;
  }

}
