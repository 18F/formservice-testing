package tag

import groovy.transform.InheritConstructors

@InheritConstructors
public class IRS8821Test extends Closure<Boolean>{
    IRS8821Test() {
        super(null)
    }

    Boolean call(){
        def stage = System.getProperty("stage").toString()
        stage.equalsIgnoreCase("IRS8821Test")
    }
}