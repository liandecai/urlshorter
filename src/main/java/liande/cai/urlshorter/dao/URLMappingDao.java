package liande.cai.urlshorter.dao;

import java.util.Map;

import liande.cai.urlshorter.model.URLInfo;

import org.springframework.stereotype.Repository;

/**
 * Description:
 * 
 * @author liandecai
 * @time Jun 21, 2014
 */
@Repository
public interface URLMappingDao {

    public int insert(URLInfo urlInfo);

    public URLInfo query(Map<String, Object> map);

}
