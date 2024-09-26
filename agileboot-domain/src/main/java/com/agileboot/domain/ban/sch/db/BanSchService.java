package com.agileboot.domain.ban.sch.db;

import com.agileboot.domain.ban.sch.query.SearchBanQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 人员排班记录表 服务类
 * </p>
 *
 * @author eric.deng
 * @since 2024-09-15
 */
public interface BanSchService extends IService<BanSchEntity> {


    Page<BanSchDo> getBanList(SearchBanQuery<BanSchDo> query);

    void insert(BanSchEntity banSchEntity);
}
