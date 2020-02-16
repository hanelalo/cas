package com.hanelalo.cas.client.annotation;

public enum ModeEnum {
  OR("OR"), AND("AND"), NOT("NOT");

  private String mode;

  ModeEnum(String mode) {
    this.mode = mode;
  }

  /**
   * Get mode
   **/
  public String getMode() {
    return mode;
  }

  /**
   * @param mode
   * @return this
   **/
  public ModeEnum setMode(String mode) {
    this.mode = mode;
    return this;
  }

  public boolean equals(ModeEnum mode){
    return this.mode.equals(mode.getMode());
  }

}