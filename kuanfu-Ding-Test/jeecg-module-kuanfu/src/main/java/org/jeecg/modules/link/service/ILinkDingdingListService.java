package org.jeecg.modules.link.service;

import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.link.entity.LinkDingdingList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 配比出库更新公司编码维护
 * @Author: jeecg-boot
 * @Date:   2024-02-26
 * @Version: V1.0
 */
public interface ILinkDingdingListService extends IService<LinkDingdingList> {

    Result<String> saveLink(LinkDingdingList linkDingdingList);
}
