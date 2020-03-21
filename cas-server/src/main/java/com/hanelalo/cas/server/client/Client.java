package com.hanelalo.cas.server.client;

public class Client {
    private String clientId;

    public Client(){}

    public Client(String clientId){
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
