package com.agileboot.domain.ban.sch.db;

import com.agileboot.common.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 人员排班记录表
 * </p>
 *
 * @author eric.deng
 * @since 2024-09-15
 */
@Getter
@Setter
@TableName("ban_sch")
@ApiModel(value = "BanSchEntity对象", description = "人员排班记录表")
public class BanSchEntity extends BaseEntity<BanSchEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "agent_id", updateStrategy = FieldStrategy.NEVER)
    private String agentId;

    @TableField(value = "sch_date", updateStrategy = FieldStrategy.NEVER)
    private String schDate;

    @TableField("ban_name")
    private String banName;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
