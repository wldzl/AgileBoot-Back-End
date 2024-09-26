package com.agileboot.domain.ban.sch.db;

import com.agileboot.domain.ban.sch.query.SearchBanQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人员排班记录表 服务实现类
 * </p>
 *
 * @author eric.deng
 * @since 2024-09-15
 */
@Service
public class BanSchServiceImpl extends ServiceImpl<BanSchMapper, BanSchEntity> implements BanSchService {

    @Override
    public Page<BanSchDo> getBanList(SearchBanQuery<BanSchDo> query) {
        return baseMapper.getBanList(query.toPage(), query.toQueryWrapper());
    }

    @Override
    public void insert(BanSchEntity banSchEntity) {
        banSchEntity.insert();
    }


}
