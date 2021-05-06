package tag

import groovy.transform.InheritConstructors

@InheritConstructors
public class FHEORegressionDeviceTest extends Closure<Boolean>{
    FHEORegressionDeviceTest() {
        super(null)
    }

    Boolean call(){
        def stage = System.getProperty("stage").toString()
        stage.equalsIgnoreCase("FHEORegressionDeviceTest")
    }
}