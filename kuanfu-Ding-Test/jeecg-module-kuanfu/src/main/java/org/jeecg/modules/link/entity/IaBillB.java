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
@TableName("ia_bill_b")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ia_bill_b对象", description="存货档案")
public class IaBillB {
    
	/**badjusteditemflag*/
	@Excel(name = "badjusteditemflag", width = 15)
    @ApiModelProperty(value = "badjusteditemflag")
	private java.lang.String badjusteditemflag;
	/**bauditbatchflag*/
	@Excel(name = "bauditbatchflag", width = 15)
    @ApiModelProperty(value = "bauditbatchflag")
	private java.lang.String bauditbatchflag;
	/**bauditfreeflag*/
	@Excel(name = "bauditfreeflag", width = 15)
    @ApiModelProperty(value = "bauditfreeflag")
	private java.lang.String bauditfreeflag;
	/**bauditvendorflag*/
	@Excel(name = "bauditvendorflag", width = 15)
    @ApiModelProperty(value = "bauditvendorflag")
	private java.lang.String bauditvendorflag;
	/**blargessflag*/
	@Excel(name = "blargessflag", width = 15)
    @ApiModelProperty(value = "blargessflag")
	private java.lang.String blargessflag;
	/**bretractflag*/
	@Excel(name = "bretractflag", width = 15)
    @ApiModelProperty(value = "bretractflag")
	private java.lang.String bretractflag;
	/**brtvouchflag*/
	@Excel(name = "brtvouchflag", width = 15)
    @ApiModelProperty(value = "brtvouchflag")
	private java.lang.String brtvouchflag;
	/**btransferincometax*/
	@Excel(name = "btransferincometax", width = 15)
    @ApiModelProperty(value = "btransferincometax")
	private java.lang.String btransferincometax;
	/**cadjustbillid*/
	@Excel(name = "cadjustbillid", width = 15)
    @ApiModelProperty(value = "cadjustbillid")
	private java.lang.String cadjustbillid;
	/**cadjustbillitemid*/
	@Excel(name = "cadjustbillitemid", width = 15)
    @ApiModelProperty(value = "cadjustbillitemid")
	private java.lang.String cadjustbillitemid;
	/**castunitid*/
	@Excel(name = "castunitid", width = 15)
    @ApiModelProperty(value = "castunitid")
	private java.lang.String castunitid;
	/**cauditorid*/
	@Excel(name = "cauditorid", width = 15)
    @ApiModelProperty(value = "cauditorid")
	private java.lang.String cauditorid;
	/**cbillBid*/
	@Excel(name = "cbillBid", width = 15)
    @ApiModelProperty(value = "cbillBid")
	private java.lang.String cbillBid;
	/**cbillid*/
	@Excel(name = "cbillid", width = 15)
    @ApiModelProperty(value = "cbillid")
	private java.lang.String cbillid;
	/**cbilltypecode*/
	@Excel(name = "cbilltypecode", width = 15)
    @ApiModelProperty(value = "cbilltypecode")
	private java.lang.String cbilltypecode;
	/**ccalcbillid*/
	@Excel(name = "ccalcbillid", width = 15)
    @ApiModelProperty(value = "ccalcbillid")
	private java.lang.String ccalcbillid;
	/**ccalcbillitemid*/
	@Excel(name = "ccalcbillitemid", width = 15)
    @ApiModelProperty(value = "ccalcbillitemid")
	private java.lang.String ccalcbillitemid;
	/**ccrspbillitemid*/
	@Excel(name = "ccrspbillitemid", width = 15)
    @ApiModelProperty(value = "ccrspbillitemid")
	private java.lang.String ccrspbillitemid;
	/**ccsaleadviceitemid*/
	@Excel(name = "ccsaleadviceitemid", width = 15)
    @ApiModelProperty(value = "ccsaleadviceitemid")
	private java.lang.String ccsaleadviceitemid;
	/**cfacardid*/
	@Excel(name = "cfacardid", width = 15)
    @ApiModelProperty(value = "cfacardid")
	private java.lang.String cfacardid;
	/**cfadeviceid*/
	@Excel(name = "cfadeviceid", width = 15)
    @ApiModelProperty(value = "cfadeviceid")
	private java.lang.String cfadeviceid;
	/**cfirstbillid*/
	@Excel(name = "cfirstbillid", width = 15)
    @ApiModelProperty(value = "cfirstbillid")
	private java.lang.String cfirstbillid;
	/**cfirstbillitemid*/
	@Excel(name = "cfirstbillitemid", width = 15)
    @ApiModelProperty(value = "cfirstbillitemid")
	private java.lang.String cfirstbillitemid;
	/**cfirstbilltypecode*/
	@Excel(name = "cfirstbilltypecode", width = 15)
    @ApiModelProperty(value = "cfirstbilltypecode")
	private java.lang.String cfirstbilltypecode;
	/**cicbillcode*/
	@Excel(name = "cicbillcode", width = 15)
    @ApiModelProperty(value = "cicbillcode")
	private java.lang.String cicbillcode;
	/**cicbillid*/
	@Excel(name = "cicbillid", width = 15)
    @ApiModelProperty(value = "cicbillid")
	private java.lang.String cicbillid;
	/**cicbilltype*/
	@Excel(name = "cicbilltype", width = 15)
    @ApiModelProperty(value = "cicbilltype")
	private java.lang.String cicbilltype;
	/**cicitemid*/
	@Excel(name = "cicitemid", width = 15)
    @ApiModelProperty(value = "cicitemid")
	private java.lang.String cicitemid;
	/**cinbillitemid*/
	@Excel(name = "cinbillitemid", width = 15)
    @ApiModelProperty(value = "cinbillitemid")
	private java.lang.String cinbillitemid;
	/**cinvbasid*/
	@Excel(name = "cinvbasid", width = 15)
    @ApiModelProperty(value = "cinvbasid")
	private java.lang.String cinvbasid;
	/**cinventoryid*/
	@Excel(name = "cinventoryid", width = 15)
    @ApiModelProperty(value = "cinventoryid")
	private java.lang.String cinventoryid;
	/**cprojectid*/
	@Excel(name = "cprojectid", width = 15)
    @ApiModelProperty(value = "cprojectid")
	private java.lang.String cprojectid;
	/**cprojectphase*/
	@Excel(name = "cprojectphase", width = 15)
    @ApiModelProperty(value = "cprojectphase")
	private java.lang.String cprojectphase;
	/**crdcenterid*/
	@Excel(name = "crdcenterid", width = 15)
    @ApiModelProperty(value = "crdcenterid")
	private java.lang.String crdcenterid;
	/**csaleadviceid*/
	@Excel(name = "csaleadviceid", width = 15)
    @ApiModelProperty(value = "csaleadviceid")
	private java.lang.String csaleadviceid;
	/**csaleaudititemid*/
	@Excel(name = "csaleaudititemid", width = 15)
    @ApiModelProperty(value = "csaleaudititemid")
	private java.lang.String csaleaudititemid;
	/**csourcebillid*/
	@Excel(name = "csourcebillid", width = 15)
    @ApiModelProperty(value = "csourcebillid")
	private java.lang.String csourcebillid;
	/**csourcebillitemid*/
	@Excel(name = "csourcebillitemid", width = 15)
    @ApiModelProperty(value = "csourcebillitemid")
	private java.lang.String csourcebillitemid;
	/**csourcebilltypecode*/
	@Excel(name = "csourcebilltypecode", width = 15)
    @ApiModelProperty(value = "csourcebilltypecode")
	private java.lang.String csourcebilltypecode;
	/**csumrtvouchid*/
	@Excel(name = "csumrtvouchid", width = 15)
    @ApiModelProperty(value = "csumrtvouchid")
	private java.lang.String csumrtvouchid;
	/**cvendorbasid*/
	@Excel(name = "cvendorbasid", width = 15)
    @ApiModelProperty(value = "cvendorbasid")
	private java.lang.String cvendorbasid;
	/**cvendorid*/
	@Excel(name = "cvendorid", width = 15)
    @ApiModelProperty(value = "cvendorid")
	private java.lang.String cvendorid;
	/**cvoucherid*/
	@Excel(name = "cvoucherid", width = 15)
    @ApiModelProperty(value = "cvoucherid")
	private java.lang.String cvoucherid;
	/**cwp*/
	@Excel(name = "cwp", width = 15)
    @ApiModelProperty(value = "cwp")
	private java.lang.String cwp;
	/**dauditdate*/
	@Excel(name = "dauditdate", width = 15)
    @ApiModelProperty(value = "dauditdate")
	private java.lang.String dauditdate;
	/**dbizdate*/
	@Excel(name = "dbizdate", width = 15)
    @ApiModelProperty(value = "dbizdate")
	private java.lang.String dbizdate;
	/**ddrawrate*/
	@Excel(name = "ddrawrate", width = 15)
    @ApiModelProperty(value = "ddrawrate")
	private java.math.BigDecimal ddrawrate;
	/**dr*/
	@Excel(name = "dr", width = 15)
    @ApiModelProperty(value = "dr")
	private java.lang.Integer dr;
	/**fcalcbizflag*/
	@Excel(name = "fcalcbizflag", width = 15)
    @ApiModelProperty(value = "fcalcbizflag")
	private java.lang.Integer fcalcbizflag;
	/**fdatagetmodelflag*/
	@Excel(name = "fdatagetmodelflag", width = 15)
    @ApiModelProperty(value = "fdatagetmodelflag")
	private java.lang.Integer fdatagetmodelflag;
	/**folddatagetmodelflag*/
	@Excel(name = "folddatagetmodelflag", width = 15)
    @ApiModelProperty(value = "folddatagetmodelflag")
	private java.lang.Integer folddatagetmodelflag;
	/**foutadjustableflag*/
	@Excel(name = "foutadjustableflag", width = 15)
    @ApiModelProperty(value = "foutadjustableflag")
	private java.lang.String foutadjustableflag;
	/**fpricemodeflag*/
	@Excel(name = "fpricemodeflag", width = 15)
    @ApiModelProperty(value = "fpricemodeflag")
	private java.lang.Integer fpricemodeflag;
	/**iauditsequence*/
	@Excel(name = "iauditsequence", width = 15)
    @ApiModelProperty(value = "iauditsequence")
	private java.lang.Integer iauditsequence;
	/**irownumber*/
	@Excel(name = "irownumber", width = 15)
    @ApiModelProperty(value = "irownumber")
	private java.lang.Integer irownumber;
	/**nadjustnum*/
	@Excel(name = "nadjustnum", width = 15)
    @ApiModelProperty(value = "nadjustnum")
	private java.math.BigDecimal nadjustnum;
	/**nassistnum*/
	@Excel(name = "nassistnum", width = 15)
    @ApiModelProperty(value = "nassistnum")
	private java.math.BigDecimal nassistnum;
	/**nchangerate*/
	@Excel(name = "nchangerate", width = 15)
    @ApiModelProperty(value = "nchangerate")
	private java.math.BigDecimal nchangerate;
	/**ndrawsummny*/
	@Excel(name = "ndrawsummny", width = 15)
    @ApiModelProperty(value = "ndrawsummny")
	private java.math.BigDecimal ndrawsummny;
	/**nexpaybacktax*/
	@Excel(name = "nexpaybacktax", width = 15)
    @ApiModelProperty(value = "nexpaybacktax")
	private java.math.BigDecimal nexpaybacktax;
	/**nfactor1*/
	@Excel(name = "nfactor1", width = 15)
    @ApiModelProperty(value = "nfactor1")
	private java.math.BigDecimal nfactor1;
	/**nfactor2*/
	@Excel(name = "nfactor2", width = 15)
    @ApiModelProperty(value = "nfactor2")
	private java.math.BigDecimal nfactor2;
	/**nfactor3*/
	@Excel(name = "nfactor3", width = 15)
    @ApiModelProperty(value = "nfactor3")
	private java.math.BigDecimal nfactor3;
	/**nfactor4*/
	@Excel(name = "nfactor4", width = 15)
    @ApiModelProperty(value = "nfactor4")
	private java.math.BigDecimal nfactor4;
	/**nfactor5*/
	@Excel(name = "nfactor5", width = 15)
    @ApiModelProperty(value = "nfactor5")
	private java.math.BigDecimal nfactor5;
	/**nfactor6*/
	@Excel(name = "nfactor6", width = 15)
    @ApiModelProperty(value = "nfactor6")
	private java.math.BigDecimal nfactor6;
	/**nfactor7*/
	@Excel(name = "nfactor7", width = 15)
    @ApiModelProperty(value = "nfactor7")
	private java.math.BigDecimal nfactor7;
	/**nfactor8*/
	@Excel(name = "nfactor8", width = 15)
    @ApiModelProperty(value = "nfactor8")
	private java.math.BigDecimal nfactor8;
	/**nincometax*/
	@Excel(name = "nincometax", width = 15)
    @ApiModelProperty(value = "nincometax")
	private java.math.BigDecimal nincometax;
	/**ninvarymny*/
	@Excel(name = "ninvarymny", width = 15)
    @ApiModelProperty(value = "ninvarymny")
	private java.math.BigDecimal ninvarymny;
	/**nmoney*/
	@Excel(name = "nmoney", width = 15)
    @ApiModelProperty(value = "nmoney")
	private java.math.BigDecimal nmoney;
	/**nnumber*/
	@Excel(name = "nnumber", width = 15)
    @ApiModelProperty(value = "nnumber")
	private java.math.BigDecimal nnumber;
	/**noriginalprice*/
	@Excel(name = "noriginalprice", width = 15)
    @ApiModelProperty(value = "noriginalprice")
	private java.math.BigDecimal noriginalprice;
	/**noutvarymny*/
	@Excel(name = "noutvarymny", width = 15)
    @ApiModelProperty(value = "noutvarymny")
	private java.math.BigDecimal noutvarymny;
	/**nplanedmny*/
	@Excel(name = "nplanedmny", width = 15)
    @ApiModelProperty(value = "nplanedmny")
	private java.math.BigDecimal nplanedmny;
	/**nplanedprice*/
	@Excel(name = "nplanedprice", width = 15)
    @ApiModelProperty(value = "nplanedprice")
	private java.math.BigDecimal nplanedprice;
	/**nprice*/
	@Excel(name = "nprice", width = 15)
    @ApiModelProperty(value = "nprice")
	private java.math.BigDecimal nprice;
	/**nreasonalwastmny*/
	@Excel(name = "nreasonalwastmny", width = 15)
    @ApiModelProperty(value = "nreasonalwastmny")
	private java.math.BigDecimal nreasonalwastmny;
	/**nreasonalwastnum*/
	@Excel(name = "nreasonalwastnum", width = 15)
    @ApiModelProperty(value = "nreasonalwastnum")
	private java.math.BigDecimal nreasonalwastnum;
	/**nreasonalwastprice*/
	@Excel(name = "nreasonalwastprice", width = 15)
    @ApiModelProperty(value = "nreasonalwastprice")
	private java.math.BigDecimal nreasonalwastprice;
	/**nsettledretractnum*/
	@Excel(name = "nsettledretractnum", width = 15)
    @ApiModelProperty(value = "nsettledretractnum")
	private java.math.BigDecimal nsettledretractnum;
	/**nsettledsendnum*/
	@Excel(name = "nsettledsendnum", width = 15)
    @ApiModelProperty(value = "nsettledsendnum")
	private java.math.BigDecimal nsettledsendnum;
	/**nsimulatemny*/
	@Excel(name = "nsimulatemny", width = 15)
    @ApiModelProperty(value = "nsimulatemny")
	private java.math.BigDecimal nsimulatemny;
	/**pkCorp*/
	@Excel(name = "pkCorp", width = 15)
    @ApiModelProperty(value = "pkCorp")
	private java.lang.String pkCorp;
	/**pkDefdoc1*/
	@Excel(name = "pkDefdoc1", width = 15)
    @ApiModelProperty(value = "pkDefdoc1")
	private java.lang.String pkDefdoc1;
	/**pkDefdoc10*/
	@Excel(name = "pkDefdoc10", width = 15)
    @ApiModelProperty(value = "pkDefdoc10")
	private java.lang.String pkDefdoc10;
	/**pkDefdoc11*/
	@Excel(name = "pkDefdoc11", width = 15)
    @ApiModelProperty(value = "pkDefdoc11")
	private java.lang.String pkDefdoc11;
	/**pkDefdoc12*/
	@Excel(name = "pkDefdoc12", width = 15)
    @ApiModelProperty(value = "pkDefdoc12")
	private java.lang.String pkDefdoc12;
	/**pkDefdoc13*/
	@Excel(name = "pkDefdoc13", width = 15)
    @ApiModelProperty(value = "pkDefdoc13")
	private java.lang.String pkDefdoc13;
	/**pkDefdoc14*/
	@Excel(name = "pkDefdoc14", width = 15)
    @ApiModelProperty(value = "pkDefdoc14")
	private java.lang.String pkDefdoc14;
	/**pkDefdoc15*/
	@Excel(name = "pkDefdoc15", width = 15)
    @ApiModelProperty(value = "pkDefdoc15")
	private java.lang.String pkDefdoc15;
	/**pkDefdoc16*/
	@Excel(name = "pkDefdoc16", width = 15)
    @ApiModelProperty(value = "pkDefdoc16")
	private java.lang.String pkDefdoc16;
	/**pkDefdoc17*/
	@Excel(name = "pkDefdoc17", width = 15)
    @ApiModelProperty(value = "pkDefdoc17")
	private java.lang.String pkDefdoc17;
	/**pkDefdoc18*/
	@Excel(name = "pkDefdoc18", width = 15)
    @ApiModelProperty(value = "pkDefdoc18")
	private java.lang.String pkDefdoc18;
	/**pkDefdoc19*/
	@Excel(name = "pkDefdoc19", width = 15)
    @ApiModelProperty(value = "pkDefdoc19")
	private java.lang.String pkDefdoc19;
	/**pkDefdoc2*/
	@Excel(name = "pkDefdoc2", width = 15)
    @ApiModelProperty(value = "pkDefdoc2")
	private java.lang.String pkDefdoc2;
	/**pkDefdoc20*/
	@Excel(name = "pkDefdoc20", width = 15)
    @ApiModelProperty(value = "pkDefdoc20")
	private java.lang.String pkDefdoc20;
	/**pkDefdoc3*/
	@Excel(name = "pkDefdoc3", width = 15)
    @ApiModelProperty(value = "pkDefdoc3")
	private java.lang.String pkDefdoc3;
	/**pkDefdoc4*/
	@Excel(name = "pkDefdoc4", width = 15)
    @ApiModelProperty(value = "pkDefdoc4")
	private java.lang.String pkDefdoc4;
	/**pkDefdoc5*/
	@Excel(name = "pkDefdoc5", width = 15)
    @ApiModelProperty(value = "pkDefdoc5")
	private java.lang.String pkDefdoc5;
	/**pkDefdoc6*/
	@Excel(name = "pkDefdoc6", width = 15)
    @ApiModelProperty(value = "pkDefdoc6")
	private java.lang.String pkDefdoc6;
	/**pkDefdoc7*/
	@Excel(name = "pkDefdoc7", width = 15)
    @ApiModelProperty(value = "pkDefdoc7")
	private java.lang.String pkDefdoc7;
	/**pkDefdoc8*/
	@Excel(name = "pkDefdoc8", width = 15)
    @ApiModelProperty(value = "pkDefdoc8")
	private java.lang.String pkDefdoc8;
	/**pkDefdoc9*/
	@Excel(name = "pkDefdoc9", width = 15)
    @ApiModelProperty(value = "pkDefdoc9")
	private java.lang.String pkDefdoc9;
	/**processcost*/
	@Excel(name = "processcost", width = 15)
    @ApiModelProperty(value = "processcost")
	private java.math.BigDecimal processcost;
	/**ts*/
	@Excel(name = "ts", width = 15)
    @ApiModelProperty(value = "ts")
	private java.lang.String ts;
	/**vbatch*/
	@Excel(name = "vbatch", width = 15)
    @ApiModelProperty(value = "vbatch")
	private java.lang.String vbatch;
	/**vbillcode*/
	@Excel(name = "vbillcode", width = 15)
    @ApiModelProperty(value = "vbillcode")
	private java.lang.String vbillcode;
	/**vbomcode*/
	@Excel(name = "vbomcode", width = 15)
    @ApiModelProperty(value = "vbomcode")
	private java.lang.String vbomcode;
	/**vcalcbilltype*/
	@Excel(name = "vcalcbilltype", width = 15)
    @ApiModelProperty(value = "vcalcbilltype")
	private java.lang.String vcalcbilltype;
	/**vdef1*/
	@Excel(name = "vdef1", width = 15)
    @ApiModelProperty(value = "vdef1")
	private java.lang.String vdef1;
	/**vdef10*/
	@Excel(name = "vdef10", width = 15)
    @ApiModelProperty(value = "vdef10")
	private java.lang.String vdef10;
	/**vdef11*/
	@Excel(name = "vdef11", width = 15)
    @ApiModelProperty(value = "vdef11")
	private java.lang.String vdef11;
	/**vdef12*/
	@Excel(name = "vdef12", width = 15)
    @ApiModelProperty(value = "vdef12")
	private java.lang.String vdef12;
	/**vdef13*/
	@Excel(name = "vdef13", width = 15)
    @ApiModelProperty(value = "vdef13")
	private java.lang.String vdef13;
	/**vdef14*/
	@Excel(name = "vdef14", width = 15)
    @ApiModelProperty(value = "vdef14")
	private java.lang.String vdef14;
	/**vdef15*/
	@Excel(name = "vdef15", width = 15)
    @ApiModelProperty(value = "vdef15")
	private java.lang.String vdef15;
	/**vdef16*/
	@Excel(name = "vdef16", width = 15)
    @ApiModelProperty(value = "vdef16")
	private java.lang.String vdef16;
	/**vdef17*/
	@Excel(name = "vdef17", width = 15)
    @ApiModelProperty(value = "vdef17")
	private java.lang.String vdef17;
	/**vdef18*/
	@Excel(name = "vdef18", width = 15)
    @ApiModelProperty(value = "vdef18")
	private java.lang.String vdef18;
	/**vdef19*/
	@Excel(name = "vdef19", width = 15)
    @ApiModelProperty(value = "vdef19")
	private java.lang.String vdef19;
	/**vdef2*/
	@Excel(name = "vdef2", width = 15)
    @ApiModelProperty(value = "vdef2")
	private java.lang.String vdef2;
	/**vdef20*/
	@Excel(name = "vdef20", width = 15)
    @ApiModelProperty(value = "vdef20")
	private java.lang.String vdef20;
	/**vdef3*/
	@Excel(name = "vdef3", width = 15)
    @ApiModelProperty(value = "vdef3")
	private java.lang.String vdef3;
	/**vdef4*/
	@Excel(name = "vdef4", width = 15)
    @ApiModelProperty(value = "vdef4")
	private java.lang.String vdef4;
	/**vdef5*/
	@Excel(name = "vdef5", width = 15)
    @ApiModelProperty(value = "vdef5")
	private java.lang.String vdef5;
	/**vdef6*/
	@Excel(name = "vdef6", width = 15)
    @ApiModelProperty(value = "vdef6")
	private java.lang.String vdef6;
	/**vdef7*/
	@Excel(name = "vdef7", width = 15)
    @ApiModelProperty(value = "vdef7")
	private java.lang.String vdef7;
	/**vdef8*/
	@Excel(name = "vdef8", width = 15)
    @ApiModelProperty(value = "vdef8")
	private java.lang.String vdef8;
	/**vdef9*/
	@Excel(name = "vdef9", width = 15)
    @ApiModelProperty(value = "vdef9")
	private java.lang.String vdef9;
	/**vfirstbillcode*/
	@Excel(name = "vfirstbillcode", width = 15)
    @ApiModelProperty(value = "vfirstbillcode")
	private java.lang.String vfirstbillcode;
	/**vfirstrowno*/
	@Excel(name = "vfirstrowno", width = 15)
    @ApiModelProperty(value = "vfirstrowno")
	private java.lang.String vfirstrowno;
	/**vfree1*/
	@Excel(name = "vfree1", width = 15)
    @ApiModelProperty(value = "vfree1")
	private java.lang.String vfree1;
	/**vfree10*/
	@Excel(name = "vfree10", width = 15)
    @ApiModelProperty(value = "vfree10")
	private java.lang.String vfree10;
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
	/**vfree6*/
	@Excel(name = "vfree6", width = 15)
    @ApiModelProperty(value = "vfree6")
	private java.lang.String vfree6;
	/**vfree7*/
	@Excel(name = "vfree7", width = 15)
    @ApiModelProperty(value = "vfree7")
	private java.lang.String vfree7;
	/**vfree8*/
	@Excel(name = "vfree8", width = 15)
    @ApiModelProperty(value = "vfree8")
	private java.lang.String vfree8;
	/**vfree9*/
	@Excel(name = "vfree9", width = 15)
    @ApiModelProperty(value = "vfree9")
	private java.lang.String vfree9;
	/**vproducebatch*/
	@Excel(name = "vproducebatch", width = 15)
    @ApiModelProperty(value = "vproducebatch")
	private java.lang.String vproducebatch;
	/**vsourcebillcode*/
	@Excel(name = "vsourcebillcode", width = 15)
    @ApiModelProperty(value = "vsourcebillcode")
	private java.lang.String vsourcebillcode;
	/**vsourcerowno*/
	@Excel(name = "vsourcerowno", width = 15)
    @ApiModelProperty(value = "vsourcerowno")
	private java.lang.String vsourcerowno;
}
