package org.qualitykoans.koan01

import groovy.util.XmlSlurper
import java.io.ByteArrayOutputStream

class Koan14 extends GroovyTestCase {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    def xml

    void setUp() {
      System.setOut(new PrintStream(outContent));

      xml = new XmlSlurper().parseText(this.getClass().getResource('/gmetrics/gmetrics.xml').getText()) 
    }

    private metricTotal(String methodName, String metric) {
      xml.Package.Class.Method.find {it.'@name' == methodName}.MetricResult.find {it.'@name' == metric}.'@total'.toInteger()
    }

    void test01_ExtractMethodQuality() {
       printOwing()
      assert outContent.toString().replace("\n"," ") == 'hola name: name amount 2.0 '
      assert metricTotal('printOwing', 'MethodLineCount') == 4
    }


    void printOwing() {
      printBanner();

      //print details
      System.out.println ("name: " + _name);
      System.out.println ("amount " + getOutstanding());
    }

    private void printBanner() {
      System.out.println ("hola")
    }
    private double getOutstanding() {2L}
    private final _name = 'name'

    public void cleanUp() {
        System.setOut(null);
        System.setErr(null);
    }
}

