package com.bu.backend;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)  // 알 수 없는 필드는 무시하도록 설정
public class Recommendation {

    @JsonProperty("list")
    private List<Item> list;

    // Getter와 Setter
    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    // Item 클래스 정의
    public static class Item {

    	private String recomNo;
        private String drCode;
//        private String drCodeName;
//        private String recomtitle;
//        private String recomauthor;
//        private String recompublisher;
//        private String recomcallno;
//        private String recomisbn;
//        private String recomfilepath;
//        private String recommokcha;
//        private String recomcontens;
//        private String regdate;
//        private String controlNo;
//        private int publishYear;
//        private int recomYear;
//        private int recomMonth;
//        private String mokchFilePath;

        @XmlElement(name = "recomNo")
        public String getRecomNo() {
            return recomNo;
        }

        public void setRecomNo(String recomNo) {
            this.recomNo = recomNo;
        }

        @XmlElement(name = "drCode")
        public String getDrCode() {
            return drCode;
        }

        public void setDrCode(String drCode) {
            this.drCode = drCode;
        }

//        @XmlElement(name = "drCodeName")
//        public String getDrCodeName() {
//            return drCodeName;
//        }
//
//        public void setDrCodeName(String drCodeName) {
//            this.drCodeName = drCodeName;
//        }
//
//        @XmlElement(name = "recomtitle")
//        public String getRecomtitle() {
//            return recomtitle;
//        }
//
//        public void setRecomtitle(String recomtitle) {
//            this.recomtitle = recomtitle;
//        }
//
//        @XmlElement(name = "recomauthor")
//        public String getRecomauthor() {
//            return recomauthor;
//        }
//
//        public void setRecomauthor(String recomauthor) {
//            this.recomauthor = recomauthor;
//        }
//
//        @XmlElement(name = "recompublisher")
//        public String getRecompublisher() {
//            return recompublisher;
//        }
//
//        public void setRecompublisher(String recompublisher) {
//            this.recompublisher = recompublisher;
//        }
//
//        @XmlElement(name = "recomcallno")
//        public String getRecomcallno() {
//            return recomcallno;
//        }
//
//        public void setRecomcallno(String recomcallno) {
//            this.recomcallno = recomcallno;
//        }
//
//        @XmlElement(name = "recomisbn")
//        public String getRecomisbn() {
//            return recomisbn;
//        }
//
//        public void setRecomisbn(String recomisbn) {
//            this.recomisbn = recomisbn;
//        }
//
//        @XmlElement(name = "recomfilepath")
//        public String getRecomfilepath() {
//            return recomfilepath;
//        }
//
//        public void setRecomfilepath(String recomfilepath) {
//            this.recomfilepath = recomfilepath;
//        }
//
//        @XmlElement(name = "recommokcha")
//        public String getRecommokcha() {
//            return recommokcha;
//        }
//
//        public void setRecommokcha(String recommokcha) {
//            this.recommokcha = recommokcha;
//        }
//
//        @XmlElement(name = "recomcontens")
//        public String getRecomcontens() {
//            return recomcontens;
//        }
//
//        public void setRecomcontens(String recomcontens) {
//            this.recomcontens = recomcontens;
//        }
//
//        @XmlElement(name = "regdate")
//        public String getRegdate() {
//            return regdate;
//        }
//
//        public void setRegdate(String regdate) {
//            this.regdate = regdate;
//        }
//
//        @XmlElement(name = "controlNo")
//        public String getControlNo() {
//            return controlNo;
//        }
//
//        public void setControlNo(String controlNo) {
//            this.controlNo = controlNo;
//        }
//
//        @XmlElement(name = "publishYear")
//        public int getPublishYear() {
//            return publishYear;
//        }
//
//        public void setPublishYear(int publishYear) {
//            this.publishYear = publishYear;
//        }
//
//        @XmlElement(name = "recomYear")
//        public int getRecomYear() {
//            return recomYear;
//        }
//
//        public void setRecomYear(int recomYear) {
//            this.recomYear = recomYear;
//        }
//
//        @XmlElement(name = "recomMonth")
//        public int getRecomMonth() {
//            return recomMonth;
//        }
//
//        public void setRecomMonth(int recomMonth) {
//            this.recomMonth = recomMonth;
//        }

//        @XmlElement(name = "mokchFilePath")
//        public String getMokchFilePath() {
//            return mokchFilePath;
//        }
//
//        public void setMokchFilePath(String mokchFilePath) {
//            this.mokchFilePath = mokchFilePath;
//        }
    }

 

   
}
