package com.copus.v1.domain.level;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id @Column(name = "item_id")
    private String id;

    private String name;

    private String org;

    /**
     * (item_id, name, org)
     */
    public Item(String id, String name, String org) {
        this.id = id;
        this.name = name;
        this.org = org;
    }
}
