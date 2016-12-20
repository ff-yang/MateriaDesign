package com.example.xinyu.testsome.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/10/28.
 */

public class NewsEntity {

    /**
     * date : 20161028
     * stories : [{"images":["http://pic2.zhimg.com/038031c3f24ebaa2cb3b10198d5909a1.jpg"],"type":0,"id":8928061,"ga_prefix":"102815","title":"老板说要加薪，我赶紧思考了一下这对经济的影响"},{"images":["http://pic2.zhimg.com/835b6e1e0c425bd0d6d0e892f1aa7061.jpg"],"type":0,"id":8927920,"ga_prefix":"102814","title":"把新电脑功能键换成了屏幕，其实苹果早就想对键盘下手了"},{"images":["http://pic1.zhimg.com/6422a65259ce368461388a5a7ca81048.jpg"],"type":0,"id":8925649,"ga_prefix":"102813","title":"在太空呆了 300 多天，双脚如同婴儿一般鲜嫩"},{"images":["http://pic4.zhimg.com/346fa600eab0d267376fe19c8ddba5ab.jpg"],"type":0,"id":8926901,"ga_prefix":"102812","title":"大误 · 我有特殊的沟通技巧"},{"images":["http://pic1.zhimg.com/5db19c41424ff7c6b5fc7ca09e9bf35c.jpg"],"type":0,"id":8859303,"ga_prefix":"102811","title":"决定要二胎，该怎么跟大孩子说比较合适？"},{"images":["http://pic2.zhimg.com/db4e73d8e6cae002a8dbcd5539befdf9.jpg"],"type":0,"id":8918176,"ga_prefix":"102810","title":"狗狗歪着头，可不是在卖萌"},{"title":"终于等来新 MacBook Pro，却有点不知道该怎么说","ga_prefix":"102808","images":["http://pic2.zhimg.com/50b0e6ce0bb322b667419044007a2ea5.jpg"],"multipic":true,"type":0,"id":8926123},{"title":"沙发该怎么买，怎么摆，真是项大工程","ga_prefix":"102808","images":["http://pic4.zhimg.com/10e2409fef60c1912298a5a17b4abdf3.jpg"],"multipic":true,"type":0,"id":8926104},{"images":["http://pic2.zhimg.com/e92d4b967844d91f1ade3eab4694f0a1.jpg"],"type":0,"id":8926114,"ga_prefix":"102807","title":"既然交易能使每个人获益，为什么贫富分化越来越严重？"},{"title":"种地是中国人的种族天赋，我用亲身经历帮你理解","ga_prefix":"102807","images":["http://pic3.zhimg.com/bf8a0a4de89201a20fd482298bb08f4a.jpg"],"multipic":true,"type":0,"id":8925768},{"images":["http://pic2.zhimg.com/cecd2abc774864c1cdb35a8a3c3cfc71.jpg"],"type":0,"id":8923238,"ga_prefix":"102807","title":"房子买 15 平「送」 55 平，馅饼没吃到，反而被坑了"},{"images":["http://pic3.zhimg.com/61641a99c38ad844674e0bf5ff15a9b2.jpg"],"type":0,"id":8926124,"ga_prefix":"102807","title":"读读日报 24 小时热门 TOP 5 · 很少人知道「局座」曾经的辛酸"},{"images":["http://pic2.zhimg.com/b2b495101c09156ecff37e3bf74059b1.jpg"],"type":0,"id":8921915,"ga_prefix":"102806","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic3.zhimg.com/6fa373cb75d90ecf17cd813ecc30e2c6.jpg","type":0,"id":8927920,"ga_prefix":"102814","title":"把新电脑功能键换成了屏幕，其实苹果早就想对键盘下手了"},{"image":"http://pic4.zhimg.com/c585b1e4a0f1203c5f23356d90ec2f3f.jpg","type":0,"id":8925649,"ga_prefix":"102813","title":"在太空呆了 300 多天，双脚如同婴儿一般鲜嫩"},{"image":"http://pic1.zhimg.com/76fb95718d492e2c4ba7bcce912b4d84.jpg","type":0,"id":8926123,"ga_prefix":"102808","title":"终于等来新 MacBook Pro，却有点不知道该怎么说"},{"image":"http://pic1.zhimg.com/e1e61ac406742d34c7962a3998cd2474.jpg","type":0,"id":8926124,"ga_prefix":"102807","title":"读读日报 24 小时热门 TOP 5 · 很少人知道「局座」曾经的辛酸"},{"image":"http://pic4.zhimg.com/bf94ad2955aca6ad6b7500ebc07b5e67.jpg","type":0,"id":8923238,"ga_prefix":"102807","title":"房子买 15 平「送」 55 平，馅饼没吃到，反而被坑了"}]
     */

    private String date;
    /**
     * images : ["http://pic2.zhimg.com/038031c3f24ebaa2cb3b10198d5909a1.jpg"]
     * type : 0
     * id : 8928061
     * ga_prefix : 102815
     * title : 老板说要加薪，我赶紧思考了一下这对经济的影响
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic3.zhimg.com/6fa373cb75d90ecf17cd813ecc30e2c6.jpg
     * type : 0
     * id : 8927920
     * ga_prefix : 102814
     * title : 把新电脑功能键换成了屏幕，其实苹果早就想对键盘下手了
     */

    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}


