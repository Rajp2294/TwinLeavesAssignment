package com.twinleaves.assignment.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GtinRequestDTO {
	@NotNull
	@NotEmpty
	private String gtin;
	
	@NotNull
	@NotEmpty
	private String productName;
}
