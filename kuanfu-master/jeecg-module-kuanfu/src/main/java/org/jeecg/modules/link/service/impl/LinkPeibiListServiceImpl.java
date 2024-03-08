package org.jeecg.modules.link.service.impl;

import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.link.entity.BdCalbody;
import org.jeecg.modules.link.entity.BdCorp;
import org.jeecg.modules.link.entity.LinkPeibiList;
import org.jeecg.modules.link.mapper.BdCalbodyMapper;
import org.jeecg.modules.link.mapper.BdCorpMapper;
import org.jeecg.modules.link.mapper.LinkDingdingListMapper;
import org.jeecg.modules.link.mapper.LinkPeibiListMapper;
import org.jeecg.modules.link.service.ILinkPeibiListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 配比出库更新公司编码维护
 * @Author: jeecg-boot
 * @Date:   2024-02-23
 * @Version: V1.0
 */
@Service
public class LinkPeibiListServiceImpl extends ServiceImpl<LinkPeibiListMapper, LinkPeibiList> implements ILinkPeibiListService {
    @Autowired
    private LinkPeibiListMapper linkPeibiListMapper;
    @Autowired
    private BdCorpMapper bdCorpMapper;
    @Autowired
    private BdCalbodyMapper bdCalbodyMapper;
    @Override
    public Result<String> saveLink(LinkPeibiList linkPeibiList) {
        BdCorp coprPkByCode = bdCorpMapper.getCoprByCode(linkPeibiList.getCorpCode());
        //判断coprPkByCode是否为空
        if (coprPkByCode == null) {
            return Result.error("公司编码不存在,请验证公司编码是否正确");
        }
        linkPeibiList.setCorpPk(coprPkByCode.getPkCorp());
        linkPeibiList.setGsmc(coprPkByCode.getUnitname());
        List<BdCalbody> bdCalbodies = bdCalbodyMapper.selectByPkCorp(coprPkByCode.getPkCorp());
        //判断bdCalbodies是否为空
        if (bdCalbodies == null || bdCalbodies.size() == 0) {
            return Result.error("库存组织不存在,请创建库存组织");
        }
        linkPeibiList.setChzz(bdCalbodies.get(0).getPkCalbody());

        linkPeibiListMapper.insert(linkPeibiList);
        return Result.OK("保存成功");
    }
}
