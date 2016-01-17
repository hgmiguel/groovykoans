package org.qualitykoans.koan14

import org.qualitykoans.common.test.suite.QualityKoanMetrics

class Koan14 extends QualityKoanMetrics {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final localVariables = new LocalVariables()
    private final String assertString = '************************** ***** Customer Owes ****** ************************** name:name amount:60.0 '
    private final String assertStringPreviousAmount = '************************** ***** Customer Owes ****** ************************** name:name amount:72.0 '


    void setUp() {
      System.setOut(new PrintStream(outContent));
    }

    void test01_ExtractMethodQuality() {
      localVariables.printOwing()
      assert outContent.toString().replace("\n"," ") == assertString
      assert metricTotal('printOwing', 'MethodLineCount') == 4
      assert metricTotal('printOwing', 'CyclomaticComplexity') == 1
    }
    
    void test02_ExtractMethodWithTemporaryVariable() {
      localVariables.printOwingPreviousAmount(10.0d)
      assert outContent.toString().replace("\n"," ") == assertStringPreviousAmount
      assert metricTotal('printOwingPreviousAmount', 'MethodLineCount') == 4
      assert metricTotal('printOwingPreviousAmount', 'CyclomaticComplexity') == 1
    }



    void test04_ExtractComplicatedValidationWithMethod() {
      ExplainVariable explainVariable = new ExplainVariable(platform: 'MAC',
        browser: 'SAFARI', resize:10)
      assert explainVariable.isComplicatedValidation()
      explainVariable.browser = 'IE'
      assert explainVariable.isComplicatedValidation() == false

      assert metricTotal('isComplicatedValidation', 'CyclomaticComplexity') <= 5
      assert metricTotal('isComplicatedValidation', 'MethodLineCount') == 8
    }
    
    void test05_ExtractComplicatedValidationWithMethod2() {
      ExplainVariable explainVariable = new ExplainVariable(quantity: 100,
        itemPrice: 100)
      assert explainVariable.calculatePriceWithDiscountAndShipping() == 10100

      explainVariable.quantity = 10000
      explainVariable.itemPrice = 100

      assert explainVariable.calculatePriceWithDiscountAndShipping() == 952600

      assert metricTotal('calculatePriceWithDiscountAndShipping', 'CyclomaticComplexity') == 1
      assert metricTotal('calculatePriceWithDiscountAndShipping', 'MethodLineCount') == 4
    }

    void test06_SplitTemporaryFields() {
      SplitTemporaryVariable splitTemporaryVariable = new SplitTemporaryVariable()
      assert splitTemporaryVariable.getSize(10,10) == 100

      assert metricTotal('getSize', 'CyclomaticComplexity') == 1
      assert metricTotal('getSize', 'MethodLineCount') >= 8
    }

}

