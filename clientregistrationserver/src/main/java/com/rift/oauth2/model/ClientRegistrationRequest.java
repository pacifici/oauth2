package com.rift.oauth2.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public class ClientRegistrationRequest {

    @NotEmpty(message = "Redirect URIs cannot be empty.")
    private List<
            @Pattern(regexp = "^https://.*", message = "Redirect URIs must start with https://")
                    String> redirectUris;

    @NotEmpty(message = "Grant types cannot be empty.")
    private List<String> grantTypes;

    @NotNull(message = "Token endpoint authentication method is required.")
    private TokenEndpointAuthMethod tokenEndpointAuthMethod;

    @Size(max = 1024, message = "Scope field must not exceed 1024 characters.")
    private String scope;

    // Default constructor for deserialization
    public ClientRegistrationRequest() {}

    // Builder-based private constructor
    private ClientRegistrationRequest(Builder builder) {
        this.redirectUris = builder.redirectUris;
        this.grantTypes = builder.grantTypes;
        this.tokenEndpointAuthMethod = builder.tokenEndpointAuthMethod;
        this.scope = builder.scope;
    }

    // Getters
    public List<String> getRedirectUris() {
        return redirectUris;
    }

    public List<String> getGrantTypes() {
        return grantTypes;
    }

    public TokenEndpointAuthMethod getTokenEndpointAuthMethod() {
        return tokenEndpointAuthMethod;
    }

    public String getScope() {
        return scope;
    }

    // Setters for JSON deserialization
    public void setRedirectUris(List<String> redirectUris) {
        this.redirectUris = redirectUris;
    }

    public void setGrantTypes(List<String> grantTypes) {
        this.grantTypes = grantTypes;
    }

    public void setTokenEndpointAuthMethod(TokenEndpointAuthMethod tokenEndpointAuthMethod) {
        this.tokenEndpointAuthMethod = tokenEndpointAuthMethod;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    // Static method to create a builder
    public static Builder builder() {
        return new Builder();
    }

    // Builder Class
    public static class Builder {
        private List<String> redirectUris;
        private List<String> grantTypes;
        private TokenEndpointAuthMethod tokenEndpointAuthMethod;
        private String scope;

        public Builder redirectUris(List<String> redirectUris) {
            this.redirectUris = redirectUris;
            return this;
        }

        public Builder grantTypes(List<String> grantTypes) {
            this.grantTypes = grantTypes;
            return this;
        }

        public Builder tokenEndpointAuthMethod(TokenEndpointAuthMethod tokenEndpointAuthMethod) {
            this.tokenEndpointAuthMethod = tokenEndpointAuthMethod;
            return this;
        }

        public Builder scope(String scope) {
            this.scope = scope;
            return this;
        }

        public ClientRegistrationRequest build() {
            return new ClientRegistrationRequest(this);
        }
    }
}
