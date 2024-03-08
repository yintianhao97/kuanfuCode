package org.jeecg.modules.link.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.link.entity.BdInvmandoc;
import org.jeecg.modules.link.vo.BankVo;
import org.jeecg.modules.link.vo.BdInvVo;

import java.util.List;

/**
 * @Description: 存货档案
 * @Author: jeecg-boot
 * @Date:   2024-01-31
 * @Version: V1.0
 */
@DS("U8C")
public interface PkTranslateCodeMapper {
    /*
    业务流程
     */
    @Select("SELECT businame FROM bd_busitype where pk_busitype = #{pk_busitype}")
    String yewuliucheng(String pk_busitype);
    /*
    采购组织
     */
    @Select("select name from bd_purorg where dr = '0' and pk_purorg = #{pk_purorg}")
    String caigouzuzhi(String pk_purorg);
    /*
    * 供货商档案
    * */
    @Select("select custname from bd_cubasdoc  where pk_cubasdoc = #{pk_cubasdoc}")
    String gonghuoshang(String pk_cubasdoc);

    /*人员档案
    * */
    @Select("select psnname from bd_psndoc where pk_psndoc = #{pk_psndoc}")
    String renyuandangan(String pk_psndoc);

    @Select("select vdef1 from bd_psnbasdoc where pk_psnbasdoc in (select pk_psnbasdoc from bd_psndoc where pk_psndoc = #{pk_psndoc})")
    String renyuandanganDingCode(String pk_psndoc);

    @Select("select deptname from bd_deptdoc where pk_deptdoc =#{pk_deptdoc}")
    String bumendangan(String pk_deptdoc);

    /**
     * 项目根据订单号获取项目名称
     * @param corderid
     * @return
     */
    @Select("select jobname from bd_jobbasfil where pk_jobbasfil in (select pk_jobbasfil from bd_jobmngfil where pk_jobmngfil = (SELECT TOP 1\n" +
            "\tcprojectid \n" +
            "FROM\n" +
            "\tpo_order_b\n" +
            "where corderid = #{corderid}) )")
    String xiangmu(String corderid);

    /**
     * 工具项目主键获取项目名称
     * @param pk_jobbasfil
     * @return
     */
    @Select("select jobname from bd_jobbasfil where pk_jobbasfil = #{pk_jobbasfil}")
    String xiangmuFukuan(String pk_jobbasfil);

    @Select("select  cpricetypeid from prm_pricetype WHERE pk_corp = #{pkCopr} and cpricetypecode = '01' and dr = '0'")
    String shiyongjiagexiang(String pkCopr);


    @Select("SELECT pk_currtype FROM bd_currtype WHERE isnull ( dr , 0 ) = 0 and currtypecode = 'CNY'")
    String getCNY();

    @Select("select currtypename from bd_currtype where pk_currtype = #{pk_currtype}")
    String bizhong(String pk_currtype);

    /**
     * 根据计量单位主键获取计量单位名称
     * @param pk_measdoc
     * @return
     */
    @Select("select shortname from bd_measdoc where pk_measdoc = #{pk_measdoc}")
    String jiliangdanwei(String pk_measdoc);

    /**
     * 根据存货档案主键查询存货编码
     * @param pk_invbasdoc
     * @return
     */
    @Select("select invcode from bd_invbasdoc where pk_invbasdoc = #{pk_invbasdoc}")
    String chunhuodangan(String pk_invbasdoc);

    /**
     * 根据存货档案主键查询存货档案
     * @param pk_invbasdoc
     * @return
     */
    @Select("select a.invcode,a.invname,b.measname as 'pk_measdoc' from bd_invbasdoc a \n" +
            "LEFT JOIN bd_measdoc b on a.pk_measdoc = b.pk_measdoc\n" +
            "where a.pk_invbasdoc = #{pk_invbasdoc}")
    BdInvVo chunhuodanganVo(String pk_invbasdoc);

    /**
     * 结算方式
     * @param pk_balatype
     * @param pk_corp
     * @return
     */
    @Select("SELECT balanname FROM bd_balatype WHERE ( isnull ( dr , 0 ) = 0 ) and ( pk_corp = #{pk_corp} or pk_corp = '0001' ) and pk_balatype = #{pk_balatype}")
    String jiesuanfangshi(String pk_balatype,String pk_corp);

    /**
     * 根据单据类型查询单据类型名称
     * @param djlxoid
     * @return
     */
    @Select("select djlxmc from arap_djlx where djlxoid = #{djlxoid}")
    String danjvleixing(String djlxoid);

    /**
     * 根据公司主键获取公司名称
     * @return
     */
    @Select("SELECT unitname FROM bd_corp WHERE isseal = 'N' and pk_corp = #{code}")
    String gongsi(String code);

    /**
     * 根据银行主键获取 付款信息
     * @return
     */
    @Select("SELECT bd_banktype.banktypename  AS banktypename,\n" +
            "       bd_bankaccbas.accountcode AS accountcode,\n" +
            "       bd_bankaccbas.accountname AS accountname,\n" +
            "       bd_bankaccbas.account     AS account,\n" +
            "       bd_cubasdoc.custcode      AS custcode,\n" +
            "       bd_cubasdoc.custname      AS custname\n" +
            "FROM bd_corp\n" +
            "         RIGHT OUTER JOIN bd_cubasdoc ON bd_corp.pk_corp = bd_cubasdoc.pk_corp\n" +
            "         INNER JOIN bd_custbank ON bd_cubasdoc.pk_cubasdoc = bd_custbank.pk_cubasdoc\n" +
            "    AND bd_cubasdoc.custprop = 0\n" +
            "         INNER JOIN bd_bankaccbas ON bd_custbank.pk_accbank = bd_bankaccbas.pk_bankaccbas\n" +
            "    AND bd_bankaccbas.accclass = 1\n" +
            "         LEFT OUTER JOIN bd_banktype ON bd_banktype.pk_banktype = bd_bankaccbas.pk_banktype\n" +
            "WHERE bd_cubasdoc.custprop = 0\n" +
            "  and bd_bankaccbas.pk_bankaccbas = #{pk_bankaccbas}")
    BankVo yinhangzhanghu(String pk_bankaccbas);


    @Select("SELECT cuserid\n" +
            "FROM sm_user\n" +
            "WHERE pk_corp = '0001'\n" +
            "and user_code = #{user_code}")
    String zhanghaoxinxi(String user_code);


    @Select("SELECT user_name\n" +
            "FROM sm_user\n" +
            "WHERE pk_corp = '0001'\n" +
            "and user_code = #{user_code}")
    String zhanghaoxinxiName(String user_code);
}
