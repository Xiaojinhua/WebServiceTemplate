package com.istuary.webserviceTemplate.api.dal.custom;

import com.istuary.webserviceTemplate.api.dal.generated.UserDO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xiaojinhua on 17/9/4.
 */
public class UserCustomMapperTest extends com.istuary.webserviceTemplate.api.dal.custom.BaseTest
{
    @Autowired
    private UserCustomMapper userCustomMapper;
    @Test
    public void getByUserId() throws Exception
    {
        UserDO userDO = userCustomMapper.getByUserId(1);
        assertEquals("111",userDO.getName());
    }
    
    @Test
    public void getByUserName() throws Exception
    {
        UserDO userDO=userCustomMapper.getByUserName("111");
        assertEquals("222",userDO.getPassword());
    }
    
    @Test
    public void getAllUsers() throws Exception
    {
        List<UserDO> userDOList = userCustomMapper.getAllUsers();
        assertEquals(4,userDOList.size());
    }
    
    @Test
    public void insert() throws Exception
    {
        UserDO userDO = new UserDO();
        userDO.setName("Jack");
        userDO.setPassword("32323");
        userDO.setDesc("kdfsl");
        userDO.setCreatedDate(new Date());
        
        int result = userCustomMapper.insert(userDO);
        assertEquals(1,result);
    }
    
    @Test
    public void update() throws Exception
    {
        UserDO userDO=userCustomMapper.getByUserName("Jack");
        userDO.setPassword("Jack123");
        
        int result = userCustomMapper.update(userDO);
        assertEquals(1,result);
    }
    
    @Test
    public void delete() throws Exception
    {
        int result = userCustomMapper.delete(3);
        assertEquals(1,result);
    }
    
}