package com.dgr.firstwords.googleapis.search.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response
{
    private ResponseData responseData;

    private String responseDetails;

    private String responseStatus;

    public ResponseData getResponseData ()
    {
        return responseData;
    }

    public void setResponseData (ResponseData responseData)
    {
        this.responseData = responseData;
    }

    public String getResponseDetails ()
    {
        return responseDetails;
    }

    public void setResponseDetails (String responseDetails)
    {
        this.responseDetails = responseDetails;
    }

    public String getResponseStatus ()
    {
        return responseStatus;
    }

    public void setResponseStatus (String responseStatus)
    {
        this.responseStatus = responseStatus;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [responseData = "+responseData+", responseDetails = "+responseDetails+", responseStatus = "+responseStatus+"]";
    }
}