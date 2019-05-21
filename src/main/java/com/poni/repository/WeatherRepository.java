package com.poni.repository;

import com.poni.domain.Girl;
import com.poni.domain.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/*
 *@author:PONI_CHAN
 *@date:2018/9/20 22:52
 */
@Transactional
@Repository
public interface WeatherRepository extends JpaRepository<WeatherInfo,String> {   //Jpa里有封装好的增删查改方法

}
