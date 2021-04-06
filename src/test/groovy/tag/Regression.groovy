package tag

import groovy.transform.InheritConstructors


@InheritConstructors
public class Regression extends Closure<Boolean>{
    Regression() {
        super(null)
    }

    Boolean call(){
        def stage = System.getProperty("stage").toString()
        stage.equalsIgnoreCase("regression")
    }
}