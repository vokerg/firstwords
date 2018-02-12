package com.dgr.firstwords.googleapis.search.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cursor
{
    private String moreResultsUrl;

    private String currentPageIndex;

    private String resultCount;

    private Pages[] pages;

    private String searchResultTime;

    private String estimatedResultCount;

    public String getMoreResultsUrl ()
    {
        return moreResultsUrl;
    }

    public void setMoreResultsUrl (String moreResultsUrl)
    {
        this.moreResultsUrl = moreResultsUrl;
    }

    public String getCurrentPageIndex ()
    {
        return currentPageIndex;
    }

    public void setCurrentPageIndex (String currentPageIndex)
    {
        this.currentPageIndex = currentPageIndex;
    }

    public String getResultCount ()
    {
        return resultCount;
    }

    public void setResultCount (String resultCount)
    {
        this.resultCount = resultCount;
    }

    public Pages[] getPages ()
    {
        return pages;
    }

    public void setPages (Pages[] pages)
    {
        this.pages = pages;
    }

    public String getSearchResultTime ()
    {
        return searchResultTime;
    }

    public void setSearchResultTime (String searchResultTime)
    {
        this.searchResultTime = searchResultTime;
    }

    public String getEstimatedResultCount ()
    {
        return estimatedResultCount;
    }

    public void setEstimatedResultCount (String estimatedResultCount)
    {
        this.estimatedResultCount = estimatedResultCount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [moreResultsUrl = "+moreResultsUrl+", currentPageIndex = "+currentPageIndex+", resultCount = "+resultCount+", pages = "+pages+", searchResultTime = "+searchResultTime+", estimatedResultCount = "+estimatedResultCount+"]";
    }
}