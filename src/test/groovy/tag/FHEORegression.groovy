package tag

import groovy.transform.InheritConstructors

@InheritConstructors
public class FHEORegression extends Closure<Boolean>{
    FHEORegression() {
        super(null)
    }

    Boolean call(){
        def stage = System.getProperty("stage").toString()
        stage.equalsIgnoreCase("FHEORegression")
    }
}