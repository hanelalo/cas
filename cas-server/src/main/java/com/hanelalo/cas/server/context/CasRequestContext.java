package com.hanelalo.cas.server.context;

import com.alibaba.ttl.TransmittableThreadLocal;
import java.util.HashMap;
import java.util.Map;

public class CasRequestContext {

  private static final TransmittableThreadLocal<Map<Class<?>, Object>> MAP_IN_THREAD_LOCAL
      = new TransmittableThreadLocal<>();


  public static <T> T get(Class<T> clazz) {
    return (T) MAP_IN_THREAD_LOCAL.get().get(clazz);
  }

  public static <T> void setLocalThreadValue(T t) {
    if (MAP_IN_THREAD_LOCAL.get() == null) {
      Map<Class<?>, Object> map = new HashMap<>();
      MAP_IN_THREAD_LOCAL.set(map);
    }
    MAP_IN_THREAD_LOCAL.get().put(t.getClass(), t);
  }

  public static void clean() {
    MAP_IN_THREAD_LOCAL.get().clear();
    MAP_IN_THREAD_LOCAL.remove();
  }

}
