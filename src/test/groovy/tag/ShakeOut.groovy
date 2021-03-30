package tag

import groovy.transform.InheritConstructors

@InheritConstructors
public class ShakeOut extends Closure<Boolean>{
    ShakeOut() {
        super(null)
    }

    Boolean call(){
        def stage = System.getProperty("stage").toString()
        stage.equalsIgnoreCase("shakeout")
    }
}