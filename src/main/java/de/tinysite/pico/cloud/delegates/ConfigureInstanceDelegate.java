package de.tinysite.pico.cloud.delegates;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Component;



public class ConfigureInstanceDelegate implements JavaDelegate {


    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("Configuring instance");
    }
}
