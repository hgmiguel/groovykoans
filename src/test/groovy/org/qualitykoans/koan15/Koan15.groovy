package org.qualitykoans.koan14

import org.qualitykoans.common.test.suite.QualityKoanMetrics
import org.qualitykoans.koan15.TemporaryVariables

class Koan15 extends QualityKoanMetrics {
    TemporaryVariables temporaryVariables = new TemporaryVariables(10,100)

    void test01_ExtractTemporaryVariablesWithMethod() {
        assert temporaryVariables.calculatePrice() == 980

        temporaryVariables.quantity = 20
        temporaryVariables.itemPrice = 100
        assert temporaryVariables.calculatePrice() == 1900

        assert metricTotal('calculatePrice', 'CyclomaticComplexity') <= 2
        assert metricTotal('calculatePrice', 'MethodLineCount') <= 6
    }
}