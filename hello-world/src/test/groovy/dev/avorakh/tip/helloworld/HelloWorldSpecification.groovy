package dev.avorakh.tip.helloworld

import spock.lang.Shared
import spock.lang.Specification

class HelloWorldSpecification extends Specification {

    @Shared
    PrintStream standardOut

    @Shared
    ByteArrayOutputStream outputStreamCaptor

    def setupSpec() {
        standardOut = System.out
        outputStreamCaptor = new ByteArrayOutputStream()
    }

    def setup() {
        System.setOut(new PrintStream(outputStreamCaptor))
    }

    def cleanup() {
        System.setOut(standardOut)
    }

    def cleanupSpec() {
        outputStreamCaptor.close()
    }

    def "should successfully print output"() {
        given:
        def expectedOutput = 'Hello, World!'
        when:
        HelloWorld.main()
        then:
        noExceptionThrown()
        outputStreamCaptor.toString().trim() == expectedOutput
    }
}
