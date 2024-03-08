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
 * @Description: 公司
 * @Author: jeecg-boot
 * @Date:   2024-02-23
 * @Version: V1.0
 */
@Data
@TableName("bd_corp")
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="bd_corp对象", description="公司")
public class BdCorp {
    
	/**begindate*/
	@Excel(name = "begindate", width = 15)
    @ApiModelProperty(value = "begindate")
	private java.lang.String begindate;
	/**briefintro*/
	@Excel(name = "briefintro", width = 15)
    @ApiModelProperty(value = "briefintro")
	private java.lang.String briefintro;
	/**busibegindate*/
	@Excel(name = "busibegindate", width = 15)
    @ApiModelProperty(value = "busibegindate")
	private java.lang.String busibegindate;
	/**busienddate*/
	@Excel(name = "busienddate", width = 15)
    @ApiModelProperty(value = "busienddate")
	private java.lang.String busienddate;
	/**chargedeptcode*/
	@Excel(name = "chargedeptcode", width = 15)
    @ApiModelProperty(value = "chargedeptcode")
	private java.lang.String chargedeptcode;
	/**chargedeptname*/
	@Excel(name = "chargedeptname", width = 15)
    @ApiModelProperty(value = "chargedeptname")
	private java.lang.String chargedeptname;
	/**citycounty*/
	@Excel(name = "citycounty", width = 15)
    @ApiModelProperty(value = "citycounty")
	private java.lang.String citycounty;
	/**corptype*/
	@Excel(name = "corptype", width = 15)
    @ApiModelProperty(value = "corptype")
	private java.lang.String corptype;
	/**countryarea*/
	@Excel(name = "countryarea", width = 15)
    @ApiModelProperty(value = "countryarea")
	private java.lang.String countryarea;
	/**createdate*/
	@Excel(name = "createdate", width = 15)
    @ApiModelProperty(value = "createdate")
	private java.lang.String createdate;
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
	/**ecotype*/
	@Excel(name = "ecotype", width = 15)
    @ApiModelProperty(value = "ecotype")
	private java.lang.String ecotype;
	/**email1*/
	@Excel(name = "email1", width = 15)
    @ApiModelProperty(value = "email1")
	private java.lang.String email1;
	/**email2*/
	@Excel(name = "email2", width = 15)
    @ApiModelProperty(value = "email2")
	private java.lang.String email2;
	/**email3*/
	@Excel(name = "email3", width = 15)
    @ApiModelProperty(value = "email3")
	private java.lang.String email3;
	/**enddate*/
	@Excel(name = "enddate", width = 15)
    @ApiModelProperty(value = "enddate")
	private java.lang.String enddate;
	/**fathercorp*/
	@Excel(name = "fathercorp", width = 15)
    @ApiModelProperty(value = "fathercorp")
	private java.lang.String fathercorp;
	/**fax1*/
	@Excel(name = "fax1", width = 15)
    @ApiModelProperty(value = "fax1")
	private java.lang.String fax1;
	/**fax2*/
	@Excel(name = "fax2", width = 15)
    @ApiModelProperty(value = "fax2")
	private java.lang.String fax2;
	/**foreignname*/
	@Excel(name = "foreignname", width = 15)
    @ApiModelProperty(value = "foreignname")
	private java.lang.String foreignname;
	/**holdflag*/
	@Excel(name = "holdflag", width = 15)
    @ApiModelProperty(value = "holdflag")
	private java.lang.String holdflag;
	/**idnumber*/
	@Excel(name = "idnumber", width = 15)
    @ApiModelProperty(value = "idnumber")
	private java.lang.String idnumber;
	/**industry*/
	@Excel(name = "industry", width = 15)
    @ApiModelProperty(value = "industry")
	private java.lang.String industry;
	/**innercode*/
	@Excel(name = "innercode", width = 15)
    @ApiModelProperty(value = "innercode")
	private java.lang.String innercode;
	/**ishasaccount*/
	@Excel(name = "ishasaccount", width = 15)
    @ApiModelProperty(value = "ishasaccount")
	private java.lang.String ishasaccount;
	/**isseal*/
	@Excel(name = "isseal", width = 15)
    @ApiModelProperty(value = "isseal")
	private java.lang.String isseal;
	/**isuseretail*/
	@Excel(name = "isuseretail", width = 15)
    @ApiModelProperty(value = "isuseretail")
	private java.lang.String isuseretail;
	/**isworkingunit*/
	@Excel(name = "isworkingunit", width = 15)
    @ApiModelProperty(value = "isworkingunit")
	private java.lang.String isworkingunit;
	/**legalbodycode*/
	@Excel(name = "legalbodycode", width = 15)
    @ApiModelProperty(value = "legalbodycode")
	private java.lang.String legalbodycode;
	/**linkman1*/
	@Excel(name = "linkman1", width = 15)
    @ApiModelProperty(value = "linkman1")
	private java.lang.String linkman1;
	/**linkman2*/
	@Excel(name = "linkman2", width = 15)
    @ApiModelProperty(value = "linkman2")
	private java.lang.String linkman2;
	/**linkman3*/
	@Excel(name = "linkman3", width = 15)
    @ApiModelProperty(value = "linkman3")
	private java.lang.String linkman3;
	/**maxinnercode*/
	@Excel(name = "maxinnercode", width = 15)
    @ApiModelProperty(value = "maxinnercode")
	private java.lang.String maxinnercode;
	/**memo*/
	@Excel(name = "memo", width = 15)
    @ApiModelProperty(value = "memo")
	private java.lang.String memo;
	/**ownersharerate*/
	@Excel(name = "ownersharerate", width = 15)
    @ApiModelProperty(value = "ownersharerate")
	private java.math.BigDecimal ownersharerate;
	/**phone1*/
	@Excel(name = "phone1", width = 15)
    @ApiModelProperty(value = "phone1")
	private java.lang.String phone1;
	/**phone2*/
	@Excel(name = "phone2", width = 15)
    @ApiModelProperty(value = "phone2")
	private java.lang.String phone2;
	/**phone3*/
	@Excel(name = "phone3", width = 15)
    @ApiModelProperty(value = "phone3")
	private java.lang.String phone3;
	/**pkCorp*/
	@Excel(name = "pkCorp", width = 15)
    @ApiModelProperty(value = "pkCorp")
	private java.lang.String pkCorp;
	/**pkCorpkind*/
	@Excel(name = "pkCorpkind", width = 15)
    @ApiModelProperty(value = "pkCorpkind")
	private java.lang.String pkCorpkind;
	/**pkCurrency*/
	@Excel(name = "pkCurrency", width = 15)
    @ApiModelProperty(value = "pkCurrency")
	private java.lang.String pkCurrency;
	/**postaddr*/
	@Excel(name = "postaddr", width = 15)
    @ApiModelProperty(value = "postaddr")
	private java.lang.String postaddr;
	/**province*/
	@Excel(name = "province", width = 15)
    @ApiModelProperty(value = "province")
	private java.lang.String province;
	/**regcapital*/
	@Excel(name = "regcapital", width = 15)
    @ApiModelProperty(value = "regcapital")
	private java.math.BigDecimal regcapital;
	/**region*/
	@Excel(name = "region", width = 15)
    @ApiModelProperty(value = "region")
	private java.lang.String region;
	/**saleaddr*/
	@Excel(name = "saleaddr", width = 15)
    @ApiModelProperty(value = "saleaddr")
	private java.lang.String saleaddr;
	/**sealeddate*/
	@Excel(name = "sealeddate", width = 15)
    @ApiModelProperty(value = "sealeddate")
	private java.lang.String sealeddate;
	/**showorder*/
	@Excel(name = "showorder", width = 15)
    @ApiModelProperty(value = "showorder")
	private java.lang.Integer showorder;
	/**taxcode*/
	@Excel(name = "taxcode", width = 15)
    @ApiModelProperty(value = "taxcode")
	private java.lang.String taxcode;
	/**taxpayertype*/
	@Excel(name = "taxpayertype", width = 15)
    @ApiModelProperty(value = "taxpayertype")
	private java.lang.Integer taxpayertype;
	/**tenantNo*/
	@Excel(name = "tenantNo", width = 15)
    @ApiModelProperty(value = "tenantNo")
	private java.lang.String tenantNo;
	/**ts*/
	@Excel(name = "ts", width = 15)
    @ApiModelProperty(value = "ts")
	private java.lang.String ts;
	/**unitcode*/
	@Excel(name = "unitcode", width = 15)
    @ApiModelProperty(value = "unitcode")
	private java.lang.String unitcode;
	/**unitdistinction*/
	@Excel(name = "unitdistinction", width = 15)
    @ApiModelProperty(value = "unitdistinction")
	private java.lang.String unitdistinction;
	/**unitname*/
	@Excel(name = "unitname", width = 15)
    @ApiModelProperty(value = "unitname")
	private java.lang.String unitname;
	/**unitshortname*/
	@Excel(name = "unitshortname", width = 15)
    @ApiModelProperty(value = "unitshortname")
	private java.lang.String unitshortname;
	/**url*/
	@Excel(name = "url", width = 15)
    @ApiModelProperty(value = "url")
	private java.lang.String url;
	/**zipcode*/
	@Excel(name = "zipcode", width = 15)
    @ApiModelProperty(value = "zipcode")
	private java.lang.String zipcode;
}
