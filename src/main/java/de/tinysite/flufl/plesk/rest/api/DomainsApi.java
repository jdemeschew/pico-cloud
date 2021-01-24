package de.tinysite.flufl.plesk.rest.api;

import de.tinysite.flufl.plesk.rest.ApiClient;

import de.tinysite.flufl.plesk.rest.dto.Client;
import de.tinysite.flufl.plesk.rest.dto.CreatedResponse;
import de.tinysite.flufl.plesk.rest.dto.DomainRequest;
import de.tinysite.flufl.plesk.rest.dto.DomainResponse;
import de.tinysite.flufl.plesk.rest.dto.DomainStatus;
import de.tinysite.flufl.plesk.rest.dto.ErrorResponse;

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

public class DomainsApi {
    private ApiClient apiClient;

    public DomainsApi() {
        this(new ApiClient());
    }

    @Autowired
    public DomainsApi(ApiClient apiClient) {
        apiClient.setDebugging(true);
        this.apiClient = apiClient;
        configureApiClientpiClient();
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List all domains
     * 
     * <p><b>200</b> - OK
     * @param name Filter data by domain name
     * @return List&lt;DomainResponse&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<DomainResponse> domainsGet(String name) throws RestClientException {
        Object postBody = null;
        String path = UriComponentsBuilder.fromPath("/domains").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  "BasicAuth" };

        ParameterizedTypeReference<List<DomainResponse>> returnType = new ParameterizedTypeReference<List<DomainResponse>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get domain client
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Domain is not found
     * @param id Domain ID
     * @return Client
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Client domainsIdClientGet(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling domainsIdClientGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/domains/{id}/client").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "APIKeyHeader", "BasicAuth" };

        ParameterizedTypeReference<Client> returnType = new ParameterizedTypeReference<Client>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete a Domain
     * 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request data
     * <p><b>404</b> - Domain is not found
     * @param id Domain ID
     * @return CreatedResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CreatedResponse domainsIdDelete(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling domainsIdDelete");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/domains/{id}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = {
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "APIKeyHeader", "BasicAuth" };

        ParameterizedTypeReference<CreatedResponse> returnType = new ParameterizedTypeReference<CreatedResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Domain details
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Domain is not found
     * @param id Domain ID
     * @return DomainResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DomainResponse domainsIdGet(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling domainsIdGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/domains/{id}").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "APIKeyHeader", "BasicAuth" };

        ParameterizedTypeReference<DomainResponse> returnType = new ParameterizedTypeReference<DomainResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update a Domain
     * 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request data
     * <p><b>404</b> - Domain is not found
     * @param body Domain
     * @param id Domain ID
     * @return CreatedResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CreatedResponse domainsIdPut(DomainRequest body, Integer id) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling domainsIdPut");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling domainsIdPut");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/domains/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<CreatedResponse> returnType = new ParameterizedTypeReference<CreatedResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get Domain status
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Domain is not found
     * @param id Domain ID
     * @return DomainStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DomainStatus domainsIdStatusGet(Integer id) throws RestClientException {
        Object postBody = null;
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling domainsIdStatusGet");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/domains/{id}/status").buildAndExpand(uriVariables).toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
         };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {  };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "APIKeyHeader", "BasicAuth" };

        ParameterizedTypeReference<DomainStatus> returnType = new ParameterizedTypeReference<DomainStatus>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update a Domain status
     * 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request data
     * <p><b>404</b> - Domain is not found
     * @param body Domain status
     * @param id Domain ID
     * @return DomainStatus
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DomainStatus domainsIdStatusPut(DomainStatus body, Integer id) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling domainsIdStatusPut");
        }
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling domainsIdStatusPut");
        }
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/domains/{id}/status").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<DomainStatus> returnType = new ParameterizedTypeReference<DomainStatus>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create a new Domain
     * 
     * <p><b>201</b> - Domain successfully created
     * <p><b>400</b> - Invalid request data
     * @param body Domain data
     * @return CreatedResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CreatedResponse domainsPost(DomainRequest body) throws RestClientException {
        Object postBody = body;
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling domainsPost");
        }
        String path = UriComponentsBuilder.fromPath("/domains").build().toUriString();
        
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

        ParameterizedTypeReference<CreatedResponse> returnType = new ParameterizedTypeReference<CreatedResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    private void configureApiClientpiClient(){
        final String[] accepts = {
                "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        apiClient.setDebugging(true);
        apiClient.setUsername("root");
        apiClient.setPassword("MduMpM73");
        final String[] contentTypes = {
                "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);
    }
}
