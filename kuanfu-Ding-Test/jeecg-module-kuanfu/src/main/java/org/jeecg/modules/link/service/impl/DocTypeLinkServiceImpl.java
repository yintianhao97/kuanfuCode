package org.jeecg.modules.link.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.jeecg.modules.link.entity.DocTypeLink;
import org.jeecg.modules.link.mapper.DocTypeLinkMapper;
import org.jeecg.modules.link.service.IDocTypeLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 单据类型记录
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@Service
public class DocTypeLinkServiceImpl extends ServiceImpl<DocTypeLinkMapper, DocTypeLink> implements IDocTypeLinkService {
    @Autowired
    private DocTypeLinkMapper docTypeLinkMapper;
    @Override
    public DocTypeLink selectDocTypeByDingcode(String dingCode) {
        return docTypeLinkMapper.selectDocTypeByDingcode(dingCode);
    }
}
