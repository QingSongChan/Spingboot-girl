package com.poni.repository;

import com.poni.domain.Girl;
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
public interface GirlRepository extends JpaRepository<Girl,Integer> {   //Jpa里有封装好的增删查改方法

//       @Query(value="select * from springboot-girl",nativeQuery = true)
//       Girl findAll(Integer id);
     public List<Girl> findByAge(Integer age);

     public List<Girl> findByCupSize(String cupSize);
}
