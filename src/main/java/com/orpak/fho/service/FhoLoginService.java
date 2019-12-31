package com.orpak.fho.service;

import com.alibaba.fastjson.JSON;
import com.gvr.datahub.sdk.orpak.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

;

/**
 * Fho 登录登出服务
 */
@Service
public class FhoLoginService {

    private static final Logger logger = LoggerFactory.getLogger(FhoLoginService.class);

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    private String sessionId;

    public String getSessionId() {
        return sessionId;
    }

    /**
     * @param user
     * @param passwd
     * @param roCode 油站id
     * @return
     */
    public String login(String user, String passwd, String roCode) {
        SOLogin loginRequest = new SOLogin();
        loginRequest.setROCode(roCode);
        loginRequest.setPassword(passwd);
        loginRequest.setUser(user);
        return login(loginRequest);
    }

    /**
     * @param user
     * @param passwd
     * @return
     */
    public String login(String user, String passwd) {
        return login(user, passwd, "0");
    }

    /**
     * 登录FHO,返回sessionID放在内存容器中，留着后续调用别的请求用
     *
     * @param request
     * @return
     */
    public String login(SOLogin request) {
        logger.info("Query login for " + JSON.toJSON(request));
        SOLoginResponse response = (SOLoginResponse) webServiceTemplate.marshalSendAndReceive(request);
        LoginRespond loginRespond = response.getSOLoginResult();
        if (loginRespond != null && loginRespond.getRc() == 0) {
            sessionId = loginRespond.getSessionID();
            logger.info("login succesfull {}", sessionId);
            return sessionId;
        }
        logger.info(" login fail " + JSON.toJSON(response));
        return "";
    }

    public void logout() {
        logger.info("log out for {}", sessionId);
        SOLogout request = new SOLogout();
        request.setSessionID(sessionId);
        SOLogoutResponse response = (SOLogoutResponse) webServiceTemplate.marshalSendAndReceive(request);
        logger.info("log out result {}", JSON.toJSON(response));
    }

    public void getStationList(String type){
        HOGetStationList  stationList = new HOGetStationList();
        stationList.setSessionID(sessionId);
        stationList.setStationSubType(0);
        logger.info("getStationList {}",JSON.toJSON(stationList));
        HOGetStationListResponse response = (HOGetStationListResponse) webServiceTemplate.
                marshalSendAndReceive(stationList);
        logger.info("log out result {}", JSON.toJSON(response));
    }
}
