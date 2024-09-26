package com.agileboot.domain.ban.sch.query;

import cn.hutool.core.util.StrUtil;
import com.agileboot.common.core.page.AbstractPageQuery;
import com.agileboot.common.core.page.AbstractQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 当出现复用Query的情况，我们需要把泛型加到类本身，通过传入类型 来进行复用
 * @author valarchie
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BanUserQuery<T> extends AbstractQuery<T> {

    protected String agentId;
    protected String agentName;



    @Override
    public QueryWrapper<T> addQueryCondition() {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();

        queryWrapper.like(StrUtil.isNotEmpty(agentName), "agent_name", agentName)
            .eq(StrUtil.isNotBlank(agentId) , "agent_id", agentId)
            .eq("deleted", 0);


        // 设置排序字段
        this.timeRangeColumn = "agent_name";

        return queryWrapper;
    }
}
