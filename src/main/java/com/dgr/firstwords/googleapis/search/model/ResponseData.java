package com.dgr.firstwords.googleapis.search.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData
{
    private Cursor cursor;

    private Results[] results;

    public Cursor getCursor ()
    {
        return cursor;
    }

    public void setCursor (Cursor cursor)
    {
        this.cursor = cursor;
    }

    public Results[] getResults ()
    {
        return results;
    }

    public void setResults (Results[] results)
    {
        this.results = results;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [cursor = "+cursor+", results = "+results+"]";
    }
}
