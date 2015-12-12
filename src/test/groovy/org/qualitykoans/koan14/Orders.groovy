package org.qualitykoans.koan14

class Orders {
  private final List orders = [new Order(amount:10.00),
    new Order(amount:20.00),
    new Order(amount:30.00)]
  
  public List elements() {
    orders
  }
}
