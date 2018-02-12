package com.dgr.firstwords.googleapis.search.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results
{
    private String titleNoFormatting;

    private String tbUrl;

    private String originalContextUrl;

    private String width;

    private String unescapedUrl;

    private String url;

    private String visibleUrl;

    private String content;

    private String GsearchResultClass;

    private String tbWidth;

    private String title;

    private String height;

    private String imageId;

    private String contentNoFormatting;

    private String tbHeight;

    public String getTitleNoFormatting ()
    {
        return titleNoFormatting;
    }

    public void setTitleNoFormatting (String titleNoFormatting)
    {
        this.titleNoFormatting = titleNoFormatting;
    }

    public String getTbUrl ()
    {
        return tbUrl;
    }

    public void setTbUrl (String tbUrl)
    {
        this.tbUrl = tbUrl;
    }

    public String getOriginalContextUrl ()
    {
        return originalContextUrl;
    }

    public void setOriginalContextUrl (String originalContextUrl)
    {
        this.originalContextUrl = originalContextUrl;
    }

    public String getWidth ()
    {
        return width;
    }

    public void setWidth (String width)
    {
        this.width = width;
    }

    public String getUnescapedUrl ()
    {
        return unescapedUrl;
    }

    public void setUnescapedUrl (String unescapedUrl)
    {
        this.unescapedUrl = unescapedUrl;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getVisibleUrl ()
    {
        return visibleUrl;
    }

    public void setVisibleUrl (String visibleUrl)
    {
        this.visibleUrl = visibleUrl;
    }

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getGsearchResultClass ()
    {
        return GsearchResultClass;
    }

    public void setGsearchResultClass (String GsearchResultClass)
    {
        this.GsearchResultClass = GsearchResultClass;
    }

    public String getTbWidth ()
    {
        return tbWidth;
    }

    public void setTbWidth (String tbWidth)
    {
        this.tbWidth = tbWidth;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getHeight ()
    {
        return height;
    }

    public void setHeight (String height)
    {
        this.height = height;
    }

    public String getImageId ()
    {
        return imageId;
    }

    public void setImageId (String imageId)
    {
        this.imageId = imageId;
    }

    public String getContentNoFormatting ()
    {
        return contentNoFormatting;
    }

    public void setContentNoFormatting (String contentNoFormatting)
    {
        this.contentNoFormatting = contentNoFormatting;
    }

    public String getTbHeight ()
    {
        return tbHeight;
    }

    public void setTbHeight (String tbHeight)
    {
        this.tbHeight = tbHeight;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [titleNoFormatting = "+titleNoFormatting+", tbUrl = "+tbUrl+", originalContextUrl = "+originalContextUrl+", width = "+width+", unescapedUrl = "+unescapedUrl+", url = "+url+", visibleUrl = "+visibleUrl+", content = "+content+", GsearchResultClass = "+GsearchResultClass+", tbWidth = "+tbWidth+", title = "+title+", height = "+height+", imageId = "+imageId+", contentNoFormatting = "+contentNoFormatting+", tbHeight = "+tbHeight+"]";
    }
}

