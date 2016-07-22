package org.qualitykoans.common.test.suite

import groovy.util.XmlSlurper

class QualityKoanMetrics extends GroovyTestCase {
   def xml = new XmlSlurper().parseText(this.getClass().getResource('/gmetrics/gmetrics.xml').getText())

   protected int metricTotal(String methodName, String metric) {
     xml.Package.Class.Method.find {it.'@name' == methodName}.MetricResult.find {it.'@name' == metric}.'@total'.toInteger()
   }
}
