package org.jeecg.modules.link.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Description: 存货档案
 * @Author: jeecg-boot
 * @Date:   2024-01-31
 * @Version: V1.0
 */
@Data
@TableName("bd_invmandoc")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="bd_invmandoc对象", description="存货档案")
public class BdInvmandoc {
    
	/**abctype*/
	@Excel(name = "abctype", width = 15)
    @ApiModelProperty(value = "abctype")
	private java.lang.String abctype;
	/**accflag*/
	@Excel(name = "accflag", width = 15)
    @ApiModelProperty(value = "accflag")
	private java.lang.String accflag;
	/**cinvmnecode*/
	@Excel(name = "cinvmnecode", width = 15)
    @ApiModelProperty(value = "cinvmnecode")
	private java.lang.String cinvmnecode;
	/**consumesettleflag*/
	@Excel(name = "consumesettleflag", width = 15)
    @ApiModelProperty(value = "consumesettleflag")
	private java.lang.String consumesettleflag;
	/**coopdayfrom*/
	@Excel(name = "coopdayfrom", width = 15)
    @ApiModelProperty(value = "coopdayfrom")
	private java.lang.String coopdayfrom;
	/**coopdayto*/
	@Excel(name = "coopdayto", width = 15)
    @ApiModelProperty(value = "coopdayto")
	private java.lang.String coopdayto;
	/**costprice*/
	@Excel(name = "costprice", width = 15)
    @ApiModelProperty(value = "costprice")
	private java.math.BigDecimal costprice;
	/**createtime*/
	@Excel(name = "createtime", width = 15)
    @ApiModelProperty(value = "createtime")
	private java.lang.String createtime;
	/**creator*/
	@Excel(name = "creator", width = 15)
    @ApiModelProperty(value = "creator")
	private java.lang.String creator;
	/**def1*/
	@Excel(name = "def1", width = 15)
    @ApiModelProperty(value = "def1")
	private java.lang.String def1;
	/**def10*/
	@Excel(name = "def10", width = 15)
    @ApiModelProperty(value = "def10")
	private java.lang.String def10;
	/**def11*/
	@Excel(name = "def11", width = 15)
    @ApiModelProperty(value = "def11")
	private java.lang.String def11;
	/**def12*/
	@Excel(name = "def12", width = 15)
    @ApiModelProperty(value = "def12")
	private java.lang.String def12;
	/**def13*/
	@Excel(name = "def13", width = 15)
    @ApiModelProperty(value = "def13")
	private java.lang.String def13;
	/**def14*/
	@Excel(name = "def14", width = 15)
    @ApiModelProperty(value = "def14")
	private java.lang.String def14;
	/**def15*/
	@Excel(name = "def15", width = 15)
    @ApiModelProperty(value = "def15")
	private java.lang.String def15;

