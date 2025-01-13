package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.min.edu.dto.ProductInfoDto;
import com.min.edu.dto.StockDto;
import com.min.edu.repository.IStockOutDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockOutServiceImpl implements IStockOutService {
	private final IStockOutDao outDao;

	@Override
	public int insertStockOut(StockDto dto) {
		return outDao.insertStockOut(dto);
	}

	@Override
	public List<StockDto> selectStockOutAll() {
		return outDao.selectStockOutAll();
	}

	@Override
	public List<StockDto> selectStockOutByMgr(int mgr) {
		return outDao.selectStockOutByMgr(mgr);
	}

	@Override
	public List<StockDto> selectOutDateRange(Map<String, Object> map) {
		return outDao.selectOutDateRange(map);
	}

	@Override
	public int updateStockOutAmount(StockDto dto) {
		return outDao.updateStockOutAmount(dto);
	}

	@Override
	public int updateStockOutDelivery(StockDto dto) {
		return outDao.updateStockOutDelivery(dto);
	}

	@Override
	public List<StockDto> selectStockInventory() {
		return outDao.selectStockInventory();
	}

	@Override
	public List<ProductInfoDto> selectStockAmount() {
		return outDao.selectStockAmount();
	}

	@Override
	public List<ProductInfoDto> selectStockSales() {
		return outDao.selectStockSales();
	}

	@Override
	public StockDto selectStockOutDetail(int stock_id) {
		return outDao.selectStockOutDetail(stock_id);
	} 
	
	
}
