package org.jeecg.modules.link.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.link.entity.BdCalbody;
import org.jeecg.modules.link.entity.BdCorp;
import org.jeecg.modules.link.entity.LinkDingdingList;
import org.jeecg.modules.link.mapper.BdCalbodyMapper;
import org.jeecg.modules.link.mapper.BdCorpMapper;
import org.jeecg.modules.link.mapper.LinkDingdingListMapper;
import org.jeecg.modules.link.mapper.LinkPriceListMapper;
import org.jeecg.modules.link.service.ILinkDingdingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 配比出库更新公司编码维护
 * @Author: jeecg-boot
 * @Date:   2024-02-26
 * @Version: V1.0
 */
@Service
public class LinkDingdingListServiceImpl extends ServiceImpl<LinkDingdingListMapper, LinkDingdingList> implements ILinkDingdingListService {
    @Autowired
    private LinkDingdingListMapper linkDingdingListMapper;
    @Autowired
    private BdCorpMapper bdCorpMapper;
    @Autowired
    private BdCalbodyMapper bdCalbodyMapper;
    @Override
    public Result<String> saveLink(LinkDingdingList linkDingdingList) {
        List<LinkDingdingList> corpCode = linkDingdingListMapper.selectList(new QueryWrapper<LinkDingdingList>().eq("corp_code", linkDingdingList.getCorpCode()));
        if (corpCode.size() > 0) {
            return Result.error("公司编码已存在,请勿重复添加");
        }

        BdCorp coprPkByCode = bdCorpMapper.getCoprByCode(linkDingdingList.getCorpCode());
        //判断coprPkByCode是否为空
        if (coprPkByCode == null) {
            return Result.error("公司编码不存在,请验证公司编码是否正确");
        }
        linkDingdingList.setCorpPk(coprPkByCode.getPkCorp());
        linkDingdingList.setGsmc(coprPkByCode.getUnitname());
        List<BdCalbody> bdCalbodies = bdCalbodyMapper.selectByPkCorp(coprPkByCode.getPkCorp());
        //判断bdCalbodies是否为空
        if (bdCalbodies == null || bdCalbodies.size() == 0) {
            return Result.error("库存组织不存在,请创建库存组织");
        }
        linkDingdingList.setChzz(bdCalbodies.get(0).getPkCalbody());

        linkDingdingListMapper.insert(linkDingdingList);
        return Result.OK("保存成功");
    }
}
