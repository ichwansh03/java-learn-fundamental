package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controller {

    public static final Logger log = LoggerFactory.getLogger(Controller.class);

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void save(){
        log.info("controller save");
        this.service.save();
    }
}
