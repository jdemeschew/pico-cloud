package de.tinysite.flufl.plesk.rest.api;

import de.tinysite.flufl.plesk.rest.ApiClient;

import de.tinysite.flufl.plesk.rest.dto.ErrorResponse;
import de.tinysite.flufl.plesk.rest.dto.Extension;
import de.tinysite.flufl.plesk.rest.dto.ExtensionInstallRequest;
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
@Component("de.tinysite.flufl.plesk.rest.api.ExtensionsApi")
public class ExtensionsApi {
    private ApiClient apiClient;

    public ExtensionsApi() {
        this(new ApiClient());
    }

    @Autowired
    public ExtensionsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List of installed Extensions
     * 
     * <p><b>200</b> - OK
     * @return List&lt;Extension&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Extension> extensionsGet() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/extensions").build().toUriString();
        
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

        ParameterizedTypeReference<List<Extension>> returnType = new ParameterizedTypeReference<List<Extension>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete an Extension
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Extension is not installed
     * @param id Extension identifier
     * @return StatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StatusResponse extensionsIdDelete(String id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling extensionsIdDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/extensions/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<StatusResponse> returnType = new ParameterizedTypeReference<StatusResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Disable extension
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Extension is not installed
     * @param id Extension identifier
     * @return StatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StatusResponse extensionsIdDisablePut(String id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling extensionsIdDisablePut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/extensions/{id}/disable").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<StatusResponse> returnType = new ParameterizedTypeReference<StatusResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Enable extension
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Extension is not installed
     * @param id Extension identifier
     * @return StatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StatusResponse extensionsIdEnablePut(String id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling extensionsIdEnablePut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/extensions/{id}/enable").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<StatusResponse> returnType = new ParameterizedTypeReference<StatusResponse>() {};
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Extension details
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Extension is not installed
     * @param id Extension identifier
     * @return Extension
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Extension extensionsIdGet(String id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling extensionsIdGet");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/extensions/{id}").buildAndExpand(uriVariables).toUriString();
        
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

        ParameterizedTypeReference<Extension> returnType = new ParameterizedTypeReference<Extension>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Install a new Extension
     * 
     * <p><b>200</b> - Extension successfully installed
     * <p><b>400</b> - Invalid request data
     * @param body Installation type and resource
     * @return StatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StatusResponse extensionsPost(ExtensionInstallRequest body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling extensionsPost");
        }
        
        String path = UriComponentsBuilder.fromPath("/extensions").build().toUriString();
        
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
