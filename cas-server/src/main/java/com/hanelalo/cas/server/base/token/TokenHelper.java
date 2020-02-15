package com.hanelalo.cas.server.base.token;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanelalo.cas.server.base.exception.CasServerException;
import com.hanelalo.cas.server.base.exception.CasServerExceptionEnum;
import com.hanelalo.cas.server.config.AuthServerProperties;
import java.io.IOException;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.codec.Codecs;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

@Component
public class TokenHelper {

  private String publicKey;
  private String privateKey;
  private RsaSigner signer;
  private RsaVerifier verifier;

  @Autowired
  private AuthServerProperties properties;

  @PostConstruct
  public void initKeyPair() {
    initPublicKey();
    initPrivateKey();
    signer = new RsaSigner(privateKey);
    verifier = new RsaVerifier(publicKey);
  }

  public byte[] enSign(String data) {
    byte[] content = Codecs.utf8Encode(data);
    return signer.sign(content);
  }

  public String encode(Payload payload) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    String value = mapper.writeValueAsString(payload);
    Jwt jwt = JwtHelper.encode(value, signer);
    return jwt.getEncoded();
  }

  public String encode(Payload payload, Map<String, String> headers) {
    ObjectMapper mapper = new ObjectMapper();
    String value = null;
    try {
      value = mapper.writeValueAsString(payload);
    } catch (JsonProcessingException e) {
      throw new CasServerException(CasServerExceptionEnum.USER_INVALID.getErrorCode(),
          CasServerExceptionEnum.USER_INVALID.getErrorMsg());
    }
    Jwt jwt = JwtHelper.encode(value, signer, headers);
    return jwt.getEncoded();
  }

  public Payload decode(String token) {
    ObjectMapper mapper = new ObjectMapper();
    Jwt jwt = JwtHelper.decodeAndVerify(token, verifier);
    try {
      return mapper.readValue(jwt.getClaims(), Payload.class);
    } catch (JsonProcessingException e) {
      throw new CasServerException(CasServerExceptionEnum.TOKEN_INVALID.getErrorCode(),
          CasServerExceptionEnum.TOKEN_INVALID.getErrorMsg());
    }
  }

  private void initPrivateKey() {
    try {
      Resource resource = new ClassPathResource(properties.getPrivateKeyResourcePath());
      privateKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void initPublicKey() {
    try {
      Resource resource = new ClassPathResource(properties.getPublicKeyResourcePath());
      publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
