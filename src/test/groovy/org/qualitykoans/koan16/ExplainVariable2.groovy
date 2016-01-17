package org.qualitykoans.koan16

class ExplainVariable2 {
    int quantity
    int itemPrice

    double calculatePriceWithDiscountAndShipping() {
        // price is base price - quantity discount + shipping
        return quantity * itemPrice -
                Math.max(0, quantity - 500) * itemPrice * 0.05 +
                Math.min(quantity * itemPrice * 0.1, 100.0);
    }
}
