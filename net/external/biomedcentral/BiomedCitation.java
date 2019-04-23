/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.biomedcentral;

import org.jsoup.nodes.Document;





/**
 *
 * @author daanm
 */
public class BiomedCitation {

    private String pdf_url;
    private String fulltext_html_url;
    private String journal_title;
    private String publisher;
    private String issn;
    private String title;
    private String volume;
    private String issue;
    private String publication_date;
    private String online_date;
    private String firstpage;
    private String article_type;
    private String doi;






    public BiomedCitation(Document document) {
        pdf_url = document.getElementsByAttributeValue("name", "citation_pdf_url").get(0).attr("content");
        fulltext_html_url = document.getElementsByAttributeValue("name", "citation_fulltext_html_url").get(0).attr("content");
        journal_title = document.getElementsByAttributeValue("name", "citation_journal_title").get(0).attr("content");
        publisher = document.getElementsByAttributeValue("name", "citation_publisher").get(0).attr("content");
        issn = document.getElementsByAttributeValue("name", "citation_issn").get(0).attr("content");
        title = document.getElementsByAttributeValue("name", "citation_title").get(0).attr("content");
        volume = document.getElementsByAttributeValue("name", "citation_volume").get(0).attr("content");
        issue = document.getElementsByAttributeValue("name", "citation_issue").get(0).attr("content");
        publication_date = document.getElementsByAttributeValue("name", "citation_publication_date").get(0).attr("content");
        online_date = document.getElementsByAttributeValue("name", "citation_online_date").get(0).attr("content");
        firstpage = document.getElementsByAttributeValue("name", "citation_firstpage").get(0).attr("content");
        article_type = document.getElementsByAttributeValue("name", "citation_article_type").get(0).attr("content");
        doi = document.getElementsByAttributeValue("name", "citation_doi").get(0).attr("content");
    }






    @Override
    public String toString() {
        return "pdf url          : " + pdf_url + "\n"
                + "fulltext html    : " + fulltext_html_url + "\n"
                + "journal title    : " + journal_title + "\n"
                + "publisher        : " + publisher + "\n"
                + "issn             : " + issn + "\n"
                + "title            : " + title + "\n"
                + "volume           : " + volume + "\n"
                + "issue            : " + issue + "\n"
                + "publication date : " + publication_date + "\n"
                + "online date      : " + online_date + "\n"
                + "firstpage        : " + firstpage + "\n"
                + "article type     : " + article_type + "\n"
                + "doi              : " + doi;
    }






    public String getPdf_url() {
        return pdf_url;
    }






    public void setPdf_url(String pdf_url) {
        this.pdf_url = pdf_url;
    }






    public String getFulltext_html_url() {
        return fulltext_html_url;
    }






    public void setFulltext_html_url(String fulltext_html_url) {
        this.fulltext_html_url = fulltext_html_url;
    }






    public String getJournal_title() {
        return journal_title;
    }






    public void setJournal_title(String journal_title) {
        this.journal_title = journal_title;
    }






    public String getPublisher() {
        return publisher;
    }






    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }






    public String getIssn() {
        return issn;
    }






    public void setIssn(String issn) {
        this.issn = issn;
    }






    public String getTitle() {
        return title;
    }






    public void setTitle(String title) {
        this.title = title;
    }






    public String getVolume() {
        return volume;
    }






    public void setVolume(String volume) {
        this.volume = volume;
    }






    public String getIssue() {
        return issue;
    }






    public void setIssue(String issue) {
        this.issue = issue;
    }






    public String getPublication_date() {
        return publication_date;
    }






    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }






    public String getOnline_date() {
        return online_date;
    }






    public void setOnline_date(String online_date) {
        this.online_date = online_date;
    }






    public String getFirstpage() {
        return firstpage;
    }






    public void setFirstpage(String firstpage) {
        this.firstpage = firstpage;
    }






    public String getArticle_type() {
        return article_type;
    }






    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }






    public String getDoi() {
        return doi;
    }






    public void setDoi(String doi) {
        this.doi = doi;
    }


}



