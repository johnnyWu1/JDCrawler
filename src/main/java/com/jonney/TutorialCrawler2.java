package com.jonney;

import org.jsoup.nodes.Document;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

/** 
 * 
 * WebCollector 2.x�汾��tutorial 
 * 2.x�汾���ԣ� 
 *   1���Զ���������ԣ�����ɸ�Ϊ���ӵı���ҵ�������ҳ��AJAX 
 *   2������Berkeley DB����URL�����Դ��������������ҳ 
 *   3������selenium�����Զ�javascript������Ϣ���г�ȡ 
 *   4��ֱ��֧�ֶ��������л� 
 *   5������spring jdbc��mysql connection���������ݳ־û� 
 *   6������json������ 
 *   7��ʹ��slf4j��Ϊ��־���� 
 *   8���޸�http����ӿڣ��û��Զ���http������ӷ��� 
 *  
 * ����cn.edu.hfut.dmic.webcollector.example�����ҵ�����(Demo) 
 *  
 * @author hu 
 * 
 * @author <a href="ls.zhaoxiangyu@gmail.com">zhao</> 
 * @date 2015-10-20 
 */  
public class TutorialCrawler2 extends BreadthCrawler {  
  
    /** 
     * ���autoParse����Ϊtrue�����������Զ�����ҳ���з�����������ӣ����������ȡ���񣬷����Զ��������ӡ� 
     * 
     * @param crawlPath 
     * @param autoParse 
     */  
    public TutorialCrawler2(String crawlPath, boolean autoParse) {  
        super(crawlPath, autoParse);  
          
        /*BreadthCrawler����ֱ�����URL�������*/  
        this.addRegex("http://item.jd.com/.*.html");  
//        this.addRegex("http://.*zhihu.com/.*");  
//        this.addRegex("-.*jpg.*");  
    }  
  
    /** 
     *�û��Զ����ÿ��ҳ��Ĳ�����һ�㽫��ȡ���־û��Ȳ���д��visit�����С� 
     * 
     * @param page 
     * @param nextLinks ��Ҫ������ȡ��URL�����autoParseΪtrue��������Զ���ȡ������������Ӳ�����nextLinks�� 
     */  
      
    public static void main(String[] args) throws Exception {  
         /* 
        ��һ�������������crawlPath��crawlPath��ά��URL��Ϣ���ļ��е�·�������������Ҫ�ϵ���ȡ��ÿ����ѡ����ͬ��crawlPath 
        �ڶ���������ʾ�Ƿ��Զ���ȡ������������Ӳ������������ 
     */  
     TutorialCrawler2 crawler = new TutorialCrawler2("D:/test/crawler/demo",true);  
     crawler.setThreads(50);  
     crawler.addSeed("http://list.jd.com/list.html?cat=1319,1523,7052&page=1&go=0&JL=6_0_0");  
//     crawler.addSeed("http://www.zhihu.com/");  
  
     /* 
     //requester�Ǹ�����http����Ĳ��������ͨ��requester�еķ�����ָ��http/socks���� 
     HttpRequesterImpl requester=(HttpRequesterImpl) crawler.getHttpRequester();     
     
     //������ 
     requester.setProxy("127.0.0.1", 1080,Proxy.Type.SOCKS); 
      
     //�������� 
     RandomProxyGenerator proxyGenerator=new RandomProxyGenerator(); 
     proxyGenerator.addProxy("127.0.0.1",8080,Proxy.Type.SOCKS); 
     requester.setProxyGenerator(proxyGenerator); 
     */  
  
  
     /*�����Ƿ�ϵ���ȡ*/  
     crawler.setResumable(false);  
     /*����ÿ����ȡ��ȡ�����URL����*/  
     crawler.setTopN(1000);  
  
     /*���ϣ�������ܵ���ȡ�������������һ���ܴ�������������û�д���ȡURLʱ�Զ�ֹͣ*/  
     crawler.start(2);  
    }

	@SuppressWarnings("deprecation")
	public void visit(Page page, CrawlDatums arg1) {
		Document doc=page.getDoc();
        String title = doc.title();  
        System.out.println("URL:" + page.getUrl() + "   标题:" + title);  
//        System.out.println(doc.html()); 
        
        
		
		
          
        /* 
        //��ӵ�nextLinks�����ӻ�����һ�����x�㱻��ȡ��������Զ���URL����ȥ�أ������û��ڱ�д����ʱ��ȫ���ؿ��������ظ�URL�����⡣ 
        //���������ӵ������Ѿ�����ȡ���������Ӳ����ں��������б���ȡ 
        //�����Ҫǿ���������ȡ�������ӣ�ֻ�������������������ϵ�������ʱ��ͨ��Crawler.addForcedSeedǿ�Ƽ���URL�� 
         nextLinks.add("http://www.csdn.net"); 
        */  
	}  
}  