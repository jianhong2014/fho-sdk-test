package com.orpak.fho.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * Fho ���ӹ�����ط���
 */
@Service
public class FhoFleetService {
    private static final Logger logger = LoggerFactory.getLogger(FhoFleetService.class);

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    @Autowired
    FhoLoginService fhoLoginService;

    //public void

}
