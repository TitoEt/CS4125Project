package com.castletroymedical.billing;

public class Procedure extends InvoiceDecorator {
  private static double charge = 40; // TODO
  private String name;
  
  public Procedure(String name, Invoice invoice){
    super(invoice, invoice.strategy);
    this.name = name;
  }

  public double getCharge(){
    return super.getCharge() + this.strategy.calculateProcedureCost(charge);
  }

  private static double getProcedureCharge(){
    // db query
    return 0.0;
  }

  public String getName() {
    return name;
  }
}