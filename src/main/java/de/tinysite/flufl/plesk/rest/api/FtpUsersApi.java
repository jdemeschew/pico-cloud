package de.tinysite.flufl.plesk.rest.api;

import de.tinysite.flufl.plesk.rest.ApiClient;

import de.tinysite.flufl.plesk.rest.dto.ErrorResponse;
import de.tinysite.flufl.plesk.rest.dto.FtpUser;
import de.tinysite.flufl.plesk.rest.dto.FtpUserRequest;
import de.tinysite.flufl.plesk.rest.dto.FtpUserUpdateRequest;
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
@Component("de.tinysite.flufl.plesk.rest.api.FtpUsersApi")
public class FtpUsersApi {
    private ApiClient apiClient;

    public FtpUsersApi() {
        this(new ApiClient());
    }

    @Autowired
    public FtpUsersApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get FTP users
     * 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request data
     * <p><b>404</b> - Domain/user is not found
     * @param name Filter data by user name
     * @param domain Filter data by domain name
     * @return List&lt;FtpUser&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<FtpUser> ftpusersGet(String name, String domain) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/ftpusers").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "name", name));
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "domain", domain));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "APIKeyHeader", "BasicAuth" };

        ParameterizedTypeReference<List<FtpUser>> returnType = new ParameterizedTypeReference<List<FtpUser>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete FTP user
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - User is not found
     * @param name FTP User name
     * @return StatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StatusResponse ftpusersNameDelete(String name) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'name' when calling ftpusersNameDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("name", name);
        String path = UriComponentsBuilder.fromPath("/ftpusers/{name}").buildAndExpand(uriVariables).toUriString();
        
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
        return apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Update FTP user
     * 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request data
     * <p><b>404</b> - User is not found
     * @param name FTP user name
     * @param body FTP User data
     * @return StatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StatusResponse ftpusersNamePut(String name, FtpUserUpdateRequest body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'name' is set
        if (name == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'name' when calling ftpusersNamePut");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling ftpusersNamePut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("name", name);
        String path = UriComponentsBuilder.fromPath("/ftpusers/{name}").buildAndExpand(uriVariables).toUriString();
        
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
        return apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Create FTP user
     * 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request data
     * <p><b>404</b> - Domain is not found
     * @param body FTP User data
     * @return FtpUser
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public FtpUser ftpusersPost(FtpUserRequest body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling ftpusersPost");
        }
        
        String path = UriComponentsBuilder.fromPath("/ftpusers").build().toUriString();
        
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

        ParameterizedTypeReference<FtpUser> returnType = new ParameterizedTypeReference<FtpUser>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
