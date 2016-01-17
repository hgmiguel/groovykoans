package org.qualitykoans.koan14

class TemporaryVariables {
  
  int quantity
  int itemPrice

  TemporaryVariables(int quantity, int itemPrice) {
    this.quantity = quantity
    this.itemPrice = itemPrice
  }
  
  double calculatePrice() {
    int basePrice = quantity * itemPrice;
    double discountFactor;
    if (basePrice > 1000) discountFactor = 0.95;
    else discountFactor = 0.98;
    return basePrice * discountFactor;
  }

}
