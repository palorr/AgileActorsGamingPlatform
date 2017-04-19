package com.agile.handlers;

import org.springframework.context.annotation.Configuration;

import java.util.*;

import static com.agile.resources.UriPaths.*;

@Configuration
public class WebAppConfigHandler {

    private Map<String, String> webAppConfigMap;

    public enum WebAppConfigAttributes {
        ADMIN_USERS_URI_PARAM("adminUsersUri"),
        ADMIN_GAMES_URI_PARAM("adminGamesUri"),
        ADMIN_UPDATE_USER_URI_PARAM("adminUpdateUser"),
        ADMIN_DELETE_USER_URI_PARAM("adminDeleteUser"),
        ADMIN_URI_PARAM("adminUri"),
        LOGOUT_URI_PARAM("logoutUri");

        private String str;

        WebAppConfigAttributes(String str) {
            this.str = str;
        }

        public String getParam() {
            return this.str;
        }
    }

    public WebAppConfigHandler() {
        webAppConfigMap = new HashMap();

        webAppConfigMap.put(WebAppConfigAttributes.ADMIN_USERS_URI_PARAM.getParam(),
                ADMIN_USERS_URI);
        webAppConfigMap.put(WebAppConfigAttributes.ADMIN_GAMES_URI_PARAM.getParam(),
                ADMIN_GAMES_URI);
        webAppConfigMap.put(WebAppConfigAttributes.LOGOUT_URI_PARAM.getParam(),
                LOGOUT_URI);
        webAppConfigMap.put(WebAppConfigAttributes.ADMIN_UPDATE_USER_URI_PARAM.getParam(),
                ADMIN_UPDATE_USER_URI);
        webAppConfigMap.put(WebAppConfigAttributes.ADMIN_DELETE_USER_URI_PARAM.getParam(),
                ADMIN_DELETE_USER_URI);
        webAppConfigMap.put(WebAppConfigAttributes.ADMIN_URI_PARAM.getParam(),
                ADMIN_URI);
    }

    public String getWebAppPath(WebAppConfigAttributes attribute) {
        return webAppConfigMap.get(attribute.getParam());
    }

}
