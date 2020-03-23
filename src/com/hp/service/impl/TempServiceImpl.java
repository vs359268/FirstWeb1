package com.hp.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hp.dao.ItempDao;
import com.hp.dao.Temp;
import com.hp.dao.impl.TempDaoImpl;
import com.hp.service.ITempService;

/**
 * @author Administrator
 *
 */
public class TempServiceImpl implements ITempService {

	private ItempDao iTemDao = new TempDaoImpl();
	
	@Override
	public boolean insertTempDate(String id, String date_time, String max_temp, String min_temp) {
		// TODO Auto-generated method stub
		List<Object> data = new ArrayList<>();
		data.add(id);
		data.add(date_time);
		data.add(max_temp);
		data.add(min_temp);
		return this.iTemDao.insertTempDate(data);
	}

	@Override
	public boolean insertTempDateBatch(List<String> data) {
		// TODO Auto-generated method stub
		return this.iTemDao.insertTempDateBatch(data);
	}
	@Override
	public Temp queryTemp() {
		// TODO Auto-generated method stub
		return this.iTemDao.queryTemp();
	}
}
