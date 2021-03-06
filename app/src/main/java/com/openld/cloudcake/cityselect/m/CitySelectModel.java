package com.openld.cloudcake.cityselect.m;

import com.openld.cloudcake.cityselect.m.beans.CityInfoBean;

import java.util.ArrayList;
import java.util.List;

/**
 * author: lllddd
 * created on: 2021/6/13 16:12
 * description:城市选择数据Model
 */
public class CitySelectModel {
    public List<CityInfoBean> queryAllCityList() {
        List<CityInfoBean> cityInfoBeanList = new ArrayList<>();

        // 城市1
        CityInfoBean cityInfoBean1 = new CityInfoBean();
        cityInfoBean1.setCity("上海");
        cityInfoBean1.setCityImageUrl("https://images.pexels.com/photos/683419/pexels-photo-683419.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");
        cityInfoBean1.setCityDesc("上海\n" +
                "一座极具现代化\n" +
                "而又不失中国传统特色的都市\n" +
                "外滩老式的西洋建筑与\n" +
                "浦东现代的摩天大厦交相辉映\n" +
                "徐家汇大教堂圣诗声声\n" +
                "玉佛寺香烟袅袅……\n" +
                "变与不变交织着\n" +
                "这座已经崛起的国际化大都市\n" +
                "昔日的石库门建筑\n" +
                "今天已经是流行的元素和品牌\n" +
                "昔日江对面的沧海桑田\n" +
                "今天已为磁悬浮和最国际化的机场所替代\n" +
                "昔日的跑马地今天已经变成公园\n" +
                "谁会想到弧形的武胜路\n" +
                "却是百年前马道的一段转弯处\n" +
                "不变的是百余年来上海\n" +
                "一直是中国商业的中心、财富的汇聚地\n" +
                "更是和世界联系最紧密的那根纽带\n" +
                "有人说“外滩的故事就是上海的故事”\n" +
                "外滩的精华就在于52幢风格各异\n" +
                "被称为“万国建筑博览”的外滩建筑群\n" +
                "外滩的建筑虽不是出自同一位设计师\n" +
                "也并非建于同一时期\n" +
                "然而它们的建筑色调却基本统一\n" +
                "整体轮廓线处理也惊人地协调晚间，浦江两岸霓虹齐放\n" +
                "漫步其中，感受着“不夜城”的韵味与浪漫\n" +
                "加之外滩江风阵阵\n" +
                "怎么一个美字了得\n" +
                "城隍庙与豫园毗邻\n" +
                "从宋代开始始建到当代\n" +
                "追溯其历史已有800多年\n" +
                "作为道教官观，在国内外享有盛名\n" +
                "历史悠久的祈福胜地\n" +
                "老城隍庙内\n" +
                "汇集了众多的上海地方小吃\n" +
                "绿波廊的特色点心，松月楼的素菜包\n" +
                "桂花厅的鸽蛋圆子，松云楼的八宝饭\n" +
                "还有南翔小笼和酒酿圆子\n" +
                "称得上是小吃王国\n" +
                "每一座城市，都有它收纳记忆的地方\n" +
                "北有胡同，南有码头\n" +
                "都藏匿着属于它们特有故事,欲说还休\n" +
                "而上海，则有弄堂\n" +
                "可以说,若没有弄堂\n" +
                "就没有上海,更没有上海人\n" +
                "每一条弄堂\n" +
                "都藏着历史沧桑与人间烟火\n" +
                "纵使时光褪却，高楼林立\n" +
                "上海弄堂还是安静的坚守在那里\n" +
                "烙印着千千万万上海人的生活\n" +
                "漫步穿梭于上海弄堂中\n" +
                "就如阅读上海的文化，度量上海的历史\n" +
                "不等你做好准备\n" +
                "它的那份情就已经把你包围\n" +
                "全国十大著名步行街之一\n" +
                "南京路已有100多年的历史\n" +
                "它的前身是“派克弄”\n" +
                "1865年正式命名为南京路步行街的东西两端均有一块暗红色大理石屏\n" +
                "上面是江泽民主席亲笔题写的\n" +
                "“南京路步行街”6个大字狭窄的街道，高大的建筑\n" +
                "灰色调的围墙和百叶窗\n" +
                "高高的天花板，尖尖的屋顶\n" +
                "记载了许多曲折跌宕的故事\n" +
                "东方明珠广播电视塔\n" +
                "坐落于黄浦江畔浦东陆家嘴嘴尖上\n" +
                "与外滩的万国建筑博览群隔江相望\n" +
                "塔高468米\n" +
                "位居亚洲第一、世界第三的高塔\n" +
                "和左右两侧的南浦大桥、杨浦大桥一起\n" +
                "形成双龙戏珠之势\n" +
                "成为上海改革开放的象征\n" +
                "未完待续……");
        cityInfoBeanList.add(cityInfoBean1);

        //城市2
        CityInfoBean cityInfoBean2 = new CityInfoBean();
        cityInfoBean2.setCity("重庆");
        cityInfoBean2.setCityImageUrl("https://gimg2.baidu.com/image_search/src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20190611%2Fd1ce1283b1414c3e8a8bab36fe51fdab.jpeg&refer=http%3A%2F%2F5b0988e595225.cdn.sohucs.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1626170962&t=21bdd4ec1cbe39a063c5ec3530c3c2d3");
        cityInfoBean2.setCityDesc("重庆就像一幅泼墨山水画\n" +
                "永远是灰蒙蒙的\n" +
                "无论是城市\n" +
                "还是天空、山水、草木\n" +
                "千百年来\n" +
                "从巴人古国到陪都\n" +
                "也许是有太多的沉淀\n" +
                "灰色成了重庆的主色调\n" +
                "主城区坐落在长江与嘉陵江交汇处\n" +
                "四面环山，江水回绕\n" +
                "城市傍水依山，层叠而上\n" +
                "既以江城著称，又以山城扬名\n" +
                "洪崖洞的景色很奇特\n" +
                "它以城市的高楼大厦为背景\n" +
                "而自己则是古香古色的\n" +
                "这种景色在白天看来平平无奇\n" +
                "但是，在夜幕降临时\n" +
                "霓虹灯光照亮吊脚楼的轮廓\n" +
                "洪崖洞被染上了一层光晕\n" +
                "江面倒映着灯光\n" +
                "就像撞入了《千与千寻》的世界\n" +
                "千厮门大桥加重了这种感觉\n" +
                "就像是通向神灵异界的桥\n" +
                "解放碑 原名抗战胜利纪功碑\n" +
                "是全中国唯一的一座\n" +
                "纪念中华民族抗日战争胜利的国家纪念碑\n" +
                "以纪念重庆对于国家的伟大贡献\n" +
                "“打望”是重庆方言中\n" +
                "专门用来形容看美女的\n" +
                "一个经典词汇\n" +
                "打望美女是了解重庆的必经阶段\n" +
                "这个当年热闹的水陆码头\n" +
                "一条条由青石板\n" +
                "铺成的小巷子曲径通幽\n" +
                "一幢幢刻满斑驳的房屋古朴陈旧\n" +
                "嘉陵江水在一旁缓缓地流过\n" +
                "……\n" +
                "小镇就是用这一切\n" +
                "在向你诉说老重庆\n" +
                "最朴实、最静谧的岁月\n" +
                "在重庆\n" +
                "轻轨2号线的李子坝站穿越房屋\n" +
                "每天都会上演轻轨穿楼越壑\n" +
                "空中飞驰而过的神奇一幕\n" +
                "其中，6楼是站厅\n" +
                "7楼是设备层，8楼是站台层\n" +
                "噪音仅60分贝，即使穿楼而过\n" +
                "也不会影响周边居民的正常生活作息\n" +
                "十八梯是重庆最重要的文化符号之一\n" +
                "解放碑属于重庆的上半城\n" +
                "长江边是下半城\n" +
                "十八梯就是连接重庆上下半城的梯坎\n" +
                "过去的辉煌可以想见\n" +
                "这里不加掩饰的\n" +
                "呈现了老重庆市民的真实写照\n" +
                "市井气息足、\n" +
                "很好得展现了浓郁的老重庆味儿\n" +
                "在这里可购买古玩、\n" +
                "在茶馆打发时光、看看风景\n");
        cityInfoBeanList.add(cityInfoBean2);

        // 城市3
        CityInfoBean cityInfoBean3 = new CityInfoBean();
        cityInfoBean3.setCity("西安");
        cityInfoBean3.setCityImageUrl("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fn.sinaimg.cn%2Fsx%2Fcrawl%2F58%2Fw550h308%2F20191031%2F4c6e-ihqyuym7336208.jpg&refer=http%3A%2F%2Fn.sinaimg.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1626171298&t=7a64f81cf38371cce7f502592827a475");
        cityInfoBean3.setCityDesc("西安的美，美在它是古都，有钟楼，大雁塔，城墙。在那任何一块砖瓦中，都能找寻到历史，耳边也回响着诗歌的名句。让人感到厚重。\n" +
                "西安的美，美在它的布局。街道宽阔，基本都横平竖直，在西安，只要能分清东南西北，基本不会迷失方向。而不像去一些城市，宛若走进迷宫。\n" +
                "西安的美，美在它的现代。曲江，小寨，钟楼周边，以及一些新开发的新区，街道宽阔，高楼林立，有湖泊，绿树成荫，花草繁茂，让人感受着都市现代的气息，有宛若回归自然。\n" +
                "西安，是一个古典，现代；高贵，又平民的城市。\n" +
                "它的古典，在钟楼，城墙，大雁塔，和一些建筑的风貌上，在积淀的历史里。它的现代，在那些新潮的建筑上，在一些商场里，和新开张的店铺里，总是紧跟潮流，贴合着这个时代。它的高贵，在那外观各异，造型不同的建筑上。在那些商场，酒店，大厦里。它的平民，在那些小街道上。街道两边，树木茂密，上边的枝叶，连在一块，形成了也个树木枝叶搭建的隧道一般。在这样的街道旁，房屋都不高，有各种店铺，能满足人日常生活的需要。漫步在这样的街道上，忽然让人感到，不是在一个都市里，而是回到乡间，一个熟悉的村庄，让人感到亲切，而温暖。\n" +
                "就在这样的感觉里，忽然感到，不去想西安的古典，现代，高贵，仅仅从生活的角度来看，西安是个最亲民，惬意，让人能悠然生活的城市。\n" +
                "西安也许工厂，和企业不是那样的多，于是，在西安，服务业也许占据了很大的比重。在西安，既有星际的酒店，也有街道旁的小餐馆。在西安，汇集着各个地方，各种的小吃。可以说，在西安，不用出城，可以品尝到各个地方的名菜。也可以吃边各个地方的小吃。而且，价钱不贵。如果是有钱人，可以去星际酒店吃各种名贵的菜肴。如果是普通的百姓，哪怕是穷人，在小街道边，有许多的小餐馆，摊点，可以吃各种小吃。富贵与贫穷，高贵与卑微，在这个城市里，和谐共生。\n" +
                "西安有许多有名的医院。也有许多有名的高校。在西安，能品味到各种美食，也能享受到便捷的医疗条件。还能感受到这个城市，因为年轻人，而充满的青春，理想，活力。\n" +
                "我感到，人在年轻时，寻找梦想，来西安，很容易落脚，然后，放飞寻梦的翅膀。如果在年老时，来西安，能享受便捷的生活，和医疗，感受着都市的青春，活力，让晚年的生活，充满幸福，安详。\n" +
                "另外，都市里，还有许多的寺庙。兴善寺，小雁塔。纵然心里，没有宗教的信仰，但是，厌倦了都市的喧嚣，或者为了生活奔忙的太累，走进那些寺庙，寺庙里，庙宇飞檐走壁，树木成荫，古树苍翠。寺庙里，缭绕着香火的气息，格外的幽静，让人的内心，也幽静，安详了下来。在寺庙里，再了解了生的意义，知道了放下，做到了六根清净，那么，忽然之间，发现人不管遇到什么，发生什么，都微不足道了。只要活着就好。\n" +
                "暮色里，都市在各种灯火中，被装点的格外的美丽。街道上，车辆缓慢行驶。街道旁，人们也悠然的漫步。\n" +
                "行走都市里，欣赏都市夜晚的美丽，感受都市的生机，活力。在街道旁，遍布着各种店铺，有各种小吃的店铺，还有烧烤。进入店铺，点了烧烤，和喜欢的小吃，边吃，边小口的喝着啤酒。吃饱，喝好，在微醺中，行走都市里，看着都市的夜色，高楼上，闪烁的霓虹，街道上，缓慢行驶的车辆，仿佛不是生活在人间，而是生活在天堂。");
        cityInfoBeanList.add(cityInfoBean3);

        return cityInfoBeanList;
    }
}
