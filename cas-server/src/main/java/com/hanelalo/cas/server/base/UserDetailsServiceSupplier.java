package com.hanelalo.cas.server.base;

import com.hanelalo.cas.server.client.Client;
import com.hanelalo.cas.server.client.ClientPoint;
import com.hanelalo.cas.server.context.CasApplicationContext;
import com.hanelalo.cas.server.context.CasRequestContext;
import com.hanelalo.cas.server.user.UserDetailService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.function.Supplier;

@Component
public class UserDetailsServiceSupplier implements Supplier<UserDetailService> {
    @Override
    public UserDetailService get() {
        List<UserDetailService> userDetailServices = CasApplicationContext.getBeans(UserDetailService.class);
        Client client = CasRequestContext.get(Client.class);
        if (null == client || CollectionUtils.isEmpty(userDetailServices)) {
            return null;
        }
        String clientId = client.getClientId();
        for (UserDetailService userDetailService : userDetailServices) {
            ClientPoint clientPoint = userDetailService.getClass().getAnnotation(ClientPoint.class);
            if (StringUtils.equalsIgnoreCase(clientId, clientPoint.clientId())) {
                return userDetailService;
            }
        }
        return null;
    }
}
