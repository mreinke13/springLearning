package com.example.mattApp.service;

import com.example.mattApp.dao.JenkinsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class jenkinsService {
    private final JenkinsInterface jenkins;

    @Autowired
    public jenkinsService(@Qualifier("jenkinsDao")JenkinsInterface jenkins) {
        this.jenkins = jenkins;
    }

    public int logJobs() throws IOException, URISyntaxException {
        return jenkins.getJenkins();
    }
}
