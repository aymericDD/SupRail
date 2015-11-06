/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Rico
 */
@Entity
public class FreihtTrain extends Train implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    @Column(nullable = false)
    private Long maxWeight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getMaxWeight() {
        return this.maxWeight;
    }
    
    public void setMaxWheight(Long maxWheight) {
        this.maxWeight = maxWheight;
    }

    @Override
    public String toString() {
        return "com.supinfo.suprails.entity.FreihtTrain[ id=" + id + " ]";
    }
    
}
