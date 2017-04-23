package com.agile.resources;

public class UriPaths {

    /* Dashboard List Uris */
    public static final String ADMIN_URI = "/admin/";
    public static final String ADMIN_USERS_URI = "/admin/users/";
    public static final String ADMIN_GAMES_URI = "/admin/games/";

    /* Admin User Panel Uris */
    public static final String REDIRECT_ADMIN_USERS_URI = "redirect:/admin/users/";
    public static final String ADMIN_USERS_ID_URI = "/admin/users/{id}";
    public static final String ADMIN_DELETE_USER_ID_URI = "/admin/delete_user/{id}";
    public static final String ADMIN_UPDATE_USER_ID_URI = "/admin/update_user/{id}";
    public static final String ADMIN_CREATE_USER_URI = "/admin/create_user";
    public static final String ADMIN_UPDATE_USER_URI = "/admin/update_user/";
    public static final String ADMIN_DELETE_USER_URI = "/admin/delete_user/";

    /* Admin Game Panel Uris */
    public static final String REDIRECT_ADMIN_GAMES_URI = "redirect:/admin/games/";
    public static final String ADMIN_GAMES_ID_URI = "/admin/games/{id}";
    public static final String ADMIN_DELETE_GAME_ID_URI = "/admin/delete_game/{id}";
    public static final String ADMIN_UPDATE_GAME_ID_URI = "/admin/update_game/{id}";
    public static final String ADMIN_CREATE_GAME_URI = "/admin/create_game";
    public static final String ADMIN_UPDATE_GAME_URI = "/admin/update_game/";
    public static final String ADMIN_DELETE_GAME_URI = "/admin/delete_game/";

    /* General uris */
    public static final String LOGIN_URI = "/login";
    public static final String HOME_ONE_URI ="/";
    public static final String HOME_TWO_URI ="/home";
    public static final String LOGOUT_URI = "/logout";
}
