/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : androiddb

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2020-12-21 13:01:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) DEFAULT NULL,
  `icon` varchar(20) DEFAULT NULL,
  `bookid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `bookid` (`bookid`),
  CONSTRAINT `bookid` FOREIGN KEY (`bookid`) REFERENCES `bookinfo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '西游记', 'xiyou.jpg', '1');
INSERT INTO `book` VALUES ('2', '水浒传', 'shuihu.jpg', '2');
INSERT INTO `book` VALUES ('3', '红楼梦', 'honglou.jpg', '3');
INSERT INTO `book` VALUES ('4', '三国演义', 'sanguo.jpg', '4');
INSERT INTO `book` VALUES ('5', '大漠苍狼', 'damo.jpg', '5');
INSERT INTO `book` VALUES ('6', '民调局异闻录', 'mindiao.jpg', '6');
INSERT INTO `book` VALUES ('7', '乱世枭雄', 'luanshi.jpg', '7');

-- ----------------------------
-- Table structure for `bookinfo`
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo` (
  `id` int(10) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `info` varchar(400) DEFAULT NULL,
  `img` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
INSERT INTO `bookinfo` VALUES ('1', '西游记', '\r\n东胜神州的傲来国花果山的一块巨石孕育出了一只明灵石猴（六小龄童 饰），石猴后来拜须菩提为师后习得了七十二变，具有了通天本领，于是占山为王，自称齐天大圣。玉帝派太上老君下凡招安大圣上了天庭，后来大圣因为嫌玉帝赐封的官职太低，大闹天宫，被太上老君困于炼丹炉内四十九天后，大圣踢翻炼丹炉，炼成了金睛火眼。如来佛祖见局势不可收拾，于是将大圣镇压于五指山下。一晃眼五百年过去了，唐僧被观世音菩萨选为西去取经普渡众生的人，大圣受观音指引，拜唐僧为师，师徒二人踏上了取经的路途。之后猪八戒，沙悟净也加入队伍，师徒四人一路破除艰难，除掉各种妖怪，最终成功到达西天，完成取经任务。', 'xiyou.jpg');
INSERT INTO `bookinfo` VALUES ('2', '水浒传', '北宋年间奸臣当道，民不聊生。山东境内，以宋江、林冲、武松、鲁智深等为首的108位英雄好汉聚义梁上，树起“替天行道”大旗，斗贪官、除恶霸，保一方百姓。后来，在首领宋江的带领下梁山好汉接受朝廷的招安，他们报效国家，英勇善战，屡屡御敌于国门之外，立下赫赫战功。然而，以太尉高俅为首的一批权臣却为一己之私阴谋杀害了宋江、卢俊义、李逵等梁山将领，后被皇帝察觉，最终将几个奸臣一一治罪。', 'shuihu.jpg');
INSERT INTO `bookinfo` VALUES ('3', '红楼梦', '《红楼梦》，中国古代四大名著之一，章回体长篇小说，成书于1784年(清乾隆四十九年)，梦觉主人序本正式题为《红楼梦》。其原名有《石头记》、《情僧录》、《风月宝鉴》、《金陵十二钗》等。前80回曹雪芹著，后40回无名氏续，程伟元、高鹗整理。本书是一部具有高度思想性和高度艺术性的伟大作品，作者具有初步的民主主义思想，他对现实社会、宫廷、官场的黑暗，封建贵族阶级及其家族的腐朽，对封建的科举、婚姻、奴婢、等级制度及社会统治思想等都进行了深刻的批判，并且提出了朦胧的带有初步民主主义性质的理想和主张。', 'honglou.jpg');
INSERT INTO `bookinfo` VALUES ('4', '三国演义', '故事远起汉灵帝年间刘、关、张桃园结义，描述了东汉末年和三国时期近百年发生的重大历史事件，和众多的叱咤风云的英雄人物。作者通过真实动人的故事，揭示了封建统治阶级内部的黑暗和腐朽，控诉了统治者的暴虐和丑恶。东汉末年，军阀混战，所谓\"十八路\"诸侯联军征讨董卓，打的是\"扶持王室，拯救黎民\"的旗号，干的是勾心斗角、尔虞我诈的勾当，都企图称王称霸。《三国演义》以没落的汉室宗亲刘备和以宗族起兵的曹操作为两条主线的展开了中前期的故事，而中后期以大汉丞相诸葛亮率领汉军北伐，与魏国重臣司马懿的斗智斗勇为主线，以三国归晋而告终。', 'sanguo.jpg');
INSERT INTO `bookinfo` VALUES ('5', '大漠苍狼', '上世纪六十年代，身为新中国第一批地质勘探队员，我们被秘密选调到某地质工程大队.\r\n　　一纸密令，我们不明目的、不明地点、不明原因，来到最老到的地质工程师都不能确认的中蒙边境原始丛林。经过焦灼惶恐，甚至以为要被秘密处决的阶段，我们观看了一段专供中央高层的绝密《零号片》。胶片的画面让一直受到唯物主义教育的我们窒息：地震波传回的信息还原在胶片上，放大二百倍后清晰地显示——地下一千二百米处的岩壳里，竟然镶嵌着一架日式重型轰炸机！', 'damo.jpg');
INSERT INTO `bookinfo` VALUES ('6', '民调局异闻录', '这是一个无处不在却不为人知的世界。这个世界里，有一个神通广大隐匿在世人视野之外的神秘部门，有一群身怀秘术活得风生水起的凡人，当然，还有那些超脱了轮回却依旧混迹凡尘的传奇。于芸芸众生而言，他们是看不见摸不着却又实实在在的坚强护盾;于邪魔外道而言，他们是令人欲除之而后快的眼中钉肉中刺;而对他们自己而言，他们只是有血有肉的人，有爱有恨，有喜有悲，身在大千世界，心怀大千世界，微不足道，却又重要无比。\r\n天生阴阳眼的特种兵沈辣在云南边境抓捕毒枭任务中，遭遇恐怖状况，古滇国神秘的山洞内，远古祭祀的干尸纷纷复活，向他们疯狂攻击，沈辣小队几乎全军覆没。\r\n危机时刻，一个叫\"吴勉\"的神秘白发男子忽然出现，将沈辣以及缉毒警孙德胜救出。\r\n云南\"干尸\"事件后，沈辣同孙德胜被调入一个叫\"民俗事物调查研究局\"的神秘机构，从此开始了一系列离奇而又刺激的\"灵异\"故事。 ', 'mindiao.jpg');
INSERT INTO `bookinfo` VALUES ('7', '乱世枭雄', '长篇评书《乱世枭雄》是由著名评书艺术大师单田芳先生花费了十年的心血，根据大量的历史材料和广为流传的民间传说精心创作而成，情节曲折、语言生动、人物鲜明、个性突出，悬念环环相扣，故事引人入胜。\r\n全书共300回，深度讲述了一代枭雄张作霖的传奇人生，再现了中国从满清到民国社会变革期的宏大图景。是一部融政治、历史、军事、权谋于一体的百科全书，一部揭示中国传统文化没落与重生的长篇巨著，一部揭示中国传统文化没落与重生的长篇历史小说，融政治、历史、军事、权谋于一体的百科全书。\r\n在讲述张氏父子传奇经历的同时，还描述了清末民初军阀混战时代背景，使人们可以从一个侧面进一步了解中国近现代史。', 'luanshi.jpg');
