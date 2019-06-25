package wechat.service;

import wechat.entity.SysConfig;

/** 系统配置服务
 * className: SysConfigService
 * author: peishuai.li
 * dateTime: 2019/6/11 10:44
 * version: 1.0
 */
public interface SysConfigService {

    /**
     * 根据appid获取微信配置
     * @param appid 微信appid
     * @return
     */
    SysConfig getSysConfig(String appid);

}
