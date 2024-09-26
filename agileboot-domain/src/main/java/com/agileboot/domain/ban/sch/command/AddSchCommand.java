package com.agileboot.domain.ban.sch.command;

import com.agileboot.common.annotation.ExcelColumn;
import lombok.Data;

@Data
public class AddSchCommand {

    private Long id;

    @ExcelColumn(name = "工号")
    private String agentId;

    @ExcelColumn(name = "日期")
    private String schDate;

    @ExcelColumn(name = "班次")
    private String banName;
}
