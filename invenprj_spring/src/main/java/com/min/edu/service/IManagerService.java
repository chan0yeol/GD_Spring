package com.min.edu.service;

import java.util.List;

import com.min.edu.dto.ProductInfoDto;
import com.min.edu.dto.StockDto;

public interface IManagerService {
	public List<ProductInfoDto> selectProductList();

	public int updateProductRequest(ProductInfoDto dto);

	public List<StockDto> selectStockInList();

	public int updateStockInRequest(StockDto dto);

	public List<StockDto> selectStockOutList();

	public int updateStockOutRequest(StockDto dto);
	
	public StockDto findByStockId(String id);
}
