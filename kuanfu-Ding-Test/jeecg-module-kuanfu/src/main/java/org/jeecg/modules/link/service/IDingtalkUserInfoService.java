package org.jeecg.modules.link.service;

import org.jeecg.modules.link.entity.DingtalkUserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 钉钉用户信息维护
 * @Author: jeecg-boot
 * @Date:   2024-02-29
 * @Version: V1.0
 */
public interface IDingtalkUserInfoService extends IService<DingtalkUserInfo> {
    /**
     * 根据账号pk获取DingtalkUserId
     * @param pk
     * @return
     */
    String getDingUserIdByU8Pk(String pk);
}
