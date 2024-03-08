package org.jeecg.modules.link.service;

import org.jeecg.modules.link.entity.DocTypeLink;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 单据类型记录
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
public interface IDocTypeLinkService extends IService<DocTypeLink> {
    DocTypeLink selectDocTypeByDingcode(String dingCode);
}
