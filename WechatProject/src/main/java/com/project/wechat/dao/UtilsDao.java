package com.project.wechat.dao;

import com.project.wechat.dto.BeforeRegion;
import com.project.wechat.dto.Properties;
import com.project.wechat.mbg.pojo.*;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
* 自定义工具类
* */
@Mapper
@Repository
public interface UtilsDao {
    /*
    * 判断关注表是否存在相关数据
    * */
    AttentionPo judgeHaveAttentionOrNot(@Param("userId") Integer userId, @Param("followId")Integer followId);
    /*
    * 判断粉丝表是否存在相关数据
    * */
    FansPo judgeHaveFansOrNot(@Param("userId") Integer userId, @Param("fansId") Integer fansId);
    /*
    * 由name进行模糊搜索并返回
    * */
    List<GoodsPo> getSearchByName(@Param("keyword") String keyword,@Param("sortType") String sortType,@Param("userId")  Integer userId);
    /*
    * 由类型进行搜索并返回
    * */
    List<GoodsPo> getGoodsByType(@Param("typeId") Integer typeId,@Param("sortType") String sortType);
    /*
    * 检查收藏版是否存在数据
    * */
    FavouritesPo checkFavoriteIsExist(FavouritesPo favouritesPo);
    /*
    * 根据Id查找用户
    * */
    UserPo getUserById(@Param("userId") Integer userId);
    /*
    * 根据ID查找校区(预查询)
    * */
    BeforeRegion getBeforeRegionById(@Param("sc_id")Integer scId);
    /*
    * 根据id查找学校
    * */;
    String getSchoolById(@Param("schoolId")Integer schoolId);
    /*
    * 根据UserId查找学校
    * */
    String getSchoolByUserId(@Param("userId") Integer userId);

    /*
    * 根据id查找商品
    * */
    GoodsPo getGoodsById(@Param("goodsId") Integer goodsId);

    /*
    * 根据chatId查找商品
    * */
    GoodsPo getGoodsByChatId(@Param("chatId") Integer chatId);

    /*
    * 使用id通过chatId去查找用户信息
    * 0是买家
    * 1是卖家
    * */
    UserPo getUserByIdThroughChat(@Param("chatId") Integer chatId,@Param("role") String role);

    /*
    *
    * 搜索商品
    * */
    //"全新","几乎全新","略微折痕","明显折痕"
    public final String ALL = "ALL";
    public final String NEW = "NEW";
    public final String ALMOST_NEW = "ALMOST_NEW";
    public final String LITTLE_FOLD= "LITTLE_FOLD";
    public final String TRANSPARENT_FOLD = "TRANSPARENT_FOLD";

    //无笔记
    public final String NONE = "NONE";
    //少量笔记
    public final String LITTLE= "LITTLE";
    //大量笔记
    public final String A_LOT = "A_LOT";

    List<GoodsPo> searchGoods(Properties properties);

    /*
    * 由卖家Id查询用户
    * */
    public UserPo getUserBySellerId(@Param("sellerId") Integer sellerId);

    /*
    * 根据Type的name查找Type的id
    * */
    public Integer getTypeIdByTypeName(@Param("typeName") String typeName);
    /*
    * 根据schoolName获取schoolId
    * */
    public Integer getSchoolIdBySchoolName(@Param("schoolName") String schoolName);

    /*
    * 根据UserId获得学校Id
    * */
    public Integer getSchoolIdByUserId(@Param("userId") Integer userId);

    /*
    * 通过typeId得到typeName
    * */
    public String getTypeNameByTypeId(@Param("typeId") Integer typeId);

    /*
    * 得到所有商品消息
    * */
    public List<GoodsPo> getAllGoods();

    /*
    * 根据goodsId得到sellerId
    * */
    public Integer getGoodsSellerIdByGoodsId(@Param("goodsId") Integer goodsId);

    //根据orderId查找goodsId
    public Integer getGoodsIdByOrderId(@Param("orderId") Integer orderId);

    //判断历史搜索数是否已经存在
    public Integer isHSExist(@Param("userId") Integer userId,@Param("searchInfo") String searchInfo);
    //判断历史浏览数据是否已经存在
    public Integer isHBExist(@Param("goodsId") Integer goodsId,@Param("userId") Integer userId);
    //更新历史浏览的时间
    public Integer updateHBTime(@Param("goodsId") Integer goodsId,@Param("userId")Integer userId,@Param("date") long date);

}
