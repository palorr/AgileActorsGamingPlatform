package com.agile.handlers;

import org.springframework.context.annotation.Configuration;

import java.util.*;

import static com.agile.handlers.UriPaths.ADMIN_GAMES_PATH;
import static com.agile.handlers.UriPaths.ADMIN_USERS_PATH;

@Configuration
public class WebAppConfigHandler {

    private Map<String, String> webAppConfigurationMap;

    public enum WebAppConfigAttributes {
        ADMIN_USERS_URI("adminUsersUri"),
        ADMIN_GAMES_URI("adminGamesUri");

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

        webAppConfigurationMap.put(WebAppConfigAttributes.ADMIN_USERS_URI.getWebConfigParam(),
                ADMIN_USERS_PATH);
        webAppConfigurationMap.put(WebAppConfigAttributes.ADMIN_GAMES_URI.getWebConfigParam(),
                ADMIN_GAMES_PATH);
    }

    public String getWebAppPath(WebAppConfigAttributes attribute) {
        return webAppConfigurationMap.get(attribute.getWebConfigParam());
    }

}
