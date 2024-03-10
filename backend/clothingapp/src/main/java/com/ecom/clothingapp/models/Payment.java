package com.ecom.clothingapp.models;

import java.time.LocalDate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@AttributeOverride(name = "id", column = @Column(name = "payment_id"))
public class Payment extends Base{

    private LocalDate time;

    private Double totalAmountPaid;

}
