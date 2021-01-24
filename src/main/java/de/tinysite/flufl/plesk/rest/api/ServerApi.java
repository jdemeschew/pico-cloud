package de.tinysite.flufl.plesk.rest.api;

import de.tinysite.flufl.plesk.rest.ApiClient;

import de.tinysite.flufl.plesk.rest.dto.ErrorResponse;
import de.tinysite.flufl.plesk.rest.dto.ServerInit;
import de.tinysite.flufl.plesk.rest.dto.ServerIp;
import de.tinysite.flufl.plesk.rest.dto.ServerLicense;
import de.tinysite.flufl.plesk.rest.dto.ServerMeta;
import de.tinysite.flufl.plesk.rest.dto.StatusResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2021-01-23T13:53:57.294+01:00")
@Component("de.tinysite.flufl.plesk.rest.api.ServerApi")
public class ServerApi {
    private ApiClient apiClient;

    public ServerApi() {
        this(new ApiClient());
    }

    @Autowired
    public ServerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Server Meta Information
     * 
     * <p><b>200</b> - Return Server Meta Information
     * @return ServerMeta
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ServerMeta serverGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/server").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "APIKeyHeader", "BasicAuth" };

        ParameterizedTypeReference<ServerMeta> returnType = new ParameterizedTypeReference<ServerMeta>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Performing initial server setup
     * 
     * <p><b>200</b> - Inital server setup was succesfully performed
     * <p><b>400</b> - Invalid request data
     * @param body Inital setup parameters
     * @return StatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StatusResponse serverInitPost(ServerInit body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling serverInitPost");
        }
        
        String path = UriComponentsBuilder.fromPath("/server/init").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "APIKeyHeader", "BasicAuth" };

        ParameterizedTypeReference<StatusResponse> returnType = new ParameterizedTypeReference<StatusResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Server IP Addresses
     * 
     * <p><b>200</b> - Return Server IP Addresses list
     * @return List&lt;ServerIp&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<ServerIp> serverIpsGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/server/ips").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "APIKeyHeader", "BasicAuth" };

        ParameterizedTypeReference<List<ServerIp>> returnType = new ParameterizedTypeReference<List<ServerIp>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Installing license key
     * 
     * <p><b>200</b> - License key was succesfully installed
     * <p><b>400</b> - Invalid request data
     * @param body License key
     * @return StatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StatusResponse serverLicensePost(ServerLicense body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling serverLicensePost");
        }
        
        String path = UriComponentsBuilder.fromPath("/server/license").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "APIKeyHeader", "BasicAuth" };

        ParameterizedTypeReference<StatusResponse> returnType = new ParameterizedTypeReference<StatusResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
