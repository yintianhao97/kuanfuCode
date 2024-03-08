package org.jeecg.modules.link.service;

import org.jeecg.modules.link.entity.ArapDjzb;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 付款单副表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
public interface IArapDjzbService extends IService<ArapDjzb> {
    List<ArapDjzb> getUnsyDoc(String corp, String qiantian, String houtian);
}
