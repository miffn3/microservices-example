package com.example.service.client.api.dto;

import lombok.Data;
import org.apache.commons.lang.StringUtils;

import javax.validation.constraints.AssertFalse;

@Data
public class ClientDto {

    private String firstName;

    private String lastName;

    @AssertFalse
    public boolean isNothingToUpdate() {
        return StringUtils.isBlank(firstName)
                && StringUtils.isBlank(lastName);
    }
}