	@Excel(name = "invcode", width = 15)
	@ApiModelProperty(value = "invcode")
	private String invcode;
	/**def16*/
	@Excel(name = "def16", width = 15)
    @ApiModelProperty(value = "def16")
	private java.lang.String def16;
	/**def17*/
	@Excel(name = "def17", width = 15)
    @ApiModelProperty(value = "def17")
	private java.lang.String def17;
	/**def18*/
	@Excel(name = "def18", width = 15)
    @ApiModelProperty(value = "def18")
	private java.lang.String def18;
	/**def19*/
	@Excel(name = "def19", width = 15)
    @ApiModelProperty(value = "def19")
	private java.lang.String def19;
	/**def2*/
	@Excel(name = "def2", width = 15)
    @ApiModelProperty(value = "def2")
	private java.lang.String def2;
	/**def20*/
	@Excel(name = "def20", width = 15)
    @ApiModelProperty(value = "def20")
	private java.lang.String def20;
	/**def3*/
	@Excel(name = "def3", width = 15)
    @ApiModelProperty(value = "def3")
	private java.lang.String def3;
	/**def4*/
	@Excel(name = "def4", width = 15)
    @ApiModelProperty(value = "def4")
	private java.lang.String def4;
	/**def5*/
	@Excel(name = "def5", width = 15)
    @ApiModelProperty(value = "def5")
	private java.lang.String def5;
	/**def6*/
	@Excel(name = "def6", width = 15)
    @ApiModelProperty(value = "def6")
	private java.lang.String def6;
	/**def7*/
	@Excel(name = "def7", width = 15)
    @ApiModelProperty(value = "def7")
	private java.lang.String def7;
	/**def8*/
	@Excel(name = "def8", width = 15)
    @ApiModelProperty(value = "def8")
	private java.lang.String def8;
	/**def9*/
	@Excel(name = "def9", width = 15)
    @ApiModelProperty(value = "def9")
	private java.lang.String def9;
	/**dr*/
	@Excel(name = "dr", width = 15)
    @ApiModelProperty(value = "dr")
	private java.lang.Integer dr;
	/**expaybacktax*/
	@Excel(name = "expaybacktax", width = 15)
    @ApiModelProperty(value = "expaybacktax")
	private java.math.BigDecimal expaybacktax;
	/**free1*/
	@Excel(name = "free1", width = 15)
    @ApiModelProperty(value = "free1")
	private java.lang.String free1;
	/**free2*/
	@Excel(name = "free2", width = 15)
    @ApiModelProperty(value = "free2")
	private java.lang.String free2;
	/**free3*/
	@Excel(name = "free3", width = 15)
    @ApiModelProperty(value = "free3")
	private java.lang.String free3;
	/**free4*/
	@Excel(name = "free4", width = 15)
    @ApiModelProperty(value = "free4")
	private java.lang.String free4;
	/**free5*/
	@Excel(name = "free5", width = 15)
    @ApiModelProperty(value = "free5")
	private java.lang.String free5;
	/**grade*/
	@Excel(name = "grade", width = 15)
    @ApiModelProperty(value = "grade")
	private java.lang.Integer grade;
	/**invlifeperiod*/
	@Excel(name = "invlifeperiod", width = 15)
    @ApiModelProperty(value = "invlifeperiod")
	private java.lang.Integer invlifeperiod;
	/**isappendant*/
	@Excel(name = "isappendant", width = 15)
    @ApiModelProperty(value = "isappendant")
	private java.lang.String isappendant;
	/**isautoatpcheck*/
	@Excel(name = "isautoatpcheck", width = 15)
    @ApiModelProperty(value = "isautoatpcheck")
	private java.lang.String isautoatpcheck;
	/**iscancalculatedinvcost*/
	@Excel(name = "iscancalculatedinvcost", width = 15)
    @ApiModelProperty(value = "iscancalculatedinvcost")
	private java.lang.String iscancalculatedinvcost;
	/**iscanpurchased*/
	@Excel(name = "iscanpurchased", width = 15)
    @ApiModelProperty(value = "iscanpurchased")
	private java.lang.String iscanpurchased;
	/**iscansaleinvoice*/
	@Excel(name = "iscansaleinvoice", width = 15)
    @ApiModelProperty(value = "iscansaleinvoice")
	private java.lang.String iscansaleinvoice;
	/**iscansold*/
	@Excel(name = "iscansold", width = 15)
    @ApiModelProperty(value = "iscansold")
	private java.lang.String iscansold;
	/**isconfigable*/
	@Excel(name = "isconfigable", width = 15)
    @ApiModelProperty(value = "isconfigable")
	private java.lang.String isconfigable;
	/**isctlprodplanprice*/
	@Excel(name = "isctlprodplanprice", width = 15)
    @ApiModelProperty(value = "isctlprodplanprice")
	private java.lang.String isctlprodplanprice;
	/**isfatherofbom*/
	@Excel(name = "isfatherofbom", width = 15)
    @ApiModelProperty(value = "isfatherofbom")
	private java.lang.String isfatherofbom;
	/**isinvretfreeofchk*/
	@Excel(name = "isinvretfreeofchk", width = 15)
    @ApiModelProperty(value = "isinvretfreeofchk")
	private java.lang.String isinvretfreeofchk;
	/**isinvretinstobychk*/
	@Excel(name = "isinvretinstobychk", width = 15)
    @ApiModelProperty(value = "isinvretinstobychk")
	private java.lang.String isinvretinstobychk;
	/**isinvreturned*/
	@Excel(name = "isinvreturned", width = 15)
    @ApiModelProperty(value = "isinvreturned")
	private java.lang.String isinvreturned;
	/**isnoconallowed*/
	@Excel(name = "isnoconallowed", width = 15)
    @ApiModelProperty(value = "isnoconallowed")
	private java.lang.String isnoconallowed;
	/**isprimarybarcode*/
	@Excel(name = "isprimarybarcode", width = 15)
    @ApiModelProperty(value = "isprimarybarcode")
	private java.lang.String isprimarybarcode;
	/**isrecurrentcheck*/
	@Excel(name = "isrecurrentcheck", width = 15)
    @ApiModelProperty(value = "isrecurrentcheck")
	private java.lang.String isrecurrentcheck;
	/**issalable*/
	@Excel(name = "issalable", width = 15)
    @ApiModelProperty(value = "issalable")
	private java.lang.String issalable;
	/**issecondarybarcode*/
	@Excel(name = "issecondarybarcode", width = 15)
    @ApiModelProperty(value = "issecondarybarcode")
	private java.lang.String issecondarybarcode;
	/**isselfapprsupplier*/
	@Excel(name = "isselfapprsupplier", width = 15)
    @ApiModelProperty(value = "isselfapprsupplier")
	private java.lang.String isselfapprsupplier;
	/**isspecialty*/
	@Excel(name = "isspecialty", width = 15)
    @ApiModelProperty(value = "isspecialty")
	private java.lang.String isspecialty;
	/**issupplierstock*/
	@Excel(name = "issupplierstock", width = 15)
    @ApiModelProperty(value = "issupplierstock")
	private java.lang.String issupplierstock;
	/**isused*/
	@Excel(name = "isused", width = 15)
    @ApiModelProperty(value = "isused")
	private java.lang.String isused;
	/**isvirtual*/
	@Excel(name = "isvirtual", width = 15)
    @ApiModelProperty(value = "isvirtual")
	private java.lang.String isvirtual;
	/**keepwasterate*/
	@Excel(name = "keepwasterate", width = 15)
    @ApiModelProperty(value = "keepwasterate")
	private java.math.BigDecimal keepwasterate;
	/**lowestprice*/
	@Excel(name = "lowestprice", width = 15)
    @ApiModelProperty(value = "lowestprice")
	private java.math.BigDecimal lowestprice;
	/**mantaxitem*/
	@Excel(name = "mantaxitem", width = 15)
    @ApiModelProperty(value = "mantaxitem")
	private java.lang.String mantaxitem;
	/**maxprice*/
	@Excel(name = "maxprice", width = 15)
    @ApiModelProperty(value = "maxprice")
	private java.math.BigDecimal maxprice;
	/**memo*/
	@Excel(name = "memo", width = 15)
    @ApiModelProperty(value = "memo")
	private java.lang.String memo;
	/**modifier*/
	@Excel(name = "modifier", width = 15)
    @ApiModelProperty(value = "modifier")
	private java.lang.String modifier;
	/**modifytime*/
	@Excel(name = "modifytime", width = 15)
    @ApiModelProperty(value = "modifytime")
	private java.lang.String modifytime;
	/**negallowed*/
	@Excel(name = "negallowed", width = 15)
    @ApiModelProperty(value = "negallowed")
	private java.lang.String negallowed;
	/**outpriority*/
	@Excel(name = "outpriority", width = 15)
    @ApiModelProperty(value = "outpriority")
	private java.lang.Integer outpriority;
	/**outtrackin*/
	@Excel(name = "outtrackin", width = 15)
    @ApiModelProperty(value = "outtrackin")
	private java.lang.String outtrackin;
	/**pebegin*/
	@Excel(name = "pebegin", width = 15)
    @ApiModelProperty(value = "pebegin")
	private java.lang.String pebegin;
	/**peend*/
	@Excel(name = "peend", width = 15)
    @ApiModelProperty(value = "peend")
	private java.lang.String peend;
	/**pkCorp*/
	@Excel(name = "pkCorp", width = 15)
    @ApiModelProperty(value = "pkCorp")
	private java.lang.String pkCorp;
	/**pkCumandoc*/
	@Excel(name = "pkCumandoc", width = 15)
    @ApiModelProperty(value = "pkCumandoc")
	private java.lang.String pkCumandoc;
	/**pkDftfactory*/
	@Excel(name = "pkDftfactory", width = 15)
    @ApiModelProperty(value = "pkDftfactory")
	private java.lang.String pkDftfactory;
	/**pkInvbasdoc*/
	@Excel(name = "pkInvbasdoc", width = 15)
    @ApiModelProperty(value = "pkInvbasdoc")
	private java.lang.String pkInvbasdoc;
	/**pkInvmandoc*/
	@Excel(name = "pkInvmandoc", width = 15)
    @ApiModelProperty(value = "pkInvmandoc")
	private java.lang.String pkInvmandoc;
	/**pkSealuser*/
	@Excel(name = "pkSealuser", width = 15)
    @ApiModelProperty(value = "pkSealuser")
	private java.lang.String pkSealuser;
	/**planprice*/
	@Excel(name = "planprice", width = 15)
    @ApiModelProperty(value = "planprice")
	private java.math.BigDecimal planprice;
	/**prodarea*/
	@Excel(name = "prodarea", width = 15)
    @ApiModelProperty(value = "prodarea")
	private java.lang.String prodarea;
	/**purchasestge*/
	@Excel(name = "purchasestge", width = 15)
    @ApiModelProperty(value = "purchasestge")
	private java.lang.String purchasestge;
	/**purwasterate*/
	@Excel(name = "purwasterate", width = 15)
    @ApiModelProperty(value = "purwasterate")
	private java.math.BigDecimal purwasterate;
	/**qualitydaynum*/
	@Excel(name = "qualitydaynum", width = 15)
    @ApiModelProperty(value = "qualitydaynum")
	private java.lang.Integer qualitydaynum;
	/**qualitymanflag*/
	@Excel(name = "qualitymanflag", width = 15)
    @ApiModelProperty(value = "qualitymanflag")
	private java.lang.String qualitymanflag;
	/**qualityperiodunit*/
	@Excel(name = "qualityperiodunit", width = 15)
    @ApiModelProperty(value = "qualityperiodunit")
	private java.lang.Integer qualityperiodunit;
	/**recurrentchkcyc*/
	@Excel(name = "recurrentchkcyc", width = 15)
    @ApiModelProperty(value = "recurrentchkcyc")
	private java.lang.Integer recurrentchkcyc;
	/**refsaleprice*/
	@Excel(name = "refsaleprice", width = 15)
    @ApiModelProperty(value = "refsaleprice")
	private java.math.BigDecimal refsaleprice;
	/**sealdate*/
	@Excel(name = "sealdate", width = 15)
    @ApiModelProperty(value = "sealdate")
	private java.lang.String sealdate;
	/**sealflag*/
	@Excel(name = "sealflag", width = 15)
    @ApiModelProperty(value = "sealflag")
	private java.lang.String sealflag;
	/**sellproxyflag*/
	@Excel(name = "sellproxyflag", width = 15)
    @ApiModelProperty(value = "sellproxyflag")
	private java.lang.String sellproxyflag;
	/**serialmanaflag*/
	@Excel(name = "serialmanaflag", width = 15)
    @ApiModelProperty(value = "serialmanaflag")
	private java.lang.String serialmanaflag;
	/**ts*/
	@Excel(name = "ts", width = 15)
    @ApiModelProperty(value = "ts")
	private java.lang.String ts;
	/**wholemanaflag*/
	@Excel(name = "wholemanaflag", width = 15)
    @ApiModelProperty(value = "wholemanaflag")
	private java.lang.String wholemanaflag;

	private String pkMeasdoc;
}
