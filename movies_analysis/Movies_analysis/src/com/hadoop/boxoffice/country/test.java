package com.hadoop.boxoffice.country;

public class test {
   public static void main(String[] args) {
       String a = "4.56684E+15,Js2RljYaN,有#青岛理工大学#同学投稿：学校目前处于封闭，但又接受校外人员入校考试，引部分同学吐槽……#青岛理工大学现状##校园曝光台# （来源投稿） ,\"https://wx3.sinaimg.cn/large/0073PBJugy1gkavn8in33j30i20bfabh.jpg,https://wx1.sinaimg.cn/large/0073PBJugy1gkavn90xdzj30hw0qumzb.jpg,https://wx2.sinaimg.cn/large/0073PBJugy1gkavn9piafj31400u046y.jpg,https://wx1.sinaimg.cn/large/0073PBJugy1gkavnai4lgj30u014010r.jpg,https://wx4.sinaimg.cn/large/0073PBJugy1gkavn809zjj31400u07ef.jpg\",,,2020/11/2,逢考必过的iPhone SE,51,13,7,\"青岛理工大学,青岛理工大学现状,校园曝光台\",";
	   for(int i=0 ;i<a.split(",").length;i++) {
    	   System.out.println(a.split(",")[i]);
    	   
       }
       System.out.println(a.split(",").length);
   }
}
