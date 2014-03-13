package cn.jiuling.distributedapi.dao.impl;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.ScheduletasksDao;
import cn.jiuling.distributedapi.model.Scheduletasks;

@Repository("scheduletasksDao")
public class ScheduletasksDaoImpl extends BaseDaoImpl<Scheduletasks> implements ScheduletasksDao {

}
