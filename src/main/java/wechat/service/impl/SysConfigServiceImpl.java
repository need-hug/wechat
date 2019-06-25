package wechat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wechat.entity.SysConfig;
import wechat.mapper.SysConfigMapper;
import wechat.service.SysConfigService;

/**
 * className: SysConfigServiceImpl
 * author: peishuai.li
 * dateTime: 2019/6/11 10:44
 * version: 1.0
 */
@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;

    @Override
    public SysConfig getSysConfig(String appid) {
        return sysConfigMapper.getSysConfig(appid);
    }

}
