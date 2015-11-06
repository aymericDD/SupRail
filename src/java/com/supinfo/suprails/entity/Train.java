/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Rico
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
public abstract class Train implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public enum Traction{ELECTRIC,DIESEL};

    @Column(name="traction") 
    @Enumerated(EnumType.ORDINAL) 
    private Traction traction;
 
    @NotEmpty
    @Column(nullable = false)
    private Long maxSpeed;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Traction getTraction() {
        return traction;
    }

    public void setTraction(Traction traction) {
        this.traction = traction;
    }
    
    public Long getMaxSpeed() {
        return this.maxSpeed;
    }
    
    public void setMaxSpeed(Long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "com.supinfo.suprails.entity.Train[ id=" + id + " ]";
    }
    
}
