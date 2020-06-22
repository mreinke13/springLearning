package com.example.mattApp.dao;

import com.offbytwo.jenkins.JenkinsServer;
import com.offbytwo.jenkins.model.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Repository("jenkinsDao")

public class jenkinsDAOService implements JenkinsInterface {
    Logger logger = LoggerFactory.getLogger(jenkinsDAOService.class);
    @Override
    public int getJenkins() throws URISyntaxException, IOException {
        JenkinsServer jenkins = new JenkinsServer(new URI("http://localhost:8080/jenkins"), "admin", "password");
        Map<String, Job> jobs = jenkins.getJobs();
       jobs.keySet().stream()
               .forEach(System.out::println);
        return 0;
    }
}
