package com.min.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.min.edu.dto.ProductInfoDto;
import com.min.edu.repository.IProductDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService{
	private final IProductDao productDao;
	
	@Override
	public int product_insert(ProductInfoDto dao) {
		return productDao.product_insert(dao);
	}

	@Override
	public int product_insert2(ProductInfoDto dao) {
		return productDao.product_insert2(dao);
	}

	@Override
	public List<ProductInfoDto> product_select() {
		return productDao.product_select();
	}

	@Override
	public ProductInfoDto product_select2(String string) {
		return productDao.product_select2(string);
	}

	@Override
	public List<ProductInfoDto> product_select3(String string) {
		return productDao.product_select3(string);
	}

	@Override
	public List<ProductInfoDto> product_select4(String string) {
		return productDao.product_select4(string);
	}

}
