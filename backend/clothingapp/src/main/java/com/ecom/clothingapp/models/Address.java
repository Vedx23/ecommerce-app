package com.ecom.clothingapp.models;

import org.hibernate.internal.build.AllowPrintStacktrace;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllowPrintStacktrace
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "address")
@AttributeOverride(name = "id", column = @Column(name = "address_id"))
public class Address extends Base{

    private String country;

    private String state;

    @Enumerated(EnumType.STRING)
    private String city;

    private Long zipcode;

    private String street1;

    private String street2;
    
    private String landmark;



}
