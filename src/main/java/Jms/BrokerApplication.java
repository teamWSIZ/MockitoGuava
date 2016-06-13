package Jms;

import org.apache.activemq.broker.BrokerService;


public class BrokerApplication {
    public static void main(String[] args) throws Exception {
        BrokerService broker = new BrokerService();
        broker.addConnector("tcp://localhost:61610");
        broker.start();
    }
}
