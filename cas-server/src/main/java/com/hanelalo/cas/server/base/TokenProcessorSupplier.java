package com.hanelalo.cas.server.base;

import com.hanelalo.cas.server.base.token.AbstractTokenProcessor;
import com.hanelalo.cas.server.client.Client;
import com.hanelalo.cas.server.client.ClientPoint;
import com.hanelalo.cas.server.context.CasApplicationContext;
import com.hanelalo.cas.server.context.CasRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.function.Supplier;

@Component
public class TokenProcessorSupplier implements Supplier<AbstractTokenProcessor> {
    private static final Logger logger = LoggerFactory.getLogger(TokenProcessorSupplier.class);

    @Override
    public AbstractTokenProcessor get() {
        List<AbstractTokenProcessor> tokenProcessors = CasApplicationContext.getBeans(AbstractTokenProcessor.class);
        Client client = CasRequestContext.get(Client.class);
        if (null == client || CollectionUtils.isEmpty(tokenProcessors)) {
            return null;
        }
        String clientId = client.getClientId();
        for (AbstractTokenProcessor tokenProcessor : tokenProcessors) {
            ClientPoint clientPoint = tokenProcessor.getClass().getAnnotation(ClientPoint.class);
            if (StringUtils.equalsIgnoreCase(clientId, clientPoint.clientId())) {
                return tokenProcessor;
            }
        }
        return null;
    }
}
