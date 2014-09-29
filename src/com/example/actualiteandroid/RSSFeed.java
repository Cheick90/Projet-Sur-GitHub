package com.example.actualiteandroid;

import java.io.Serializable;


public class RSSFeed implements Serializable {

	private String title;
    private String link;
    private String description;
    private String image;
    private String pubdate;
    private String attachmentUrl;
   
    public RSSFeed() {
    }

    public RSSFeed(String title, String link, String description, String image) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.image = image;
        
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }
    public String getImage() {
        return image;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void setImage(String image) {
        this.image = image ;
    }
    void setDate(String pubdate) {
		this.pubdate = pubdate;
    }
    public String getDate() {
		return pubdate;
	}
    public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

}


