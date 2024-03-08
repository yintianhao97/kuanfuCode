package org.jeecg.modules.link.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import org.jeecg.modules.link.entity.DingtalkUserInfo;
import org.jeecg.modules.link.mapper.DingtalkUserInfoMapper;
import org.jeecg.modules.link.service.IDingtalkUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 钉钉用户信息维护
 * @Author: jeecg-boot
 * @Date:   2024-02-29
 * @Version: V1.0
 */
@Service
public class DingtalkUserInfoServiceImpl extends ServiceImpl<DingtalkUserInfoMapper, DingtalkUserInfo> implements IDingtalkUserInfoService {
    @Autowired
    private DingtalkUserInfoMapper dingtalkUserInfoMapper;
    @Override
    public String getDingUserIdByU8Pk(String pk) {
        List<DingtalkUserInfo> dingtalkUserInfos = dingtalkUserInfoMapper.selectList(new QueryWrapper<DingtalkUserInfo>().eq("u8c_user_pk", pk));
        if (!dingtalkUserInfos.isEmpty()){
            return dingtalkUserInfos.get(0).getDingUserId();
        }else {
            return null;
        }
    }
}
