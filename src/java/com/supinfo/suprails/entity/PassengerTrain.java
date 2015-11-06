/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.entity;

import com.sun.xml.ws.api.transport.tcp.SelectOptimalTransport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Rico
 */
@Entity
public class PassengerTrain extends Train implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty
    @Column(nullable = false)
    private Integer seatQuantity;
    
    public Integer getSeatQuantity() {
        return this.seatQuantity;
    }
    
    public void setSeatQuantity(Integer seatQuantity) {
        this.seatQuantity = seatQuantity;
    }

    @Override
    public String toString() {
        return "com.supinfo.suprails.entity.PassengerTrain[ id=" + id + " ]";
    }
    
}
