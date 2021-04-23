package tag

import groovy.transform.InheritConstructors

@InheritConstructors
public class FHEORegressionSet1 extends Closure<Boolean>{
    FHEORegressionSet1() {
        super(null)
    }

    Boolean call(){
        def stage = System.getProperty("stage").toString()
        stage.equalsIgnoreCase("FHEORegressionSet1")
    }
}