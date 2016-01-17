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

}
