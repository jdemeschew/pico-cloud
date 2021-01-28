package de.tinysite.pico.cloud.delegates;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;



public class ConfigureInstanceDelegate implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Configuring instance");
    }
}
