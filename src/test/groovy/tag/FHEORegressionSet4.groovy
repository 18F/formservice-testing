package tag

import groovy.transform.InheritConstructors

@InheritConstructors
public class FHEORegressionSet4 extends Closure<Boolean>{
    FHEORegressionSet4() {
        super(null)
    }

    Boolean call(){
        def stage = System.getProperty("stage").toString()
        stage.equalsIgnoreCase("FHEORegressionSet4")
    }
}