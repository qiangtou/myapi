package cn.jiuling.distributedapi.dao.impl;

import org.springframework.stereotype.Repository;

import cn.jiuling.distributedapi.dao.FsrtaskDao;
import cn.jiuling.distributedapi.model.Fsrtask;

@Repository("fsrtaskDao")
public class FsrtaskDaoImpl extends BaseDaoImpl<Fsrtask> implements FsrtaskDao {

}
