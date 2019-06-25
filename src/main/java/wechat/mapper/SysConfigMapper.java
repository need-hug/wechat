package wechat.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import wechat.entity.SysConfig;

/**
 * className: SysConfigMapper
 * author: peishuai.li
 * dateTime: 2019/6/11 10:47
 * version: 1.0
 */
@Repository
@Mapper
public interface SysConfigMapper {

    @Select("select * from sys_config where wx_appId = #{appid}")
    SysConfig getSysConfig(String appid);

}
