package cn.jiuling.distributedapi.dao.impl;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.VlprTaskDao;
import cn.jiuling.distributedapi.model.VlprTask;

@Repository("vlprTaskDao")
public class VlprTaskDaoImpl extends BaseDaoImpl<VlprTask> implements VlprTaskDao {

}
