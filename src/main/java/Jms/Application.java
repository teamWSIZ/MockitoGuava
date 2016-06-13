
package Jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.MessageListenerContainer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableJms
@EnableWebMvc
@ImportResource("classpath:extraJms.xml")
public class Application {


    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);       ///Lots of beans defined implicitly


        MessageListenerContainer container = ctx.getBean("jmsContainer1", MessageListenerContainer.class);
        container.stop();

        jmsTemplate.send("box1", session -> session.createTextMessage("ping!"));
        jmsTemplate.send("box1", session -> session.createTextMessage("ping!"));
        jmsTemplate.send("box1", session -> session.createTextMessage("ping!"));
        jmsTemplate.send("box1", session -> session.createTextMessage("ping!"));
        ctx.close();

    }

}
