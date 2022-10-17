package com.chiku.dist.dmsrest.model;

import javax.persistence.*;

@Entity
@Table
public class Type {
    @javax.persistence.Id
    @SequenceGenerator(name = "type_sequence", sequenceName = "type_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "type_sequence")
    private Long Id;
    private String screenNo;
    private String screenName;
    private String itemNo;
    private String itemText;

    public Type() {
        super();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getScreenNo() {
        return screenNo;
    }

    public void setScreenNo(String screenNo) {
        this.screenNo = screenNo;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public Type(Long id, String screenNo, String screenName, String itemNo, String itemText) {
        Id = id;
        this.screenNo = screenNo;
        this.screenName = screenName;
        this.itemNo = itemNo;
        this.itemText = itemText;
    }

}
