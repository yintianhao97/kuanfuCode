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
 * @Description: 价目表辅表
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@Data
@TableName("prm_tariffcurlist")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="prm_tariffcurlist对象", description="价目表辅表")
public class PrmTariffcurlist {
    
	/**bexistdownflag*/
	@Excel(name = "bexistdownflag", width = 15)
    @ApiModelProperty(value = "bexistdownflag")
	private java.lang.String bexistdownflag;
	/**cadjpriceBid*/
	@Excel(name = "cadjpriceBid", width = 15)
    @ApiModelProperty(value = "cadjpriceBid")
	private java.lang.String cadjpriceBid;
	/**cadjpriceid*/
	@Excel(name = "cadjpriceid", width = 15)
    @ApiModelProperty(value = "cadjpriceid")
	private java.lang.String cadjpriceid;
	/**caskunicode*/
	@Excel(name = "caskunicode", width = 15)
    @ApiModelProperty(value = "caskunicode")
	private java.lang.String caskunicode;
	/**ccubasdocid*/
	@Excel(name = "ccubasdocid", width = 15)
    @ApiModelProperty(value = "ccubasdocid")
	private java.lang.String ccubasdocid;
	/**ccurrencyid*/
	@Excel(name = "ccurrencyid", width = 15)
    @ApiModelProperty(value = "ccurrencyid")
	private java.lang.String ccurrencyid;
	/**ccustclassid*/
	@Excel(name = "ccustclassid", width = 15)
    @ApiModelProperty(value = "ccustclassid")
	private java.lang.String ccustclassid;
	/**ccustomerid*/
	@Excel(name = "ccustomerid", width = 15)
    @ApiModelProperty(value = "ccustomerid")
	private java.lang.String ccustomerid;
	/**cdefpricetypeid*/
	@Excel(name = "cdefpricetypeid", width = 15)
    @ApiModelProperty(value = "cdefpricetypeid")
	private java.lang.String cdefpricetypeid;
	/**cdownsourceid*/
	@Excel(name = "cdownsourceid", width = 15)
    @ApiModelProperty(value = "cdownsourceid")
	private java.lang.String cdownsourceid;
	/**cinvbasdocid*/
	@Excel(name = "cinvbasdocid", width = 15)
    @ApiModelProperty(value = "cinvbasdocid")
	private java.lang.String cinvbasdocid;
	/**cinvclassid*/
	@Excel(name = "cinvclassid", width = 15)
    @ApiModelProperty(value = "cinvclassid")
	private java.lang.String cinvclassid;
	/**cinventoryid*/
	@Excel(name = "cinventoryid", width = 15)
    @ApiModelProperty(value = "cinventoryid")
	private java.lang.String cinventoryid;
	/**cmeasdocid*/
	@Excel(name = "cmeasdocid", width = 15)
    @ApiModelProperty(value = "cmeasdocid")
	private java.lang.String cmeasdocid;
	/**cmodifierid*/
	@Excel(name = "cmodifierid", width = 15)
    @ApiModelProperty(value = "cmodifierid")
	private java.lang.String cmodifierid;
	/**cpricetariffBid*/
	@Excel(name = "cpricetariffBid", width = 15)
    @ApiModelProperty(value = "cpricetariffBid")
	private java.lang.String cpricetariffBid;
	/**cpricetariffid*/
	@Excel(name = "cpricetariffid", width = 15)
    @ApiModelProperty(value = "cpricetariffid")
	private java.lang.String cpricetariffid;
	/**creceiptareaid*/
	@Excel(name = "creceiptareaid", width = 15)
    @ApiModelProperty(value = "creceiptareaid")
	private java.lang.String creceiptareaid;
	/**csaleorganid*/
	@Excel(name = "csaleorganid", width = 15)
    @ApiModelProperty(value = "csaleorganid")
	private java.lang.String csaleorganid;
	/**cuniindexcode*/
	@Excel(name = "cuniindexcode", width = 15)
    @ApiModelProperty(value = "cuniindexcode")
	private java.lang.String cuniindexcode;
	/**dmodidate*/
	@Excel(name = "dmodidate", width = 15)
    @ApiModelProperty(value = "dmodidate")
	private java.lang.String dmodidate;
	/**dr*/
	@Excel(name = "dr", width = 15)
    @ApiModelProperty(value = "dr")
	private java.lang.Integer dr;
	/**nprice0*/
	@Excel(name = "nprice0", width = 15)
    @ApiModelProperty(value = "nprice0")
	private java.math.BigDecimal nprice0;
	/**nprice1*/
	@Excel(name = "nprice1", width = 15)
    @ApiModelProperty(value = "nprice1")
	private java.math.BigDecimal nprice1;
	/**nprice10*/
	@Excel(name = "nprice10", width = 15)
    @ApiModelProperty(value = "nprice10")
	private java.math.BigDecimal nprice10;
	/**nprice2*/
	@Excel(name = "nprice2", width = 15)
    @ApiModelProperty(value = "nprice2")
	private java.math.BigDecimal nprice2;
	/**nprice3*/
	@Excel(name = "nprice3", width = 15)
    @ApiModelProperty(value = "nprice3")
	private java.math.BigDecimal nprice3;
	/**nprice4*/
	@Excel(name = "nprice4", width = 15)
    @ApiModelProperty(value = "nprice4")
	private java.math.BigDecimal nprice4;
	/**nprice5*/
	@Excel(name = "nprice5", width = 15)
    @ApiModelProperty(value = "nprice5")
	private java.math.BigDecimal nprice5;
	/**nprice6*/
	@Excel(name = "nprice6", width = 15)
    @ApiModelProperty(value = "nprice6")
	private java.math.BigDecimal nprice6;
	/**nprice7*/
	@Excel(name = "nprice7", width = 15)
    @ApiModelProperty(value = "nprice7")
	private java.math.BigDecimal nprice7;
	/**nprice8*/
	@Excel(name = "nprice8", width = 15)
    @ApiModelProperty(value = "nprice8")
	private java.math.BigDecimal nprice8;
	/**nprice9*/
	@Excel(name = "nprice9", width = 15)
    @ApiModelProperty(value = "nprice9")
	private java.math.BigDecimal nprice9;
	/**pkCorp*/
	@Excel(name = "pkCorp", width = 15)
    @ApiModelProperty(value = "pkCorp")
	private java.lang.String pkCorp;
	/**ts*/
	@Excel(name = "ts", width = 15)
    @ApiModelProperty(value = "ts")
	private java.lang.String ts;
	/**vfree1*/
	@Excel(name = "vfree1", width = 15)
    @ApiModelProperty(value = "vfree1")
	private java.lang.String vfree1;
	/**vfree2*/
	@Excel(name = "vfree2", width = 15)
    @ApiModelProperty(value = "vfree2")
	private java.lang.String vfree2;
	/**vfree3*/
	@Excel(name = "vfree3", width = 15)
    @ApiModelProperty(value = "vfree3")
	private java.lang.String vfree3;
	/**vfree4*/
	@Excel(name = "vfree4", width = 15)
    @ApiModelProperty(value = "vfree4")
	private java.lang.String vfree4;
	/**vfree5*/
	@Excel(name = "vfree5", width = 15)
    @ApiModelProperty(value = "vfree5")
	private java.lang.String vfree5;
}
