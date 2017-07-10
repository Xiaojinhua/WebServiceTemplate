package com.istuary.webserviceTemplate.api.dal.custom;

import com.istuary.webserviceTemplate.api.dal.generated.DemoDO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by lizhenhua on 2017/7/8.
 */
public interface DemoCustomMapper {

    @Select("select * from demo inner join user on demo.user_id = user.id where user.id = #{id}")
    List<DemoDO> getCustomDemoByUserId(int id);

}
