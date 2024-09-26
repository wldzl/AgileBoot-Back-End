package com.agileboot.domain.ban.sch.db;

import com.agileboot.common.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 排班人员表
 * </p>
 *
 * @author eric.deng
 * @since 2024-09-15
 */
@Getter
@Setter
@TableName("ban_user")
@ApiModel(value = "BanUserEntity对象", description = "排班人员表")
public class BanUserEntity extends BaseEntity<BanUserEntity> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("agent_id")
    private String agentId;

    @TableField("agent_name")
    private String agentName;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
