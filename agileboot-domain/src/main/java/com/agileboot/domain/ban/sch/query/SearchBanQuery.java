package com.agileboot.domain.ban.sch.query;

import cn.hutool.core.util.StrUtil;
import com.agileboot.common.core.page.AbstractPageQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 当出现复用Query的情况，我们需要把泛型加到类本身，通过传入类型 来进行复用
 * @author valarchie
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SearchBanQuery<T> extends AbstractPageQuery<T> {

    protected String agentId;
    protected String agentName;
    protected String startTime;
    protected String finishTime;
    protected String schName;


    @Override
    public QueryWrapper<T> addQueryCondition() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StrUtil.isNotEmpty(agentName), "u.agent_name", agentName)
            .eq(StrUtil.isNotBlank(agentId) , "s.agent_id", agentId)
            .like(StrUtil.isNotBlank(schName), "s.ban_name", schName)
                .ge(StrUtil.isNotBlank(startTime), "s.sch_date", startTime)
                .le(StrUtil.isNotBlank(finishTime), "s.sch_date", finishTime)
            .eq("s.deleted", 0);


        // 设置排序字段
        this.timeRangeColumn = "s.sch_date";

        if (this.pageNum == null) {
            this.pageNum = 1;
        }
        if (this.pageSize == null) {
            this.pageSize = 10;
        }

        return queryWrapper;
    }
}
