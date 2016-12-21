package com.jonney;

/** 
 *商品信息 
 * 
 * @author <a href="ls.zhaoxiangyu@gmail.com">zhao</> 
 * @date 2015-10-21 
 */  
public class Goods {  
    private String platform;  
    private String url;  
    private String name;  
    private Float price;  
    private Integer commit;  
      
    public Goods(){  
    }  
      
    public String getPlatform() {  
        return platform;  
    }  
  
    public void setPlatform(String platform) {  
        this.platform = platform;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public String getUrl() {  
        return url;  
    }  
    public void setUrl(String url) {  
        this.url = url;  
    }  
    public Float getPrice() {  
        return price;  
    }  
    public void setPrice(Float price) {  
        this.price = price;  
    }  
    public Integer getCommit() {  
        return commit;  
    }  
    public void setCommit(Integer commit) {  
        this.commit = commit;  
    }  
      
    @Override  
    public String toString() {  
        return "{platform="+platform+",url=" + url + ",name=" + name + ",price="  
                + price + ",commit=" + commit + "}";  
    }  
      
}  