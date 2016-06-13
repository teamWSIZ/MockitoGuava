package Jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    ConfigurableApplicationContext context;

    @JmsListener(destination = "box1")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }


}
