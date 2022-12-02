package com.castletroymedical.billing.invoice;

public class Procedure extends InvoiceDecorator {
  private String procedureName;
  private double baseCharge;
  
  public Procedure(String procedureName, double baseCharge, Invoice invoice){
    super(invoice, invoice.state);
    this.procedureName = procedureName;
    this.baseCharge = baseCharge;
  }

  @Override
  public double getCharge(){
    return super.getCharge() + this.state.calculateProcedureCost(baseCharge);
  }

  public String getProcedureName(){
    return this.procedureName;
  }
}