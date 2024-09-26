package com.agileboot.domain.ban.sch.db;


import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BanSchDo extends BanSchEntity{

    private String agentName;
}
