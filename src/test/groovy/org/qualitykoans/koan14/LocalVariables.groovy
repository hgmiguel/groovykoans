package org.qualitykoans.koan14

class LocalVariables {
  
  Orders _orders = new Orders()
  String _name = 'name'

  public void printOwing() {
    List e = _orders.elements();
    double outstanding = 0.0;
    // print banner
    System.out.println ("**************************");
    System.out.println ("***** Customer Owes ******");
    System.out.println ("**************************");
    // calculate outstanding
    e.each { Order each ->
      outstanding += each.getAmount();
    }
    //print details
    System.out.println ("name:" + _name);
    System.out.println ("amount:" + outstanding);
  }

}

