package org.jeecg.modules.link.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.BdCalbody;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 库存组织 
 * @Author: jeecg-boot
 * @Date:   2024-02-02
 * @Version: V1.0
 */
@DS("U8C")
public interface BdCalbodyMapper extends BaseMapper<BdCalbody> {
    /**
     * 根据公司编码查询仓库主健
     * @param pkCorp
     * @param StorNumber
     * @return
     */
    @Select("SELECT pk_stordoc FROM bd_stordoc WHERE ( isnull ( dr , 0 ) = 0 ) and pk_corp = #{pkCorp} and storcode = #{StorNumber}")
    String selectStorDocPk(String pkCorp,String StorNumber);


    /**
     * 根据单据ID查询单据上的仓库号
     * @param danjvPk
     * @return
     */
    @Select("select vdef2 from ia_bill where cbillid = #{danjvPk}")
    String selectStorNumbet(String danjvPk);

    /**
     * 根据公司编码查询库存组织
     * @param pkCorp
     * @return
     */
    @Select("select pk_calbody , bodycode , bodyname , vnote , area from bd_calbody where pk_corp = #{pkCorp} and ( sealflag is null or sealflag = 'N' )")
    List<BdCalbody> selectByPkCorp(String pkCorp);


}
