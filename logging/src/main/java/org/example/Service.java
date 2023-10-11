package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service {

    public static final Logger log = LoggerFactory.getLogger(Service.class);

    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public void save(){
        log.info("service save");
        this.repository.save();
    }
}
