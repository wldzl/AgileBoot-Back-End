package com.agileboot.domain.ban.sch.db;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 人员排班记录表 Mapper 接口
 * </p>
 *
 * @author eric.deng
 * @since 2024-09-15
 */
public interface BanSchMapper extends BaseMapper<BanSchEntity> {

    @Select("SELECT s.*, u.agent_name"
            + " FROM ban_sch s "
            + " LEFT JOIN ban_user u ON u.agent_id = s.agent_id "
            + " ${ew.customSqlSegment}")
    Page<BanSchDo> getBanList(Page<BanSchDo> page,
                                   @Param(Constants.WRAPPER) Wrapper<BanSchDo> queryWrapper);
}
