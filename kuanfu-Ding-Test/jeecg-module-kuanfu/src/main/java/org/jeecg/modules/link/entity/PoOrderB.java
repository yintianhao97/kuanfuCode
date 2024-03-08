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
 * @Description: 采购订单表体
 * @Author: jeecg-boot
 * @Date:   2024-02-26
 * @Version: V1.0
 */
@Data
@TableName("po_order_b")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="po_order_b对象", description="采购订单表体")
public class PoOrderB {
    
	/**blargess*/
	@Excel(name = "blargess", width = 15)
    @ApiModelProperty(value = "blargess")
	private java.lang.String blargess;
	/**breceiveplan*/
	@Excel(name = "breceiveplan", width = 15)
    @ApiModelProperty(value = "breceiveplan")
	private java.lang.String breceiveplan;
	/**btransclosed*/
	@Excel(name = "btransclosed", width = 15)
    @ApiModelProperty(value = "btransclosed")
	private java.lang.String btransclosed;
	/**cassistunit*/
	@Excel(name = "cassistunit", width = 15)
    @ApiModelProperty(value = "cassistunit")
	private java.lang.String cassistunit;
	/**cbaseid*/
	@Excel(name = "cbaseid", width = 15)
    @ApiModelProperty(value = "cbaseid")
	private java.lang.String cbaseid;
	/**ccloseuserid*/
	@Excel(name = "ccloseuserid", width = 15)
    @ApiModelProperty(value = "ccloseuserid")
	private java.lang.String ccloseuserid;
	/**ccontractid*/
	@Excel(name = "ccontractid", width = 15)
    @ApiModelProperty(value = "ccontractid")
	private java.lang.String ccontractid;
	/**ccontractrowid*/
	@Excel(name = "ccontractrowid", width = 15)
    @ApiModelProperty(value = "ccontractrowid")
	private java.lang.String ccontractrowid;
	/**ccorrectrowid*/
	@Excel(name = "ccorrectrowid", width = 15)
    @ApiModelProperty(value = "ccorrectrowid")
	private java.lang.String ccorrectrowid;
	/**ccurrencytypeid*/
	@Excel(name = "ccurrencytypeid", width = 15)
    @ApiModelProperty(value = "ccurrencytypeid")
	private java.lang.String ccurrencytypeid;
	/**cdevaddrid*/
	@Excel(name = "cdevaddrid", width = 15)
    @ApiModelProperty(value = "cdevaddrid")
	private java.lang.String cdevaddrid;
	/**cdevareaid*/
	@Excel(name = "cdevareaid", width = 15)
    @ApiModelProperty(value = "cdevareaid")
	private java.lang.String cdevareaid;
	/**cecbillBid*/
	@Excel(name = "cecbillBid", width = 15)
    @ApiModelProperty(value = "cecbillBid")
	private java.lang.String cecbillBid;
	/**cecbillid*/
	@Excel(name = "cecbillid", width = 15)
    @ApiModelProperty(value = "cecbillid")
	private java.lang.String cecbillid;
	/**closingreason*/
	@Excel(name = "closingreason", width = 15)
    @ApiModelProperty(value = "closingreason")
	private java.lang.String closingreason;
	/**cmangid*/
	@Excel(name = "cmangid", width = 15)
    @ApiModelProperty(value = "cmangid")
	private java.lang.String cmangid;
	/**coperator*/
	@Excel(name = "coperator", width = 15)
    @ApiModelProperty(value = "coperator")
	private java.lang.String coperator;
	/**corderBid*/
	@Excel(name = "corderBid", width = 15)
    @ApiModelProperty(value = "corderBid")
	private java.lang.String corderBid;
	/**corderid*/
	@Excel(name = "corderid", width = 15)
    @ApiModelProperty(value = "corderid")
	private java.lang.String corderid;
	/**cpriceauditBb1id*/
	@Excel(name = "cpriceauditBb1id", width = 15)
    @ApiModelProperty(value = "cpriceauditBb1id")
	private java.lang.String cpriceauditBb1id;
	/**cpriceauditBid*/
	@Excel(name = "cpriceauditBid", width = 15)
    @ApiModelProperty(value = "cpriceauditBid")
	private java.lang.String cpriceauditBid;
	/**cpriceauditid*/
	@Excel(name = "cpriceauditid", width = 15)
    @ApiModelProperty(value = "cpriceauditid")
	private java.lang.String cpriceauditid;
	/**cprojectid*/
	@Excel(name = "cprojectid", width = 15)
    @ApiModelProperty(value = "cprojectid")
	private java.lang.String cprojectid;
	/**cprojectphaseid*/
	@Excel(name = "cprojectphaseid", width = 15)
    @ApiModelProperty(value = "cprojectphaseid")
	private java.lang.String cprojectphaseid;
	/**cqpbaseschemeid*/
	@Excel(name = "cqpbaseschemeid", width = 15)
    @ApiModelProperty(value = "cqpbaseschemeid")
	private java.lang.String cqpbaseschemeid;
	/**crowno*/
	@Excel(name = "crowno", width = 15)
    @ApiModelProperty(value = "crowno")
	private java.lang.String crowno;
	/**csourcebillid*/
	@Excel(name = "csourcebillid", width = 15)
    @ApiModelProperty(value = "csourcebillid")
	private java.lang.String csourcebillid;
	/**csourcebilltype*/
	@Excel(name = "csourcebilltype", width = 15)
    @ApiModelProperty(value = "csourcebilltype")
	private java.lang.String csourcebilltype;
	/**csourcerowid*/
	@Excel(name = "csourcerowid", width = 15)
    @ApiModelProperty(value = "csourcerowid")
	private java.lang.String csourcerowid;
	/**cupsourcebillid*/
	@Excel(name = "cupsourcebillid", width = 15)
    @ApiModelProperty(value = "cupsourcebillid")
	private java.lang.String cupsourcebillid;
	/**cupsourcebillrowid*/
	@Excel(name = "cupsourcebillrowid", width = 15)
    @ApiModelProperty(value = "cupsourcebillrowid")
	private java.lang.String cupsourcebillrowid;
	/**cupsourcebilltype*/
	@Excel(name = "cupsourcebilltype", width = 15)
    @ApiModelProperty(value = "cupsourcebilltype")
	private java.lang.String cupsourcebilltype;
	/**cusedeptid*/
	@Excel(name = "cusedeptid", width = 15)
    @ApiModelProperty(value = "cusedeptid")
	private java.lang.String cusedeptid;
	/**cvenddevaddrid*/
	@Excel(name = "cvenddevaddrid", width = 15)
    @ApiModelProperty(value = "cvenddevaddrid")
	private java.lang.String cvenddevaddrid;
	/**cvenddevareaid*/
	@Excel(name = "cvenddevareaid", width = 15)
    @ApiModelProperty(value = "cvenddevareaid")
	private java.lang.String cvenddevareaid;
	/**cwarehouseid*/
	@Excel(name = "cwarehouseid", width = 15)
    @ApiModelProperty(value = "cwarehouseid")
	private java.lang.String cwarehouseid;
	/**dclosedate*/
	@Excel(name = "dclosedate", width = 15)
    @ApiModelProperty(value = "dclosedate")
	private java.lang.String dclosedate;
	/**dconfirmdate*/
	@Excel(name = "dconfirmdate", width = 15)
    @ApiModelProperty(value = "dconfirmdate")
	private java.lang.String dconfirmdate;
	/**dcorrectdate*/
	@Excel(name = "dcorrectdate", width = 15)
    @ApiModelProperty(value = "dcorrectdate")
	private java.lang.String dcorrectdate;
	/**dplanarrvdate*/
	@Excel(name = "dplanarrvdate", width = 15)
    @ApiModelProperty(value = "dplanarrvdate")
	private java.lang.String dplanarrvdate;
	/**dr*/
	@Excel(name = "dr", width = 15)
    @ApiModelProperty(value = "dr")
	private java.lang.Integer dr;
	/**forderrowstatus*/
	@Excel(name = "forderrowstatus", width = 15)
    @ApiModelProperty(value = "forderrowstatus")
	private java.lang.Integer forderrowstatus;
	/**idiscounttaxtype*/
	@Excel(name = "idiscounttaxtype", width = 15)
    @ApiModelProperty(value = "idiscounttaxtype")
	private java.lang.Integer idiscounttaxtype;
	/**iisactive*/
	@Excel(name = "iisactive", width = 15)
    @ApiModelProperty(value = "iisactive")
	private java.lang.Integer iisactive;
	/**iisreplenish*/
	@Excel(name = "iisreplenish", width = 15)
    @ApiModelProperty(value = "iisreplenish")
	private java.lang.Integer iisreplenish;
	/**naccumarrvnum*/
	@Excel(name = "naccumarrvnum", width = 15)
    @ApiModelProperty(value = "naccumarrvnum")
	private java.math.BigDecimal naccumarrvnum;
	/**naccumdevnum*/
	@Excel(name = "naccumdevnum", width = 15)
    @ApiModelProperty(value = "naccumdevnum")
	private java.math.BigDecimal naccumdevnum;
	/**naccuminvoicenum*/
	@Excel(name = "naccuminvoicenum", width = 15)
    @ApiModelProperty(value = "naccuminvoicenum")
	private java.math.BigDecimal naccuminvoicenum;
	/**naccumrpnum*/
	@Excel(name = "naccumrpnum", width = 15)
    @ApiModelProperty(value = "naccumrpnum")
	private java.math.BigDecimal naccumrpnum;
	/**naccumstorenum*/
	@Excel(name = "naccumstorenum", width = 15)
    @ApiModelProperty(value = "naccumstorenum")
	private java.math.BigDecimal naccumstorenum;
	/**naccumwastnum*/
	@Excel(name = "naccumwastnum", width = 15)
    @ApiModelProperty(value = "naccumwastnum")
	private java.math.BigDecimal naccumwastnum;
	/**nassistnum*/
	@Excel(name = "nassistnum", width = 15)
    @ApiModelProperty(value = "nassistnum")
	private java.math.BigDecimal nassistnum;
	/**nbackarrvnum*/
	@Excel(name = "nbackarrvnum", width = 15)
    @ApiModelProperty(value = "nbackarrvnum")
	private java.math.BigDecimal nbackarrvnum;
	/**nbackstorenum*/
	@Excel(name = "nbackstorenum", width = 15)
    @ApiModelProperty(value = "nbackstorenum")
	private java.math.BigDecimal nbackstorenum;
	/**nconfirmnum*/
	@Excel(name = "nconfirmnum", width = 15)
    @ApiModelProperty(value = "nconfirmnum")
	private java.math.BigDecimal nconfirmnum;
	/**ndiscountrate*/
	@Excel(name = "ndiscountrate", width = 15)
    @ApiModelProperty(value = "ndiscountrate")
	private java.math.BigDecimal ndiscountrate;
	/**nexchangeotobrate*/
	@Excel(name = "nexchangeotobrate", width = 15)
    @ApiModelProperty(value = "nexchangeotobrate")
	private java.math.BigDecimal nexchangeotobrate;
	/**nfeemny*/
	@Excel(name = "nfeemny", width = 15)
    @ApiModelProperty(value = "nfeemny")
	private java.math.BigDecimal nfeemny;
	/**nmoney*/
	@Excel(name = "nmoney", width = 15)
    @ApiModelProperty(value = "nmoney")
	private java.math.BigDecimal nmoney;
	/**nordernum*/
	@Excel(name = "nordernum", width = 15)
    @ApiModelProperty(value = "nordernum")
	private java.math.BigDecimal nordernum;
	/**norgnettaxprice*/
	@Excel(name = "norgnettaxprice", width = 15)
    @ApiModelProperty(value = "norgnettaxprice")
	private java.math.BigDecimal norgnettaxprice;
	/**norgtaxprice*/
	@Excel(name = "norgtaxprice", width = 15)
    @ApiModelProperty(value = "norgtaxprice")
	private java.math.BigDecimal norgtaxprice;
	/**noriginalcurmny*/
	@Excel(name = "noriginalcurmny", width = 15)
    @ApiModelProperty(value = "noriginalcurmny")
	private java.math.BigDecimal noriginalcurmny;
	/**noriginalcurprice*/
	@Excel(name = "noriginalcurprice", width = 15)
    @ApiModelProperty(value = "noriginalcurprice")
	private java.math.BigDecimal noriginalcurprice;
	/**noriginalnetprice*/
	@Excel(name = "noriginalnetprice", width = 15)
    @ApiModelProperty(value = "noriginalnetprice")
	private java.math.BigDecimal noriginalnetprice;
	/**noriginaltaxmny*/
	@Excel(name = "noriginaltaxmny", width = 15)
    @ApiModelProperty(value = "noriginaltaxmny")
	private java.math.BigDecimal noriginaltaxmny;
	/**noriginaltaxpricemny*/
	@Excel(name = "noriginaltaxpricemny", width = 15)
    @ApiModelProperty(value = "noriginaltaxpricemny")
	private java.math.BigDecimal noriginaltaxpricemny;
	/**ntaxmny*/
	@Excel(name = "ntaxmny", width = 15)
    @ApiModelProperty(value = "ntaxmny")
	private java.math.BigDecimal ntaxmny;
	/**ntaxpricemny*/
	@Excel(name = "ntaxpricemny", width = 15)
    @ApiModelProperty(value = "ntaxpricemny")
	private java.math.BigDecimal ntaxpricemny;
	/**ntaxrate*/
	@Excel(name = "ntaxrate", width = 15)
    @ApiModelProperty(value = "ntaxrate")
	private java.math.BigDecimal ntaxrate;
	/**pkArrvcorp*/
	@Excel(name = "pkArrvcorp", width = 15)
    @ApiModelProperty(value = "pkArrvcorp")
	private java.lang.String pkArrvcorp;
	/**pkArrvstoorg*/
	@Excel(name = "pkArrvstoorg", width = 15)
    @ApiModelProperty(value = "pkArrvstoorg")
	private java.lang.String pkArrvstoorg;
	/**pkCorp*/
	@Excel(name = "pkCorp", width = 15)
    @ApiModelProperty(value = "pkCorp")
	private java.lang.String pkCorp;
	/**pkCreqwareid*/
	@Excel(name = "pkCreqwareid", width = 15)
    @ApiModelProperty(value = "pkCreqwareid")
	private java.lang.String pkCreqwareid;
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
	/**pkInvoicecorp*/
	@Excel(name = "pkInvoicecorp", width = 15)
    @ApiModelProperty(value = "pkInvoicecorp")
	private java.lang.String pkInvoicecorp;
	/**pkReqcorp*/
	@Excel(name = "pkReqcorp", width = 15)
    @ApiModelProperty(value = "pkReqcorp")
	private java.lang.String pkReqcorp;
	/**pkReqstoorg*/
	@Excel(name = "pkReqstoorg", width = 15)
    @ApiModelProperty(value = "pkReqstoorg")
	private java.lang.String pkReqstoorg;
	/**pkUpsrccorp*/
	@Excel(name = "pkUpsrccorp", width = 15)
    @ApiModelProperty(value = "pkUpsrccorp")
	private java.lang.String pkUpsrccorp;
	/**ts*/
	@Excel(name = "ts", width = 15)
    @ApiModelProperty(value = "ts")
	private java.lang.String ts;
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
	/**vecbilltype*/
	@Excel(name = "vecbilltype", width = 15)
    @ApiModelProperty(value = "vecbilltype")
	private java.lang.String vecbilltype;
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
	/**vmemo*/
	@Excel(name = "vmemo", width = 15)
    @ApiModelProperty(value = "vmemo")
	private java.lang.String vmemo;
	/**vpriceauditcode*/
	@Excel(name = "vpriceauditcode", width = 15)
    @ApiModelProperty(value = "vpriceauditcode")
	private java.lang.String vpriceauditcode;
	/**vproducenum*/
	@Excel(name = "vproducenum", width = 15)
    @ApiModelProperty(value = "vproducenum")
	private java.lang.String vproducenum;
	/**vreceiveaddress*/
	@Excel(name = "vreceiveaddress", width = 15)
    @ApiModelProperty(value = "vreceiveaddress")
	private java.lang.String vreceiveaddress;
	/**vvenddevaddr*/
	@Excel(name = "vvenddevaddr", width = 15)
    @ApiModelProperty(value = "vvenddevaddr")
	private java.lang.String vvenddevaddr;
	/**vvendinventorycode*/
	@Excel(name = "vvendinventorycode", width = 15)
    @ApiModelProperty(value = "vvendinventorycode")
	private java.lang.String vvendinventorycode;
	/**vvendinventoryname*/
	@Excel(name = "vvendinventoryname", width = 15)
    @ApiModelProperty(value = "vvendinventoryname")
	private java.lang.String vvendinventoryname;
	/**vvendorordercode*/
	@Excel(name = "vvendorordercode", width = 15)
    @ApiModelProperty(value = "vvendorordercode")
	private java.lang.String vvendorordercode;
	/**vvendororderrow*/
	@Excel(name = "vvendororderrow", width = 15)
    @ApiModelProperty(value = "vvendororderrow")
	private java.lang.String vvendororderrow;
}
