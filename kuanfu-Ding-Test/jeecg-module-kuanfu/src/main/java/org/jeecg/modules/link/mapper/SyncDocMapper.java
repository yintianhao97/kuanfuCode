package org.jeecg.modules.link.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.jeecg.modules.link.entity.LinkPriceList;
import org.jeecg.modules.link.entity.SyncDoc;

@DS("EWAY")
public interface SyncDocMapper extends BaseMapper<SyncDoc> {
    @Insert("insert into sync_doc (number) values (#{number})")
    int uptadeSyncStatus(String number);
}
