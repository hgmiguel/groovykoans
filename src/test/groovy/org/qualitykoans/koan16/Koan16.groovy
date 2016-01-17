package org.qualitykoans.koan16

import org.qualitykoans.common.test.suite.QualityKoanMetrics

class Koan16 extends QualityKoanMetrics {

    void test01_ExtractComplicatedValidationWithMethod() {
        ExplainVariable explainVariable = new ExplainVariable(platform: 'MAC',
                browser: 'SAFARI', resize:10)
        assert explainVariable.isComplicatedValidation()
        explainVariable.browser = 'IE'
        assert explainVariable.isComplicatedValidation() == false

        assert metricTotal('isComplicatedValidation', 'CyclomaticComplexity') <= 5
        assert metricTotal('isComplicatedValidation', 'MethodLineCount') == 8
    }

    void test02_ExtractComplicatedValidationWithMethod2() {
        ExplainVariable2 explainVariable = new ExplainVariable2(quantity: 100,
                itemPrice: 100)
        assert explainVariable.calculatePriceWithDiscountAndShipping() == 10100

        explainVariable.quantity = 10000
        explainVariable.itemPrice = 100

        assert explainVariable.calculatePriceWithDiscountAndShipping() == 952600

        assert metricTotal('calculatePriceWithDiscountAndShipping', 'CyclomaticComplexity') == 1
        assert metricTotal('calculatePriceWithDiscountAndShipping', 'MethodLineCount') == 4
    }
}
