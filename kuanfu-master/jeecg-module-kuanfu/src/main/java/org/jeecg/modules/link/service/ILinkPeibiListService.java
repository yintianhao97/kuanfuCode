package org.jeecg.modules.link.service;

import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.link.entity.LinkPeibiList;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.link.mapper.BdCalbodyMapper;
import org.jeecg.modules.link.mapper.BdCorpMapper;
import org.jeecg.modules.link.mapper.LinkDingdingListMapper;
import org.jeecg.modules.link.mapper.LinkPeibiListMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 配比出库更新公司编码维护
 * @Author: jeecg-boot
 * @Date:   2024-02-23
 * @Version: V1.0
 */
public interface ILinkPeibiListService extends IService<LinkPeibiList> {



    Result<String> saveLink(LinkPeibiList linkPeibiList);
}
