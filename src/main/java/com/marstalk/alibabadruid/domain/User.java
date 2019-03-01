package com.marstalk.alibabadruid.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private long id;


    @Id
    @Column(name = "id" )
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
