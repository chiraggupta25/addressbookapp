package com.pd.addressbookapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pd.addressbookapp.model.ApiResponse;
import com.pd.addressbookapp.model.ContactMethod;
import com.pd.addressbookapp.model.User;
import com.pd.addressbookapp.util.HttpClientUtil;
import com.pd.addressbookapp.util.JsonUtil;

public class UserService {
    private final ObjectMapper mapper = JsonUtil.create();

    public ApiResponse fetchUsers(String url, String token, String query, boolean userCount, int pageSize, int pageIndex) throws Exception {
        String json = HttpClientUtil.get(url, token, query, userCount, pageSize, pageIndex);
        return mapper.readValue(json, ApiResponse.class);
    }

    public void enrichUserContactMethods(User user, String token) {
        if (user.getContact_methods() == null) return;

        for (int i = 0; i < user.getContact_methods().size(); i++) {
            ContactMethod cm = user.getContact_methods().get(i);
            try {
                String json = HttpClientUtil.get(cm.getSelf(), token, null, false, 0, 0);
                ContactMethod full = mapper.readValue(json, ContactMethod.class);
                user.getContact_methods().set(i, full);
            } catch (Exception e) {
                System.err.printf("Failed to fetch contact method: %s (%s)%n", cm.getType(), e.getMessage());
            }
        }
    }
}
