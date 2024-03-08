package org.jeecg.modules.link.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.BdInvmandoc;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 存货档案
 * @Author: jeecg-boot
 * @Date:   2024-01-31
 * @Version: V1.0
 */
@DS("U8C")
public interface BdInvmandocMapper extends BaseMapper<BdInvmandoc> {

    @Select("select distinct bd_invmandoc.*,bd_invbasdoc.invcode,bd_invbasdoc.pk_measdoc\n" +
            "from bd_invmandoc\n" +
            "         left outer join bd_invbasdoc on bd_invmandoc.pk_invbasdoc = bd_invbasdoc.pk_invbasdoc\n" +
            "where (bd_invmandoc.pk_corp = '0001' or bd_invmandoc.pk_corp = #{pkCorp})\n" +
            "  and (isnull(bd_invmandoc.dr, 0) = 0)\n" +
            "  and bd_invmandoc.pk_corp = #{pkCorp}")
    List<BdInvmandoc> selectByPkCorp(String pkCorp);

}
