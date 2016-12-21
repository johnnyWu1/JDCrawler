package com.jonney;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;

/** 
 *JD 爬虫 
 * 
 * @author <a href="ls.zhaoxiangyu@gmail.com">zhao</> 
 * @date 2015-10-20 
 */  
public class JDCrawler extends ECCrawler {  
  
    private JDGoodsList goodsList;  
      
    /** 
     * 
     * 
     * @param crawlPath 
     * @param seekFormat 
     */  
    public JDCrawler(String crawlPath, String seekFormat) {  
        super(crawlPath, seekFormat);  
        goodsList=new JDGoodsList();  
    }  
  
    @Override  
    public int getTotalPage(Page page) {  
//      Element ele=page.getDoc().select("div#J_bottomPage").select("span.p-skip >em").first().select("b").first();  
//      return ele==null?0:Integer.parseInt(ele.text());  
        return 1;  
    }  
  
    @Override  
    public void _visit(Page page, CrawlDatums links) {  
        System.out.println("url:"+page.getUrl()+"\tlinks size:"+links.size());  
        goodsList.addGoods(page);  
    }  
      
    public static void main(String[] args) throws Exception  {  
        JDCrawler crawler=new JDCrawler("D:/test/crawler/jd/", "http://list.jd.com/list.html?cat=1319,1523,7052&page=1&trans=1&JL=4_1_0");  
        crawler.setThreads(100);//抓取启动线程数  
        crawler.start(1);//层数  
          
        crawler.print(); 
        
    }  
      
    protected void print(){  
    	System.out.println("Size:"+goodsList.size());
        for(Goods g:goodsList){  
            System.out.println(g);  
        }  
    }

	
}  