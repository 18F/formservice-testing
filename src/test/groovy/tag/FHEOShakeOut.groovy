package tag

import groovy.transform.InheritConstructors

@InheritConstructors
public class FHEOShakeOut extends Closure<Boolean>{
    FHEOShakeOut() {
        super(null)
    }

    Boolean call(){
        def stage = System.getProperty("stage").toString()
        stage.equalsIgnoreCase("FHEOShakeOut")
    }
}