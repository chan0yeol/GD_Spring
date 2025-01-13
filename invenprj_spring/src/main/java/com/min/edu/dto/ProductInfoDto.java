package com.min.edu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductInfoDto {
	
	private String product_id
	,product_name
	,product_maker
	,is_accepted;
	
	private int original_cost
	,product_amount;
	
}
