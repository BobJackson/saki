# 简单的Saki Code后端接口实现

## 架构
使用 整洁架构

## Dao层尝试使用了Redis和Postgresql两种实现，可以切换

## 通过配置实现无缝切换
修改application.properties 文件vocabularyRepositoryImpl的值


## 反思
尽管代码是简单，不复杂的，但是我看到了设计中的一些渐进性，逐步完善的过程。当然也与经验有关，比如一开始就可以想到createdTime和updatedTime，
而不需要在写完list之后，才发现有排序的需求。（页面展示的只是一部分数据）