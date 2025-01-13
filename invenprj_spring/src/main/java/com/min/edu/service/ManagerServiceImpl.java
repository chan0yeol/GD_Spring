package com.min.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.min.edu.dto.ProductInfoDto;
import com.min.edu.dto.StockDto;
import com.min.edu.repository.IManagerDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ManagerServiceImpl implements IManagerService{
	
	private IManagerDao dao;
	
	@Override
	public List<ProductInfoDto> selectProductList() {
		return dao.selectProductList();
	}

	@Override
	public int updateProductRequest(ProductInfoDto dto) {
		return dao.updateProductRequest(dto);
	}

	@Override
	public List<StockDto> selectStockInList() {
		return dao.selectStockInList();
	}

	@Override
	public int updateStockInRequest(StockDto dto) {
		return dao.updateStockInRequest(dto);
	}

	@Override
	public List<StockDto> selectStockOutList() {
		return dao.selectStockOutList();
	}

	@Override
	public int updateStockOutRequest(StockDto dto) {
		return dao.updateStockOutRequest(dto);
	}

	@Override
	public StockDto findByStockId(String id) {
		return dao.findByStockId(id);
	}

}
