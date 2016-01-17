package org.qualitykoans.koan14

class ExplainVariable {

  String platform
  String browser
  int resize

  boolean isComplicatedValidation() {
    if ( (platform.toUpperCase().indexOf("MAC") > -1) &&
        (browser.toUpperCase().indexOf("SAFARI") > -1) &&
        wasInitialized() && resize > 0 ) {
      return true
    }
    
    false
  }

  boolean wasInitialized() {
    true
  }


  /*
  *
  *   Second example
  */
  
  int quantity
  int itemPrice

  double calculatePriceWithDiscountAndShipping() {
    // price is base price - quantity discount + shipping
    return quantity * itemPrice -
      Math.max(0, quantity - 500) * itemPrice * 0.05 +
      Math.min(quantity * itemPrice * 0.1, 100.0);
  }


}
