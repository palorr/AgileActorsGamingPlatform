package com.agile.handlers;

import org.springframework.context.annotation.Configuration;

import java.util.*;

import static com.agile.handlers.UriPaths.*;

@Configuration
public class WebAppConfigHandler {

    private Map<String, String> webAppConfigurationMap;

    public enum WebAppConfigAttributes {
        ADMIN_USERS_URI_PARAM("adminUsersUri"),
        ADMIN_GAMES_URI_PARAM("adminGamesUri");

        private String str;

        WebAppConfigAttributes(String str) {
            this.str = str;
        }

        public String getWebConfigParam() {
            return this.str;
        }
    }

    public WebAppConfigHandler() {
        webAppConfigurationMap = new HashMap();

        webAppConfigurationMap.put(WebAppConfigAttributes.ADMIN_USERS_URI_PARAM.getWebConfigParam(),
                ADMIN_USERS_URI);
        webAppConfigurationMap.put(WebAppConfigAttributes.ADMIN_GAMES_URI_PARAM.getWebConfigParam(),
                ADMIN_GAMES_URI);
    }

    public String getWebAppPath(WebAppConfigAttributes attribute) {
        return webAppConfigurationMap.get(attribute.getWebConfigParam());
    }

}
