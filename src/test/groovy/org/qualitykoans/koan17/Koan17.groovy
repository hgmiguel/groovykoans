package org.qualitykoans.koan17

import org.qualitykoans.common.test.suite.QualityKoanMetrics

class Koan17 extends QualityKoanMetrics {

    void test01_SplitTemporaryFields() {
        SplitTemporaryVariable splitTemporaryVariable = new SplitTemporaryVariable()
        assert splitTemporaryVariable.getSize(10,10) == 100

        assert metricTotal('getSize', 'CyclomaticComplexity') <= 1
        assert metricTotal('getSize', 'MethodLineCount') >= 8
    }
}
