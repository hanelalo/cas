package com.hanelalo.cas.server;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class ShaTest {

  public static void main(String[] args){
    HashFunction sha = Hashing.sha256();
    System.out.println(sha.hashBytes("client_secret".getBytes()).toString());
  }

}
