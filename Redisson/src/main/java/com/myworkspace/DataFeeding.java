package com.myworkspace;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myworkspace.model.MasterSurveyType;
import com.myworkspace.repository.SurveyTypeRepository;

@Component
public class DataFeeding {

	private RedissonClient redisson;
	private RMap<Integer, MasterSurveyType> mSurveyType;

	@Autowired
	SurveyTypeRepository repo;

//	@Autowired
//	RedissonClient redissonClient;

//	public DataFeeding(RedissonClient redissonClient) {
//		this.redissonClient = redissonClient;
//		this.mSurveyType = redissonClient.getMap("mSurveyType");
//	}

	public void mainHandler() {
		try {

			Config config = new Config();
			config.useSingleServer().setAddress("redis://" + "localhost:6379");
			redisson = Redisson.create(config);
			setSurveyType();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void mainHandler2() {
		try {

			Config config = new Config();
			config.useSingleServer().setAddress("redis://" + "localhost:6379");
			redisson = Redisson.create(config);
			getSurveyList();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<MasterSurveyType> setSurveyType() {
		try {
			List<MasterSurveyType> list = repo.findAll();
			System.out.println("Data Fetched");
			redisGet(list);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String redisGet(List<MasterSurveyType> list) {
		RMap<Integer, MasterSurveyType> mStates = redisson.getMap("mSurveyType");
		for (int i = 0; i < list.size(); i++) {
			MasterSurveyType temp = list.get(i);
			mStates.put(temp.getSurveyTypeId(), temp);
			System.out.println("Redis set");
		}
		return "SuccessfullyAdded!";
	}

	public String[] getSurveyList() {
		String[] surveyTypeList = null;
		try {
			if(mSurveyType != null && mSurveyType.size() >=0) {
				
			Integer[] temp = (Integer[]) mSurveyType.keySet().toArray();
			ArrayList<Integer> keys = new ArrayList<Integer>();
			for (int i = 0; i < temp.length; i++)
				keys.add((Integer) temp[i]);
			surveyTypeList = new String[keys.size()];
			int n=0;
			for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
				Integer key = (Integer) iterator.next();
				MasterSurveyType mstrSurveyType = mSurveyType.get(key);
				surveyTypeList[n] = mstrSurveyType.getSurveyTypeEn(); 
				n++;
			}
			
			for (int i = 0; i < surveyTypeList.length; i++) {
				System.out.println("SurveyTypeList: " + surveyTypeList[i]);
			}
			return surveyTypeList;
			
		}
			else {
				System.out.println("mSurveyType data is null");
				return null;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
