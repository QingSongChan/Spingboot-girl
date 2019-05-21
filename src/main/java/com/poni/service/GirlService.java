package com.poni.service;

import com.poni.domain.Girl;
import com.poni.enums.ResultEnum;
import com.poni.exception.GirlException;
import com.poni.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 *@author:PONI_CHAN
 *@date:2018/9/28 22:01
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public void InsertTwoUser(){
        Girl girlA=new Girl();
        girlA.setAge(24);
        girlA.setCupSize("D");
        girlA.setHeight(163);
        girlRepository.save(girlA);

        Girl girlB=new Girl();
        girlB.setAge(25);
        girlB.setCupSize("B");
        girlB.setHeight(155);
        girlRepository.save(girlB);

    }

    public void getAge(Integer id) throws Exception{
        Girl girl= girlRepository.findById(id).get();
        Integer age=girl.getAge();
        if(age<12){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }
        else if (age>=12 && age<18){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        else if(age>=18 &&age<30){
            throw new GirlException(ResultEnum.SOCIAL_SCHOOL);
        }
    }

    public Girl findOne(Integer id){
        return girlRepository.findById(id).get();
    }

}
