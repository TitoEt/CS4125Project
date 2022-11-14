package com.castletroymedical.billing;

public class Procedure extends InvoiceDecorator {
  private static double charge;
  private String name;
  
  public Procedure(String name, Invoice invoice){
    super(invoice, getProcedureCharge());
    this.name = name;
  }

  public double getCharge(){
    return super.getCharge();// + (charge * getProcedureModifier());
  }

  private static double getProcedureCharge(){
    // db query
    return 0.0;
  }

  public String getName() {
    return name;
  }
}