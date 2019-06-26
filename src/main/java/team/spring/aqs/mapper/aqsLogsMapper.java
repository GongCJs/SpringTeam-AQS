package team.spring.aqs.mapper;

import team.spring.aqs.entity.aqsLogs;

public interface aqsLogsMapper {
    int deleteByPrimaryKey(String logId);

    int insert(aqsLogs record);

    int insertSelective(aqsLogs record);

    aqsLogs selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(aqsLogs record);

    int updateByPrimaryKey(aqsLogs record);
}