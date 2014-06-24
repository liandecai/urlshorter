package liande.cai.urlshorter.service;

import java.util.Map;

import javax.annotation.Resource;

import liande.cai.urlshorter.dao.URLMappingDao;
import liande.cai.urlshorter.model.URLInfo;
import liande.cai.urlshorter.tool.Base62Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

/**
 * Description:
 * 
 * @author liandecai
 * @time Jun 21, 2014
 */
@Service
public class URLShorterServiceImpl implements URLShorterService {
    private static final Logger logger = LoggerFactory.getLogger(URLShorterService.class);
    
    private static final String PRE_HTTP = "http://";
    private static final String PRE_HTTPS ="https://";

    @Resource
    private URLMappingDao urlMappingDao;
    
    public String formatUrl(String url) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(url));
        //统一使用http
        return url.startsWith(PRE_HTTP) || url.startsWith(PRE_HTTPS) ? url : PRE_HTTP + url;
    }
    @Override
    public String getShortURL(String longURL) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(longURL));
        
        longURL = formatUrl(longURL);
        
        logger.debug("longURL:{}", longURL);
        Map<String, Object> map = Maps.newHashMap();
        map.put("longUrl", longURL);
        URLInfo urlInfo = urlMappingDao.query(map);
        
        if (urlInfo == null) {
            urlInfo = new URLInfo(longURL);
            urlMappingDao.insert(urlInfo);
            logger.debug("insert id {}", urlInfo.getId());
        }
        
        return Base62Converter.dec2base62(urlInfo.getId());
    }

    @Override
    public String getLongUrl(String shortURL) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", Base62Converter.base622dec(shortURL));
        URLInfo urlInfo = urlMappingDao.query(map);
        return urlInfo == null ? "" : urlInfo.getLongUrl();
    }

}
