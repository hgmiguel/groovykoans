package org.qualitykoans.koan14

class LocalVariables {
  
  Orders _orders = new Orders()
  String _name = 'name'

  public void printOwing() {
    List e = _orders.elements();
    double outstanding = 0.0;
    printBanner();
    // calculate outstanding
    e.each { Order each ->
      outstanding += each.getAmount();
    }

    printDetails(outstanding);
  }

  public void printBanner() {
    System.out.println ("**************************");
    System.out.println ("***** Customer Owes ******");
    System.out.println ("**************************");
  }

  public void printDetails(double outstanding) {
    System.out.println ("name:" + _name);
    System.out.println ("amount:" + outstanding);
  }

}

