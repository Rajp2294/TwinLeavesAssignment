package com.twinleaves.assignment.dto.request;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductRequestDTO {
	@Nonnull
	@NotEmpty
    private String productName;
}
