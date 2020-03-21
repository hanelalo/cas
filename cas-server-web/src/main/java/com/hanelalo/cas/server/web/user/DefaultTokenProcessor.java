package com.hanelalo.cas.server.web.user;

import com.google.common.collect.Lists;
import com.hanelalo.cas.server.base.exception.CasServerPreconditions;
import com.hanelalo.cas.server.base.token.AbstractTokenProcessor;
import com.hanelalo.cas.server.base.token.Payload;
import com.hanelalo.cas.server.base.token.TokenHelper;
import com.hanelalo.cas.server.client.ClientDetails;
import com.hanelalo.cas.server.client.ClientPoint;
import com.hanelalo.cas.server.config.AuthServerProperties;
import com.hanelalo.cas.server.context.CasRequestContext;
import com.hanelalo.cas.server.user.UserDetails;
import com.hanelalo.cas.server.web.user.core.DefaultUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ClientPoint(clientId = "948fe603f61dc036b5c596dc09fe3ce3f3d30dc90f024c85f3c82db2ccab679d")
public class DefaultTokenProcessor extends AbstractTokenProcessor {

    @Autowired
    public DefaultTokenProcessor(TokenHelper tokenHelper,AuthServerProperties properties){
        setTokenHelper(tokenHelper);
        setProperties(properties);
    }

    @Override
    public Payload buildPayLoad(UserDetails details, String accessToken) {
        CasServerPreconditions.checkClientError(details instanceof DefaultUserDetails);
        DefaultUserDetails defaultUserDetails = (DefaultUserDetails) details;
        ClientDetails client = CasRequestContext.get(ClientDetails.class);
        return new Payload().setClientId(client.getClientId())
                .setCreateDate(System.currentTimeMillis())
                .setValidTime(getProperties().getValidTime())
                .setUserId(defaultUserDetails.getUserId())
                .setAccessToken(accessToken)
                .setAuthorities(Lists.newArrayList(details.getAuthorities()));
    }
}
