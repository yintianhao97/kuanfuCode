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
import org.jeecg.modules.link.entity.FukuanLink;
import org.jeecg.modules.link.service.IFukuanLinkService;
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
 * @Description: 付款单同步
 * @Author: jeecg-boot
 * @Date:   2024-02-27
 * @Version: V1.0
 */
@Slf4j
@Api(tags="付款单同步")
@RestController
@RequestMapping("/link/fukuanLink")
public class FukuanLinkController extends JeecgController<FukuanLink, IFukuanLinkService> {
	@Autowired
	private IFukuanLinkService fukuanLinkService;
	
	/**
	 * 分页列表查询
	 *
	 * @param fukuanLink
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "付款单同步-分页列表查询")
	@ApiOperation(value="付款单同步-分页列表查询", notes="付款单同步-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(FukuanLink fukuanLink,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<FukuanLink> queryWrapper = QueryGenerator.initQueryWrapper(fukuanLink, req.getParameterMap());
		Page<FukuanLink> page = new Page<FukuanLink>(pageNo, pageSize);
		IPage<FukuanLink> pageList = fukuanLinkService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 * 添加
	 *
	 * @param fukuanLink
	 * @return
	 */
	@AutoLog(value = "付款单同步-添加")
	@ApiOperation(value="付款单同步-添加", notes="付款单同步-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody FukuanLink fukuanLink) {
		fukuanLinkService.save(fukuanLink);
		return Result.OK("添加成功！");
	}
	
	/**
	 * 编辑
	 *
	 * @param fukuanLink
	 * @return
	 */
	@AutoLog(value = "付款单同步-编辑")
	@ApiOperation(value="付款单同步-编辑", notes="付款单同步-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<?> edit(@RequestBody FukuanLink fukuanLink) {
		fukuanLinkService.updateById(fukuanLink);
		return Result.OK("编辑成功!");
	}
	
	/**
	 * 通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "付款单同步-通过id删除")
	@ApiOperation(value="付款单同步-通过id删除", notes="付款单同步-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		fukuanLinkService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 * 批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "付款单同步-批量删除")
	@ApiOperation(value="付款单同步-批量删除", notes="付款单同步-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.fukuanLinkService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "付款单同步-通过id查询")
	@ApiOperation(value="付款单同步-通过id查询", notes="付款单同步-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		FukuanLink fukuanLink = fukuanLinkService.getById(id);
		return Result.OK(fukuanLink);
	}

  /**
   * 导出excel
   *
   * @param request
   * @param fukuanLink
   */
  @RequestMapping(value = "/exportXls")
  public ModelAndView exportXls(HttpServletRequest request, FukuanLink fukuanLink) {
      return super.exportXls(request, fukuanLink, FukuanLink.class, "付款单同步");
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
      return super.importExcel(request, response, FukuanLink.class);
  }

}
