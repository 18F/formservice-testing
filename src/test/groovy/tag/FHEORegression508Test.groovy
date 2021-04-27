package tag

import groovy.transform.InheritConstructors

@InheritConstructors
public class FHEORegression508Test extends Closure<Boolean>{
    FHEORegression508Test() {
        super(null)
    }

    Boolean call(){
        def stage = System.getProperty("stage").toString()
        stage.equalsIgnoreCase("FHEORegression508Test")
    }
}