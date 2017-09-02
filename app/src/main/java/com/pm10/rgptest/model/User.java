package com.pm10.rgptest.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject {
    public static String PRIMARY_KEY = "id";
    public static String ORDER_KEY = "login";

    @PrimaryKey
    public int id;
    public String login;
    public String avatar_url;
    public String url;
    public String html_url;
    public String followers_url;
    public String following_url;
    public String gists_url;
    public String starred_url;
    public String subscriptions_url;
    public String organizations_url;
    public String repos_url;
    public String events_url;
    public String received_events_url;
    public String type;
    public boolean site_admin;

    public boolean liked;
}
