package com.twinleaves.assignment.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BatchRequestDTO {
	@NotNull
    @DecimalMin(value = "0.01", message = "MRP must be greater than 0")
	private BigDecimal mrp;
	@NotNull
    @DecimalMin(value = "0.01", message = "Selling price must be greater than 0")
	private BigDecimal sp;
	@NotNull
    @DecimalMin(value = "0.01", message = "Purchase price must be greater than 0")
	private BigDecimal purchasePrice;
	
	private int availableQuantity;
	
	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate inwardedOn;
	
	@NotNull
	@NotEmpty
	private String productName;
}
