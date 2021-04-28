package tag

import groovy.transform.InheritConstructors

@InheritConstructors
public class FHEORegressionErrSpec extends Closure<Boolean>{
    FHEORegressionErrSpec() {
        super(null)
    }

    Boolean call(){
        def stage = System.getProperty("stage").toString()
        stage.equalsIgnoreCase("FHEORegressionErrSpec")
    }
}