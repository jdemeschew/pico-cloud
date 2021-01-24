package de.tinysite.flufl.plesk.rest.api;

import de.tinysite.flufl.plesk.rest.ApiClient;

import de.tinysite.flufl.plesk.rest.dto.Database;
import de.tinysite.flufl.plesk.rest.dto.DatabaseRequest;
import de.tinysite.flufl.plesk.rest.dto.DatabaseServer;
import de.tinysite.flufl.plesk.rest.dto.DatabaseUser;
import de.tinysite.flufl.plesk.rest.dto.DatabaseUserRequest;
import de.tinysite.flufl.plesk.rest.dto.DatabaseUserUpdateRequest;
import de.tinysite.flufl.plesk.rest.dto.ErrorResponse;
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
@Component("de.tinysite.flufl.plesk.rest.api.DatabasesApi")
public class DatabasesApi {
    private ApiClient apiClient;

    public DatabasesApi() {
        this(new ApiClient());
    }

    @Autowired
    public DatabasesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Get databases
     * 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request data
     * <p><b>404</b> - Server is not found
     * @param domain Filter data by domain name
     * @return List&lt;Database&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Database> databasesGet(String domain) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/databases").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
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

        ParameterizedTypeReference<List<Database>> returnType = new ParameterizedTypeReference<List<Database>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete database
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Database is not found
     * @param id Database ID
     * @return StatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StatusResponse databasesIdDelete(Integer id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling databasesIdDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/databases/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Create database
     * 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request data
     * <p><b>404</b> - Domain is not found
     * @param body Database data
     * @return Database
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public Database databasesPost(DatabaseRequest body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling databasesPost");
        }
        
        String path = UriComponentsBuilder.fromPath("/databases").build().toUriString();
        
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

        ParameterizedTypeReference<Database> returnType = new ParameterizedTypeReference<Database>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get database servers
     * 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request data
     * <p><b>404</b> - Server is not found
     * @param id Filter data by database server id
     * @return List&lt;DatabaseServer&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<DatabaseServer> dbserversGet(Integer id) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/dbservers").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "id", id));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "APIKeyHeader", "BasicAuth" };

        ParameterizedTypeReference<List<DatabaseServer>> returnType = new ParameterizedTypeReference<List<DatabaseServer>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Get database users
     * 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request data
     * <p><b>404</b> - Domain/database is not found
     * @param dbId Filter data by database ID
     * @return List&lt;DatabaseUser&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<DatabaseUser> dbusersGet(Integer dbId) throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/dbusers").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();
        
        queryParams.putAll(apiClient.parameterToMultiValueMap(null, "dbId", dbId));

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { 
            "application/json"
        };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "APIKeyHeader", "BasicAuth" };

        ParameterizedTypeReference<List<DatabaseUser>> returnType = new ParameterizedTypeReference<List<DatabaseUser>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
    /**
     * Delete database user
     * 
     * <p><b>200</b> - OK
     * <p><b>404</b> - Database user is not found
     * @param id Database user ID
     * @return StatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StatusResponse dbusersIdDelete(Integer id) throws RestClientException {
        Object postBody = null;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling dbusersIdDelete");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/dbusers/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Update database user
     * 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request data
     * <p><b>404</b> - Server/database/domain is not found
     * @param id Database user ID
     * @param body Database user data
     * @return StatusResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public StatusResponse dbusersIdPut(Integer id, DatabaseUserUpdateRequest body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'id' when calling dbusersIdPut");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling dbusersIdPut");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("id", id);
        String path = UriComponentsBuilder.fromPath("/dbusers/{id}").buildAndExpand(uriVariables).toUriString();
        
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
     * Create database user
     * 
     * <p><b>200</b> - OK
     * <p><b>400</b> - Invalid request data
     * <p><b>404</b> - Server/database/domain is not found
     * @param body Database User data
     * @return DatabaseUser
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public DatabaseUser dbusersPost(DatabaseUserRequest body) throws RestClientException {
        Object postBody = body;
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling dbusersPost");
        }
        
        String path = UriComponentsBuilder.fromPath("/dbusers").build().toUriString();
        
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

        ParameterizedTypeReference<DatabaseUser> returnType = new ParameterizedTypeReference<DatabaseUser>() {};
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
