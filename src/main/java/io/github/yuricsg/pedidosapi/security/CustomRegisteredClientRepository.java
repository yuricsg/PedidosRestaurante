package io.github.yuricsg.pedidosapi.security;

import io.github.yuricsg.pedidosapi.service.ClientService;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomRegisteredClientRepository implements RegisteredClientRepository {

    private final ClientService clientService;

    public CustomRegisteredClientRepository(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void save(RegisteredClient registeredClient) {}

    @Override
    public RegisteredClient findById(String id) {
        return null;
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        var client = clientService.obterPorClientID(clientId);

        if(client == null){
            return null;
        }

        return RegisteredClient
                .withId(client.getId().toString())
                .clientSecret(client.getClientSecret())
                .redirectUri(client.getRedirectURI())
                .scope(client.getScope())
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .tokenSettings()
                .clientSettings()
                .build();
    }
}
