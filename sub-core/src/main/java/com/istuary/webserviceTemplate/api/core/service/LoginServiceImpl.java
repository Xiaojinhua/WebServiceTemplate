package com.istuary.webserviceTemplate.api.core.service;

import com.istuary.webserviceTemplate.api.common.entity.UserInfo;
import com.istuary.webserviceTemplate.api.common.helper.HttpHelper;
import com.istuary.webserviceTemplate.api.dal.custom.UserCustomMapper;
import com.istuary.webserviceTemplate.api.dal.generated.DemoDOCriteria;
import com.istuary.webserviceTemplate.api.dal.generated.UserDO;
import com.istuary.webserviceTemplate.api.dal.generated.UserDOCriteria;
import com.istuary.webserviceTemplate.api.dal.generated.UserDOMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhenhua.li on 16/11/2.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    HttpHelper httpHelper;
    @Autowired
    UserCustomMapper userCustomMapper;
    @Autowired
    UserDOMapper userDOMapper;

    @Override
    public String getPwdByName(String name) {
        UserDOCriteria userDOCriteria = new UserDOCriteria();
        UserDOCriteria.Criteria criteria = userDOCriteria.createCriteria();
        criteria.andNameEqualTo(name);
        userDOCriteria.or(criteria);
        List<UserDO> userDO = userDOMapper.selectByExample(userDOCriteria);
        if(userDO == null && userDO.size() > 0){
            return null;
        }
        return userDO.get(0).getPassword();
//        List<UserInfo> users = new ArrayList<>();
//        String userinfos = configStore.get(ConfigConstant.USER_INFO);
//        try {
//            if (!Strings.isNullOrEmpty(userinfos)) {
//                for (String info : userinfos.split(",")) {
//                    String[] infos = info.split(":");
//                    users.add(new UserInfo(infos[0], infos[1]));
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error(e.getMessage());
//        }
//
//        for (UserInfo userInfo : users) {
//            if (userInfo.getName().equals(name)) {
//                return userInfo.getPassword();
//            }
//        }
    }

    @Override
    public UserInfo getUserByName(String name) {
        UserDO userDO = userCustomMapper.getByUserName(name);
        if(userDO == null){
            return null;
        }
        
        UserInfo userInfo = new UserInfo(userDO.getName(),userDO.getPassword());

        return userInfo;
    }
    @Override
    public UserInfo getUserById(int id){
        UserDO userDO = userCustomMapper.getByUserId(id);
        if(userDO == null){
            return null;
        }
    
        UserInfo userInfo = new UserInfo(userDO.getName(),userDO.getPassword());
    
        return userInfo;
    }

}