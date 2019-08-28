package team.spring.aqs.mapper;

import team.spring.aqs.entity.AqsLogs;

public interface aqsLogsMapper {
    int deleteByPrimaryKey(String logId);

    int insert(AqsLogs record);

    int insertSelective(AqsLogs record);

    AqsLogs selectByPrimaryKey(String logId);

    int updateByPrimaryKeySelective(AqsLogs record);

    int updateByPrimaryKey(AqsLogs record);
}