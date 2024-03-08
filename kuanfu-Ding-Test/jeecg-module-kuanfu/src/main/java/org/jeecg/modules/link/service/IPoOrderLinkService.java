package org.jeecg.modules.link.service;

import org.jeecg.modules.link.entity.PoOrderLink;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 采购订单同步记录
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
public interface IPoOrderLinkService extends IService<PoOrderLink> {

    int syncSave(PoOrderLink poOrderLink);

    int shenheshibai(String id);

    int shenhe(String id);

    int delByErpId(String erpId);
}
