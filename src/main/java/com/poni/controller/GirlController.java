package com.poni.controller;

import com.poni.domain.Girl;
import com.poni.domain.Result;
import com.poni.domain.WeatherInfo;
import com.poni.repository.GirlRepository;
import com.poni.repository.WeatherRepository;
import com.poni.service.GirlService;
import com.poni.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*
 *@author:PONI_CHAN
 *@date:2018/9/20 22:48
 */
@RestController
public class GirlController {

    private final static Logger logger= LoggerFactory.getLogger(GirlController.class);


    @Autowired   //自动配置
    private GirlRepository girlRepository;   //Repository是知识库（包），Properties是属性

    @Autowired
    private WeatherRepository weatherRepository;

    @Autowired
    private GirlService girlService;    //事务管理
    /*
     *查询所有女孩资料
     * @return
     */
    @GetMapping(value = "/girl")
    public List<Girl> girlList(){
        logger.info("girllist");
         return girlRepository.findAll();
    }

    /*
     * 添加一个女孩
     * @param cupSize
     * @param age
     * @param height
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){    //不用@RequestParam的方式能够减少添加属性的重复代码，直接用对象来调用
       if(bindingResult.hasErrors()){
//           return null;
           return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());  //将错误信息打印出来
       }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setHeight(girl.getHeight());

        return ResultUtil.success(girlRepository.save(girl));     //小驼峰命名法
    }

    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    @PutMapping(value = "/girls/{id}")
    public Girl girlPutOne(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age,
                           @RequestParam("height") Integer height){
        Girl girl=new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setHeight(height);

        return  girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDeleteOne(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @GetMapping(value = "/girls/cupSize/{cupSize}")
    public List<Girl> girlFindByCupSize(@PathVariable("cupSize") String cupSize){    //注意类型一致，你要用cupSize来找出一堆数据，要用
                                                                                     //List<Girl>来声明，跟前面只找出一个返回Girl不一样
        return girlRepository.findByCupSize(cupSize);
    }

    @PostMapping(value = "/girls/Insert/InsertTwoGirl")
     public void girlInsertTwo(){
        girlService.InsertTwoUser();
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
       girlService.getAge(id);
    }

}
