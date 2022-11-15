package com.castletroymedical.billing;

public class Procedure extends InvoiceDecorator {
  private static double charge = 40; // TODO retrive from db
  private String name;
  
  public Procedure(String name, Invoice invoice){
    super(invoice, invoice.state);
    this.name = name;
  }

  public double getCharge(){
    return super.getCharge() + this.state.calculateProcedureCost(charge);
  }

  private static double getProcedureCharge(){
    // db query
    return 0.0;
  }

  public String getName() {
    return name;
  }
}