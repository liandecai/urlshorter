package liande.cai.urlshorter.service;


/**   
 * Description:
 * @author liandecai
 * @time Jun 21, 2014
 */
public interface URLShorterService {
    
    public String getShortURL(String longURL);
    
    public String getLongUrl(String shortURL);
}
