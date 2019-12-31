package com.orpak.test;


import com.gvr.datahub.sdk.orpak.SOLogin;
import com.orpak.fho.FhoSdkTestApplication;

import com.orpak.fho.config.FhoDataConfig;
import com.orpak.fho.service.FhoLoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest(classes = FhoSdkTestApplication.class)
@RunWith(SpringRunner.class)
public class TestFhoSdk {

    private Logger logger = LoggerFactory.getLogger(TestFhoSdk.class);

    @Autowired
    private FhoDataConfig fhoDataConfig;

    @Autowired
    private FhoLoginService fhoLoginService;


    @Test
    public void testFhoLogin(){
        fhoDataConfig.setFhoIp("10.28.188.35");
        SOLogin soLogin = new SOLogin();
        soLogin.setUser("Admin");
        soLogin.setPassword("Gvrorpak20!9");
        soLogin.setROCode("0");
        fhoLoginService.login(soLogin);

        fhoLoginService.getStationList("0");
    }

    @Test
    public void logout(){
        logger.info("log out ");
        fhoLoginService.logout();
    }
}
