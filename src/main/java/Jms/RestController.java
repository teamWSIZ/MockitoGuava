package Jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RestController {

    @Autowired
    ConfigurableApplicationContext ctx;

    @Autowired
    JmsTemplate jmsTemplate;

    @RequestMapping(value = {"/","status"})
    @ResponseBody
    Rest home() {
        return new Rest("OK", "");
    }

    @RequestMapping(value = {"stop"})
    @ResponseBody
    Rest stopApp() {
        ctx.close();
        return new Rest("OK", "");
    }

    @RequestMapping(value = {"send"})
    @ResponseBody
    Rest stopApp(@RequestParam(value = "msg", defaultValue = "n.tesla rulez") String msg) {
        if (msg.equals("xxx")) {
            DefaultMessageListenerContainer cnt1 = (DefaultMessageListenerContainer) ctx.getBean("jmsContainer1");
            cnt1.shutdown();
            DefaultMessageListenerContainer cnt2 = (DefaultMessageListenerContainer)ctx.getBean("jmsContainer2");
            cnt2.shutdown();        //.stop still keeps messages assigned to this container...
        } else if (msg.equals("yyy")) {
            DefaultMessageListenerContainer cnt1 = (DefaultMessageListenerContainer)ctx.getBean("jmsContainer1");
            cnt1.start();
            DefaultMessageListenerContainer cnt2 = (DefaultMessageListenerContainer)ctx.getBean("jmsContainer2");
            cnt2.start();
        }
        jmsTemplate.send("box1", session -> session.createTextMessage(msg));
        return new Rest("OK", "[]");
    }



}
