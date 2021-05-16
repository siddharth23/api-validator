package com.moonhub.apitest;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Null;
import java.util.List;

public class APIValidatorForm {
    @NotNull
    @Size(min=2, max=30)
    private String url;

    @NotNull
    @Size(min=2, max=30)
    private String method;


    private List<String> headerKey;

    @Null
    private String requestBody;


    private List<String> headerValue;

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String toString() {
        return "Person(Name: " + this.url + ", Age: " + this.method + ")";
    }

    public List<String> getHeaderKey() {
        return  headerKey;
    }

    public void setHeaderKey(List<String> headerKey) {
        this.headerKey = headerKey;
    }

    public List<String> getHeaderValue() {
        return headerValue;
    }

    public void setHeaderValue(List<String> headerValue) {
        this.headerValue = headerValue;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }
}
