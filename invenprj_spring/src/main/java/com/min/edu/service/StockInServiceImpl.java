package com.min.edu.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.min.edu.dto.StockDto;
import com.min.edu.repository.IStockInDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class StockInServiceImpl implements IStockInService {
	
	private final IStockInDao inDao;
	
	@Override
	public List<StockDto> selectAll() {
		return inDao.selectAll();
	}

	@Override
	public List<StockDto> selectAll(int empno) {
		return inDao.selectAll(empno);
	}

	@Override
	public int insert(StockDto dto) {
		return inDao.insert(dto);
	}

	@Override
	public StockDto stockInDetail(int id) {
		// TODO Auto-generated method stub
		return inDao.stockInDetail(id);
	}

	@Override
	public StockDto selectById(int id) {
		return inDao.selectById(id);
	}

	@Override
	public int updateStockInAmount(StockDto dto) {
		return inDao.updateStockInAmount(dto);
	}

	@Override
	public List<StockDto> selectDateRange(Map<String, Object> map) {
		return inDao.selectDateRange(map);
	}

	@Override
	public List<StockDto> selectStockInByMgr(int i) {
		return inDao.selectStockInByMgr(i);
	}

}
