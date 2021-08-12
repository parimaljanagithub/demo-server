package com.example.demoserver.storage;

import com.example.demoserver.model.User;

import java.util.HashMap;
import java.util.Map;

public class StoreInformation {
    public static Map<String, User> userInfo = new HashMap<String, User>();

    public static void addUserInfo(User user) {
        userInfo.put(user.getLoginId(),user);
    }

}
