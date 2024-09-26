package com.agileboot.admin.controller.ban;


import cn.hutool.core.collection.CollectionUtil;
import com.agileboot.admin.customize.aop.accessLog.AccessLog;
import com.agileboot.common.core.dto.ResponseDTO;
import com.agileboot.common.core.page.AbstractPageQuery;
import com.agileboot.common.core.page.PageDTO;
import com.agileboot.common.enums.common.BusinessTypeEnum;
import com.agileboot.domain.ban.sch.BanApplicationService;
import com.agileboot.domain.ban.sch.command.AddSchCommand;
import com.agileboot.domain.ban.sch.db.BanSchDo;
import com.agileboot.domain.ban.sch.db.BanSchService;
import com.agileboot.domain.ban.sch.db.BanUserEntity;
import com.agileboot.domain.ban.sch.query.BanUserQuery;
import com.agileboot.domain.ban.sch.query.SearchBanQuery;
import com.agileboot.domain.system.menu.dto.MenuDTO;
import com.agileboot.domain.system.menu.query.MenuQuery;
import com.agileboot.domain.system.user.command.AddUserCommand;
import com.agileboot.domain.system.user.dto.UserDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.agileboot.common.core.base.BaseController;

import java.util.List;

/**
 * <p>
 * 人员排班记录表 前端控制器
 * </p>
 *
 * @author eric.deng
 * @since 2024-09-15
 */
@Tag(name = "排班api", description = "排班相关信息")
@RestController
@RequestMapping("/ban")
@RequiredArgsConstructor
public class BanSchController extends BaseController {

    private final BanApplicationService banSchService;

    @Operation(summary = "排班列表")
    @AccessLog(title = "查询排班", businessType = BusinessTypeEnum.OTHER)
    @GetMapping("/sch")
    public ResponseDTO<PageDTO<BanSchDo>> schList(SearchBanQuery<BanSchDo> query) {
        PageDTO<BanSchDo> page = banSchService.getSchList(query);
        return ResponseDTO.ok(page);
    }

    @Operation(summary = "新增排班")
    @AccessLog(title = "新增排班", businessType = BusinessTypeEnum.ADD)
    @PostMapping("/sch")
    public ResponseDTO<Void> add(@Validated @RequestBody AddSchCommand addSchCommand) {
        addSchCommand.setId(null);
        banSchService.saveOrUpdateSch(addSchCommand);
        return ResponseDTO.ok();
    }

    @Operation(summary = "修改排班")
    @AccessLog(title = "修改排班", businessType = BusinessTypeEnum.MODIFY)
    @PutMapping("/sch/{id}")
    public ResponseDTO<Void> update(@Validated @RequestBody AddSchCommand command) {
        banSchService.saveOrUpdateSch(command);
        return ResponseDTO.ok();
    }

    @Operation(summary = "排班人员列表")
    @AccessLog(title = "查询排班人员", businessType = BusinessTypeEnum.OTHER)
    @GetMapping("/user/list")
    public ResponseDTO<List<BanUserEntity>> getUserList(BanUserQuery<BanUserEntity> query) {
        List<BanUserEntity> list = banSchService.getUserList(query);
        return ResponseDTO.ok(list);
    }

}

