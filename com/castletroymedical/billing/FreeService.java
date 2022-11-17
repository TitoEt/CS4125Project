package com.castletroymedical.billing;

public class FreeService extends PercentageModifier {
  public FreeService() {
    super(0);
  }

  public double getModifier() {
    return modifier;
  }
}