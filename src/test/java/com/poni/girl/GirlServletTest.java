package com.poni.girl;

import com.poni.domain.Girl;
import com.poni.repository.GirlRepository;
import com.poni.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 *@author:PONI_CHAN
 *@date:2018/10/4 16:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServletTest {    //对service的测试

    @Autowired
    private GirlService girlService;

    @Test
    public void findoneTest(){
        Girl girl=girlService.findOne(21);
        Assert.assertEquals(new Integer(18),girl.getAge());   //断言
    }

}
