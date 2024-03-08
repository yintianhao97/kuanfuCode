package org.jeecg.modules.link.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.DocTypeLink;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 单据类型记录
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@DS("EWAY")
public interface DocTypeLinkMapper extends BaseMapper<DocTypeLink> {
    @Select("select * from doc_type_link where dingcode = #{dingCode}")
    DocTypeLink selectDocTypeByDingcode(String dingCode);
}
