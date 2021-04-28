package tag

import groovy.transform.InheritConstructors

@InheritConstructors
public class FHEORegressionSet2 extends Closure<Boolean>{
    FHEORegressionSet2() {
        super(null)
    }

    Boolean call(){
        def stage = System.getProperty("stage").toString()
        stage.equalsIgnoreCase("FHEORegressionSet2")
    }
}