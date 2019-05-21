package com.poni.controller;

import com.poni.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController  //通过web访问的话必须加上此标签

@RequestMapping("/Hello")
public class HelloController {

   @Autowired
   private GirlProperties girlProperties;


//    @RequestMapping(value = {"/say"},method = RequestMethod.GET) //与GetMapping一样的效果
    @GetMapping(value = "/say")
    public String say(@RequestParam(value="id",required = false,defaultValue = "0") Integer myid){
        return "id是"+myid;

//        return girlProperties.getCupSize();
    }
}
