package org.jeecg.modules.link.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.link.entity.BdCorp;
import org.jeecg.modules.link.service.IBdCorpService;
import java.util.Date;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
 * @Description: 公司
 * @Author: jeecg-boot
 * @Date:   2024-02-23
 * @Version: V1.0
 */
@Slf4j
@Api(tags="公司")
@RestController
@RequestMapping("/link/bdCorp")
public class BdCorpController extends JeecgController<BdCorp, IBdCorpService> {
	@Autowired
	private IBdCorpService bdCorpService;
	
	/**
	 * 分页列表查询
	 *
	 * @param bdCorp
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "公司-分页列表查询")
	@ApiOperation(value="公司-分页列表查询", notes="公司-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(BdCorp bdCorp,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<BdCorp> queryWrapper = QueryGenerator.initQueryWrapper(bdCorp, req.getParameterMap());
		Page<BdCorp> page = new Page<BdCorp>(pageNo, pageSize);
		IPage<BdCorp> pageList = bdCorpService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 * 添加
	 *
	 * @param bdCorp
	 * @return
	 */
	@AutoLog(value = "公司-添加")
	@ApiOperation(value="公司-添加", notes="公司-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody BdCorp bdCorp) {
		bdCorpService.save(bdCorp);
		return Result.OK("添加成功！");
	}
	
	/**
	 * 编辑
	 *
	 * @param bdCorp
	 * @return
	 */
	@AutoLog(value = "公司-编辑")
	@ApiOperation(value="公司-编辑", notes="公司-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<?> edit(@RequestBody BdCorp bdCorp) {
		bdCorpService.updateById(bdCorp);
		return Result.OK("编辑成功!");
	}
	
	/**
	 * 通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "公司-通过id删除")
	@ApiOperation(value="公司-通过id删除", notes="公司-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		bdCorpService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 * 批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "公司-批量删除")
	@ApiOperation(value="公司-批量删除", notes="公司-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.bdCorpService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "公司-通过id查询")
	@ApiOperation(value="公司-通过id查询", notes="公司-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		BdCorp bdCorp = bdCorpService.getById(id);
		return Result.OK(bdCorp);
	}

  /**
   * 导出excel
   *
   * @param request
   * @param bdCorp
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, BdCorp bdCorp) {
      return super.exportXls(request, bdCorp, BdCorp.class, "公司");
  }

  /**
   * 通过excel导入数据
   *
   * @param request
   * @param response
   * @return
   */
  @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
  public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      return super.importExcel(request, response, BdCorp.class);
  }

}
