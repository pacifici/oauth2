package com.rift.oauth2.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class AuthorizationRequest {

    @NotBlank(message = "responseType is required")
    private String responseType;

    @NotBlank(message = "clientId is required")
    private String clientId;

    @NotBlank(message = "redirectUri is required")
    @Pattern(
            regexp = "https?://.*",
            message = "redirect_uri must be a valid URL starting with http:// or https://"
    )
    private String redirectUri;
    private String scope;
    private String state;

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
