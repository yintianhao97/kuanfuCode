package org.jeecg.modules.link.service.impl;

import org.checkerframework.checker.units.qual.A;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.link.entity.BdCalbody;
import org.jeecg.modules.link.entity.BdCorp;
import org.jeecg.modules.link.entity.LinkPriceList;
import org.jeecg.modules.link.mapper.BdCalbodyMapper;
import org.jeecg.modules.link.mapper.BdCorpMapper;
import org.jeecg.modules.link.mapper.LinkPriceListMapper;
import org.jeecg.modules.link.service.ILinkPriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 价目表更新公司编码维护
 * @Author: jeecg-boot
 * @Date:   2024-02-23
 * @Version: V1.0
 */
@Service
public class LinkPriceListServiceImpl extends ServiceImpl<LinkPriceListMapper, LinkPriceList> implements ILinkPriceListService {
    @Autowired
    private LinkPriceListMapper linkPriceListMapper;
    @Autowired
    private BdCorpMapper bdCorpMapper;
    @Autowired
    private BdCalbodyMapper bdCalbodyMapper;

    @Override
    public Result<String> saveLink(LinkPriceList linkPriceList) {
        BdCorp coprPkByCode = bdCorpMapper.getCoprByCode(linkPriceList.getCorpCode());
        //判断coprPkByCode是否为空
        if (coprPkByCode == null) {
            return Result.error("公司编码不存在,请验证公司编码是否正确");
        }
        linkPriceList.setCorpPk(coprPkByCode.getPkCorp());
        linkPriceList.setGsmc(coprPkByCode.getUnitname());
        List<BdCalbody> bdCalbodies = bdCalbodyMapper.selectByPkCorp(coprPkByCode.getPkCorp());
        //判断bdCalbodies是否为空
        if (bdCalbodies == null || bdCalbodies.size() == 0) {
            return Result.error("库存组织不存在,请创建库存组织");
        }
        linkPriceList.setChzz(bdCalbodies.get(0).getPkCalbody());

        linkPriceListMapper.insert(linkPriceList);
        return Result.OK("保存成功");
    }
}
