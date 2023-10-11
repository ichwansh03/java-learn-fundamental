package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Repository {

    public static final Logger log = LoggerFactory.getLogger(Repository.class);

    public void save(){
        log.info("repo save");
    }
}
