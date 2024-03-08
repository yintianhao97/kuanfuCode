package org.jeecg.modules.link.service;

import org.jeecg.modules.link.entity.FukuanLink;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.link.entity.PoOrderLink;

/**
 * @Description: 付款单同步
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
public interface IFukuanLinkService extends IService<FukuanLink> {

    int shenheshibai(String id);

    int shenhe(String id);

    int delByErpId(String erpId);
}
