package tag

import groovy.transform.InheritConstructors

@InheritConstructors
public class FHEORegressionSet5 extends Closure<Boolean>{
    FHEORegressionSet5() {
        super(null)
    }

    Boolean call(){
        def stage = System.getProperty("stage").toString()
        stage.equalsIgnoreCase("FHEORegressionSet5")
    }
}