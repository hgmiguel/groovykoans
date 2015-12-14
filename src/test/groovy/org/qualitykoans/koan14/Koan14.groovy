package org.qualitykoans.koan14

import groovy.util.XmlSlurper
import java.io.ByteArrayOutputStream

class Koan14 extends GroovyTestCase {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final localVariables = new LocalVariables()
    private final String assertString = '************************** ***** Customer Owes ****** ************************** name:name amount:60.0 '


    def xml

    void setUp() {
      System.setOut(new PrintStream(outContent));

      xml = new XmlSlurper().parseText(this.getClass().getResource('/gmetrics/gmetrics.xml').getText()) 
    }

    private metricTotal(String methodName, String metric) {
      xml.Package.Class.Method.find {it.'@name' == methodName}.MetricResult.find {it.'@name' == metric}.'@total'.toInteger()
    }

    void test01_ExtractMethodQuality() {
      localVariables.printOwing()
      assert outContent.toString().replace("\n"," ") == assertString
      assert metricTotal('printOwing', 'MethodLineCount') == 4
    }
}

