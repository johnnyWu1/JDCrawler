package com.jonney;

import java.util.concurrent.atomic.AtomicInteger;

import com.jonney.util.PageUtils;

import cn.edu.hfut.dmic.webcollector.example.DemoDepthCrawler;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;
import cn.edu.hfut.dmic.webcollector.net.HttpResponse;
import cn.edu.hfut.dmic.webcollector.util.RegexRule;

/** 
 *电商平台爬虫 
 * 
 * @author <a href="ls.zhaoxiangyu@gmail.com">zhao</> 
 * @date 2015-10-20 
 */  
public abstract class ECCrawler extends DemoDepthCrawler {  
      
    private String seedFormat;//种子格式化   
    protected RegexRule regexRule;  
      
    public RegexRule getRegexRule() {  
        return regexRule;  
    }  
    public void setRegexRule(RegexRule regexRule) {  
        this.regexRule = regexRule;  
    }  
    public void addRegex(String urlRegex) {  
        this.regexRule.addRule(urlRegex);  
    }  
    public ECCrawler(String crawlPath,String seedFormat ){  
        super(crawlPath, true);  
        this.seedFormat=seedFormat;  
        this.regexRule=new RegexRule();  
    }  
      
    /*用一个自增id来生成唯一文件名*/  
    AtomicInteger id=new AtomicInteger(0);  
      
    
    
    @Override
	public void visit(Page page, CrawlDatums next) {
		// TODO Auto-generated method stub
    	
        String conteType = page.getResponse().getContentType();  
        if (conteType != null && conteType.contains("text/html")) {  
            org.jsoup.nodes.Document doc = page.getDoc();  
            if (doc != null) 
            	next.add(page.getLinks("a"));
        }  
        try {  
            _visit(page, next);  
        } catch (Exception ex) {  
            LOG.info("Exception", ex);  
        }  
    	
	}
    
    
    
	
	public abstract void _visit(Page page, CrawlDatums links);
	
	
    @Override  
    public void start(int depth) throws Exception {  
        addSeed();  
        super.start(depth);  
    }  
    /** 
     * add seed 
     * 
     * @throws Exception 
     */  
    private void addSeed() throws Exception{  
        int totalPage=getTotalPage(getPage(getSeed(seedFormat, 1)));  
        for(int page=1;page<=totalPage;page++){  
            this.addSeed(getSeed(seedFormat, page));  
        }  
    }  
      
    /** 
     * 根据url获取Page实例 
     * 
     * @param url 
     * @return 
     * @throws Exception 
     */  
    private Page getPage(String url) throws Exception {  
        HttpRequest httpRequest = new HttpRequest(url);  
        HttpResponse response = httpRequest.getResponse();  
        Page page = new Page(null, response);  
//        page.setUrl(url);  
        page.setHtml(response.getHtmlByCharsetDetect());  
        page.setResponse(response);  
        return page;  
    }  
    

      
    /** 
     *获取查询商品总页数 
     * 
     * @return 
     */  
    public abstract int getTotalPage(Page page);  
      
    /** 
     * 获取seed url 
     * 
     * @param seedFormat 
     * @param page 
     * @return 
     */  
    public String getSeed(String seedFormat,Object ... page){  
        return String.format(seedFormat, page);  
    }  
      
}  