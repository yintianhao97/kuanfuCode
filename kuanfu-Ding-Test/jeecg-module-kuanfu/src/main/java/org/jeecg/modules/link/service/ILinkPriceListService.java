package org.jeecg.modules.link.service;

import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.link.entity.LinkPriceList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 价目表更新公司编码维护
 * @Author: jeecg-boot
 * @Date:   2024-02-23
 * @Version: V1.0
 */
public interface ILinkPriceListService extends IService<LinkPriceList> {
    Result<String> saveLink(LinkPriceList linkPriceList);
}
