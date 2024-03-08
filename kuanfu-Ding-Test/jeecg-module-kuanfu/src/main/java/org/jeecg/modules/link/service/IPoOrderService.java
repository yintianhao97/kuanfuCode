package org.jeecg.modules.link.service;

import org.jeecg.modules.link.entity.PoOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 采购订单主表
 * @Author: jeecg-boot
 * @Date:   2024-02-26
 * @Version: V1.0
 */
public interface IPoOrderService extends IService<PoOrder> {
    List<PoOrder> selectUnsync(String corp, String startDate, String endDate);


    List<PoOrder> dingSync(String corp,String startDate,String endDate);
}
