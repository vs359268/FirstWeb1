package com.hp.service;

import java.util.List;

import com.hp.dao.Temp;

/**
 * @author Administrator
 *
 */
public interface ITempService {
	
	public boolean insertTempDate(String id, String date_time, String max_temp, String min_temp);
	
	public boolean insertTempDateBatch(List<String> data);

	public Temp queryTemp();

}
