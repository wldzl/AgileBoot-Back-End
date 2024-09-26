package com.agileboot.domain.ban.sch;


import cn.hutool.core.bean.BeanUtil;
import com.agileboot.common.core.page.PageDTO;
import com.agileboot.domain.ban.sch.command.AddSchCommand;
import com.agileboot.domain.ban.sch.db.*;
import com.agileboot.domain.ban.sch.query.BanUserQuery;
import com.agileboot.domain.ban.sch.query.SearchBanQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BanApplicationService {

    private final BanSchService banSchService;

    private final BanUserService banUserService;

    public PageDTO<BanSchDo> getSchList(SearchBanQuery<BanSchDo> query) {
        Page<BanSchDo> schPage = banSchService.getBanList(query);
        return new PageDTO<>(schPage.getRecords(), schPage.getTotal());
    }

    public void saveOrUpdateSch(AddSchCommand command) {
        BanSchEntity banSchEntity = new BanSchEntity();
        BeanUtil.copyProperties(command, banSchEntity);
        banSchEntity.insertOrUpdate();
    }

    public List<BanUserEntity> getUserList(BanUserQuery<BanUserEntity> query) {
        return banUserService.list(query.toQueryWrapper());
    }

}
