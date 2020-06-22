package com.example.mattApp.dao;

import com.example.mattApp.model.Person;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JenkinsInterface {
    int getJenkins() throws URISyntaxException, IOException;
}
