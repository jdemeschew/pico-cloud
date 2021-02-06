package de.tinysite.pico.cloud.dto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PicoSite {

    /*
    Site name which will be used as subdomain name
     */
    private String siteName="";
    /*
    Site title, will be used as  Header of the Pico site
     */
    private String siteTitle="";
    /*
    User name,used on Pico site, eg as reciever name if sending mails to the user
     */
    private String userFullName="";
    /**
     * User password
     */
    private String userPassword="";
    /*
    LInk to the deployed site
     */
    private String siteLink="";

    public String getSiteTitle() {
        return siteTitle;
    }

    public void
    /*
    Setter for the title field
    Will replace plus character with spaces before setting the value
     */
    setSiteTitle(String siteTitle) {
        if(siteTitle!=null){
        this.siteTitle =siteTitle.replaceAll(Pattern.quote("+"),
                Matcher.quoteReplacement(" "));
    }}
    public void setUserFullName(String userFullName) {
        if(userFullName!=null) {
            this.userFullName = userFullName.replaceAll(Pattern.quote("+"),
                    Matcher.quoteReplacement(" "));
        }
    }


/*User email address

 */
    private String userEmail;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        if(userEmail !=null) {
            this.userEmail = userEmail;
        }
    }

    public String getSiteLink() {
        return siteLink;
    }

    public void setSiteLink(String siteLink) {
        if (siteLink !=null){
        this.siteLink = siteLink;
    }}

    public String getUserFullName() {
        return userFullName;
    }



    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }
}
