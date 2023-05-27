package com.project.wechat.service;

import com.project.wechat.MyException.UnSynchronizationException;
import com.project.wechat.mbg.pojo.HistoryBrowsing;
import com.project.wechat.mbg.pojo.HistorySearchPo;
import com.project.wechat.mbg.pojo.SuPo;
import com.project.wechat.mbg.pojo.UserPo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    public static final String APP_ID = "wxeb45e83c7be40f15";
    public static final String SECRET = "5d913396f18e6edb5ded73574be3d583";

    //得到关注总数
    public Integer getAttentionCount(Integer userId);
    //得到粉丝总数
    public Integer getFansCount(Integer userId);
    //关注用户
    public boolean followAUser(Integer userId,Integer followId) throws Exception;
    //取消关注用户
    public boolean cancelFollowUser(Integer userId,Integer followId) throws UnSynchronizationException;
    //返回所有用户
    public List<UserPo> selectAllUser();
    //封禁用户
    public boolean banUser(Integer userId);
    //删除用户
    public boolean deleteUser(Integer userId);
    //添加用户
    public boolean addUser(UserPo userPo);
    //查找用户
    public UserPo searchUser(UserPo userPo);
    //更新用户
    public boolean updateUser(UserPo userPo);
    //判断用户是否存在
    public SuPo monitorIsExist(String userId, String password);
    //根据主键查找用户
    public UserPo selectUserByPK(Integer userId);
    //查询所有数据数
    public Integer selectUserCounts();
    /*
    *根据openId查询用户是否存在，存在则返回，
    *不存在则创建一个只包含open_id及id的用户
    *通过检查password是否为空判断是否是新建的用户
     */
    public UserPo selectUserByOpenId(String openId);

    /*
    * 得到用户状态
    * */
    public boolean getUserStatus(Integer userId);

    /*
    * 将用户设置为在线
    * */
    public boolean setUserOnline(Integer userId);

    /*
     * 将用户设置为离线
     * */
    public boolean setUserNotOnline(Integer userId);

    /*
    * //记录点赞用户
    * */
    public boolean recordThumbUser(Integer goodsId, Integer userId);

    /*
    * 删除用户点赞记录
    * */
    public boolean deleteThumbRecord(Integer goodsId, Integer userId);

    //根据schoolName获取schoolId
    public Integer getSchoolIdBySchoolName(String schoolName);

    //根据school——id获取schoolname
    public String getSChoolNameBySchoolId(Integer schoolId);

    //根据userId查找user
    public UserPo getUserByUserId(Integer userId);

    //将userjson串转换为user对象
    public UserPo StringToUser(String userStr);

    //得到id为userid的粉丝的user对象
    public List<UserPo> getFansById(Integer userId);
    //通过userId得到关注的id
    public List<UserPo> getAttentionersById(Integer userId);

    /*
     * 返回历史浏览数
     * */
    public Integer getHistoryBrowsingCnt( Integer userId);
    /*
    * 返回收藏夹总数
    * */
    public Integer getFavouritesCnt(Integer userId);

    //判断是否为某用户的点赞商品
    public boolean isThumbGoods(Integer userId,Integer goodsId);

    //判断是否为收藏商品
    public boolean isFavourites( Integer userId,Integer goodsId);

    //插入历史浏览
    public boolean insertHB(HistoryBrowsing historyBrowsing);
    /*
     * 删除全部历史浏览
     * */
    public boolean deleteAllHB(Integer userId);

    /*
     *插入历史搜索
     **/
    public boolean insertHS(HistorySearchPo historySearchPo);

    //判断是否为我的关注
    public boolean isMyAttention(Integer userId,Integer OppId);

    // 返回用户的点赞数
    public Integer getUserThumbs(Integer userId);

    //获取user的openId
    public String getUserOpenId(String code);



    //json转换Obj
    public HistoryBrowsing StringToHB(String historyBrowsing);
    public HistorySearchPo StringToHS(String historySearchPo);

}
