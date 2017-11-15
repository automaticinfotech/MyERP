package com.aits.myerp.util;

import java.util.Calendar;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class CodeGenratorImpl implements CodeGenrator{

	@Override
	public String getCurrentYear() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		String yearWithPattern = year+"/";
		return yearWithPattern;
	}

	@Override
	public int getRandomNumber(int maxValue,int MinValue) {
		int  randomNumber;
		Random rand = new Random();
		randomNumber = rand.nextInt(maxValue) + MinValue;
		return randomNumber;
	}

}
