package liande.cai.urlshorter.web.controler;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import liande.cai.urlshorter.service.URLShorterService;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Strings;

/**   
 * Description:
 * @author liandecai
 * @time Jun 21, 2014
 */
@Controller
public class HomeControler {

    @Resource
    private URLShorterService urlShorterService;
    
    
    @RequestMapping(value="get.do")
    @ResponseBody
    public String get(@RequestParam(value="longUrl") String longUrl){
        
        return urlShorterService.getShortURL(longUrl);
    }
    
    
    @RequestMapping(value="/{shortUrl}")
    @ResponseBody
    public String disp(@PathVariable(value="shortUrl") String shortUrl, HttpServletResponse response) throws IOException{
        String longUrl = urlShorterService.getLongUrl(shortUrl);
        if(Strings.isNullOrEmpty(longUrl)){
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
          response.setStatus(HttpServletResponse.SC_FOUND);
          response.setHeader("location", longUrl);
        }
        return "";
    }
    
    
}
