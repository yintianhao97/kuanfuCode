package org.jeecg.modules.link.service;

import org.jeecg.modules.link.entity.PoOrderB;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 采购订单表体
 * @Author: jeecg-boot
 * @Date:   2024-02-26
 * @Version: V1.0
 */
public interface IPoOrderBService extends IService<PoOrderB> {
    List<PoOrderB> selectByCorderId(String corderid);
}
