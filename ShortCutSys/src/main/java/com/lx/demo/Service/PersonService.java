package com.lx.demo.Service;

import com.lx.demo.Bean.Person;
import com.lx.demo.Dao.PersonMapper;
import com.lx.demo.Unitl.MyAutomaticLog;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;


@Service
public class PersonService {

    private static Logger log= Logger.getLogger(PersonService.class);

    @Autowired
    private PersonMapper personMapper;

    public Person getOne(){
       Person person= personMapper.selectByPrimaryKey(1);
        return person;
    }

    @Transactional
    @MyAutomaticLog("insert一个Person")
    public int Insert(Person person){
        int result =-1;
        try {

          result=  personMapper.insert( person);
          //log.info("新增成功："+person.getName()+"  "+person.getAge());
            int i=1/0;

        }catch (Exception e){

         //   log.warn("新增用户失败："+e.toString());
            throw e;
        }

    return result;
    }
}

