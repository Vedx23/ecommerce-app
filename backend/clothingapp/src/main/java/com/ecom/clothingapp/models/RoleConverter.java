package com.ecom.clothingapp.models;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, String> {

    @Override
    public String convertToDatabaseColumn(Role attribute) {
        return attribute != null ? attribute.getAuthority() : null;
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        if(dbData == null){
            return null;
        }
        for (Role r: Role.values()){
            if(r.getAuthority().equals(dbData)){
                return r;
            }
        }
        throw new IllegalArgumentException("Unknown role");
    }
}
