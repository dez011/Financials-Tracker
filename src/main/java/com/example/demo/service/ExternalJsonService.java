package com.example.demo.service;

import com.example.demo.entity.AbstractExternalUserTransaction;
import com.example.demo.entity.ExternalUserTransaction;

public interface ExternalJsonService {
    void processExternalParsedJson(ExternalUserTransaction externalJsonTransaction);

}
