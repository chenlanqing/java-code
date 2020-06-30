//package com.blue.fish.design.pattern.structural.proxy.db;
//
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
///**
// * @author bluefish 2018/12/1
// * @version 1.0.0
// */
//public class DynamicDatasource extends AbstractRoutingDataSource{
//    @Override
//    protected Object determineCurrentLookupKey() {
//        return DataSourceContextHolder.getDBType();
//    }
//}
