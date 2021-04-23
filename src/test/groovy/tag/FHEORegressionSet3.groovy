package tag

import groovy.transform.InheritConstructors

@InheritConstructors
public class FHEORegressionSet3 extends Closure<Boolean>{
    FHEORegressionSet3() {
        super(null)
    }

    Boolean call(){
        def stage = System.getProperty("stage").toString()
        stage.equalsIgnoreCase("FHEORegressionSet3")
    }
}