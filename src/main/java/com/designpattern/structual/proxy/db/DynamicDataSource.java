package com.designpattern.structual.proxy.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author liugaoyang
 * @version 1.0.0
 * @description 动态数据源
 * @date 2019/12/8 23:31
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    // 返回值代表当前线程使用哪个DataSource
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDBtype();
    }
}
