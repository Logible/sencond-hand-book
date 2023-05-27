package com.project.wechat.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.project.wechat.MyException.UnSynchronizationException;
import com.project.wechat.dao.*;
import com.project.wechat.mbg.pojo.HistoryBrowsing;
import com.project.wechat.mbg.pojo.HistorySearchPo;
import com.project.wechat.mbg.pojo.SuPo;
import com.project.wechat.mbg.pojo.UserPo;
import com.project.wechat.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = UnSynchronizationException.class,propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

    @Autowired
    private UtilsDao utilsDao;
    @Autowired
    private AttentionPoDao attentionPoDao;
    @Autowired
    private FansPoDao fansPoDao;
    @Autowired
    private UserPoDao userPoDao;
    @Autowired
    private FavouritesPoDao favouritesPoDao;
    @Autowired
    private ThumbPoDao thumbPoDao;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HistoryBrowsingDao historyBrowsingDao;

    @Autowired
    private HistorySearchPoDao historySearchPoDao;

    @Autowired
    private GoodsPoDao goodsPoDao;


    /*
    * 得到用户关注的总人数
    * */
    @Override
    public Integer getAttentionCount(Integer userId) {
        return attentionPoDao.countAttentions(userId);
    }

    /*
    * 得到用户的粉丝总数
    * */
    @Override
    public Integer getFansCount(Integer userId) {
        return fansPoDao.countFans(userId);
    }

    /*
    * 关注某个用户
    * */
    @Override
    public boolean followAUser(Integer userId, Integer followId) throws Exception{
        if(checkExisted(userId,followId) == false){
            return justifyOperation(userId,followId);
        }else {
            return false;
        }
    }

    /*
    * 取消关注某个用户
    * */
    @Override
    public boolean cancelFollowUser(Integer userId, Integer followId) throws UnSynchronizationException {
        if(checkExisted(userId,followId) == true){
            if(attentionPoDao.unFollowUser(userId,followId) > 0
              && fansPoDao.unFansUser(followId,userId) > 0){
                return true;
            }else {
                throw new UnSynchronizationException("粉丝表和关注未同步更新，操作失败");
            }
        }
        return false;
    }

    /*
    * 返回所有用户
    * */
    @Override
    public List<UserPo> selectAllUser() {
        return userPoDao.selectAllUser();
    }

    /*
    * 封禁一个用户
    * */
    @Override
    public boolean banUser(Integer userId) {
        return userPoDao.banUser(userId) > 0?true:false;
    }

    /*
    * 删除一个用户
    * */
    @Override
    public boolean deleteUser(Integer userId) {
        return userPoDao.deleteUser(userId) > 0?true:false;
    }

    /*
    * 添加一个用户
    * */
    @Override
    public boolean addUser(UserPo userPo) {
        userPo.setSchool_id(searchSchoolIdBySchoolName(userPo.getUser_school()));
        return userPoDao.addUser(userPo) >0;
    }

    @Override
    public UserPo searchUser(UserPo userPo) {
        return userPoDao.searchUser(userPo);
    }

    @Override
    public boolean updateUser(UserPo userPo) {
        return userPoDao.updateUser(userPo) > 0;
    }

    /*
     * 判断用户是否存在
     * */
    @Override
    public SuPo monitorIsExist(String userId, String password) {
        return userPoDao.monitorIsExist(userId,password);
    }

    @Override
    public UserPo selectUserByPK(Integer userId) {
        return userPoDao.selectUserByPK(userId);
    }

    @Override
    public Integer selectUserCounts() {
        return userPoDao.selectUserCounts();
    }

    /*
     *根据openId查询用户是否存在，存在则返回，
     *不存在则创建一个只包含open_id及id的用户
     *通过检查password是否为空判断是否是新建的用户
     * 插入失败则返回null
     */
    @Override
    public UserPo selectUserByOpenId(String openId) {
        UserPo userPo = checkUserIfExistByOpenId(openId);
        if(userPo != null){
            setUserPo(userPo);
            return userPo;
        }else {
            userPo = new UserPo();
            userPo.setUser_openid(openId);
            return addUser(userPo) == true? userPo : null;
        }
    }

    /*
    * 得到用户状态
    * */
    @Override
    public boolean getUserStatus(Integer userId) {
        return userPoDao.getUserStatus(userId) > 0;
    }


    /*
     * 将用户设置为在线
     * */
    @Override
    public boolean setUserOnline(Integer userId) {
        return userPoDao.setUserOnline(userId) > 0;
    }

    /*
     * 将用户设置为离线
     * */
    @Override
    public boolean setUserNotOnline(Integer userId) {
        return userPoDao.setUserNotOnline(userId) > 0;
    }

    //根据学校名称得到学校Id
    @Override
    public Integer getSchoolIdBySchoolName(String schoolName) {
        return utilsDao.getSchoolIdBySchoolName(schoolName);
    }
    //根据学校id得到学校名称
    @Override
    public String getSChoolNameBySchoolId(Integer schoolId) {
        return utilsDao.getSchoolById(schoolId);
    }

    //根据userId查找user
    @Override
    public UserPo getUserByUserId(Integer userId) {
        UserPo userPo = utilsDao.getUserById(userId);
        setUserPo(userPo);
        return userPo;
    }

    //将userjson串转换为user对象
    @Override
    public UserPo StringToUser(String userStr) {
        return JSONObject.parseObject(userStr,new TypeReference<UserPo>(){});
    }

    /*
    * 得到id为userid的粉丝的user对象
    * */
    @Override
    public List<UserPo> getFansById(Integer userId) {
        List<Integer> idList = userPoDao.getFansIdById(userId);
        if(idList.isEmpty()){
            return null;
        }
        List<UserPo>userPoList = userPoDao.getUserByIdList(idList);
        for (UserPo userPo : userPoList) {
            setUserPo(userPo);
        }
        return userPoList;
    }

    @Override
    public List<UserPo> getAttentionersById(Integer userId) {
        List<Integer> idList = userPoDao.getAttentionById(userId);
        if(idList.isEmpty()){
            return null;
        }
        List<UserPo>userPoList = userPoDao.getUserByIdList(idList);

        for (UserPo userPo : userPoList) {
            setUserPo(userPo);
        }
        return userPoList;
    }

    /*
     * 返回历史浏览数
     * */
    @Override
    public Integer getHistoryBrowsingCnt(Integer userId) {
        return historyBrowsingDao.getHistoryBrowsingCnt(userId);
    }

    //返回收藏夹总数

    @Override
    public Integer getFavouritesCnt(Integer userId) {
        return favouritesPoDao.getFavouritesCnt(userId) ;
    }

    //判断是否为某用户的点赞商品
    @Override
    public boolean isThumbGoods(Integer userId, Integer goodsId) {
        return thumbPoDao.isThumbGoods(userId,goodsId) != null ;
    }

    //判断是否为收藏商品

    @Override
    public boolean isFavourites(Integer userId, Integer goodsId) {
        return favouritesPoDao.isFavourites(userId,goodsId) != null;
    }

    //插入历史浏览
    @Override
    public boolean insertHB(HistoryBrowsing historyBrowsing) {
        if(utilsDao.isHBExist(historyBrowsing.getGoods_id(),historyBrowsing.getUser_id()) == null){
            if(historyBrowsingDao.insertHB(historyBrowsing) > 0){
                return true;
            }
        }else {
            if(utilsDao.updateHBTime(historyBrowsing.getGoods_id(),historyBrowsing.getUser_id(),historyBrowsing.getDate()) > 0){
                return true;
            }
        }
        return false;
    }

    //删除全部历史浏览
    @Override
    public boolean deleteAllHB(Integer userId) {
        return historyBrowsingDao.deleteAllHB(userId) > 0;
    }

    //插入历史搜索
    @Override
    public boolean insertHS(HistorySearchPo historySearchPo) {
        if(utilsDao.isHSExist(historySearchPo.getUser_id(),historySearchPo.getSearch_info()) == null){
            System.out.println(utilsDao.isHSExist(historySearchPo.getUser_id(),historySearchPo.getSearch_info()));
            if(historySearchPoDao.insertHS(historySearchPo) > 0){
                return true;
            }
        }
        return false;
    }

    //判断是否为我的关注
    @Override
    public boolean isMyAttention(Integer userId, Integer OppId) {
        return userPoDao.isMyAttention(userId,OppId) != null;
    }

    //返回用户的点赞数
    @Override
    public Integer getUserThumbs(Integer userId) {
        return userPoDao.getUserThumbs(userId);
    }

    //获取user的openId
    @Override
    public String getUserOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={appid}&secret={secret}&js_code={code}&grant_type=authorization_code";

        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("appid",APP_ID);
        paramMap.put("secret",SECRET);
        paramMap.put("code",code);

        String result = this.restTemplate.getForObject(url,String.class,paramMap);
        return result;
    }


    @Override
    public HistoryBrowsing StringToHB(String historyBrowsing) {
        HistoryBrowsing historyBrowsing1 =
                JSONObject.parseObject(historyBrowsing,new TypeReference<HistoryBrowsing>(){});
        return historyBrowsing1;
    }

    @Override
    public HistorySearchPo StringToHS(String historySearchPo) {
        return JSONObject.parseObject(historySearchPo,new TypeReference<HistorySearchPo>(){});
    }



    //点赞
    @Override
    public boolean recordThumbUser(Integer goodsId, Integer userId) {
      if(thumbPoDao.checkThumbExist(goodsId,userId) == null){
          if(thumbPoDao.recordThumbUser(goodsId,userId) > 0){
              if(addThumb(utilsDao.getGoodsSellerIdByGoodsId(goodsId)) == true){
                  return true;
              }
          }
      }
        return false;
    }

    //取消点赞
    @Override
    public boolean deleteThumbRecord(Integer goodsId, Integer userId) {
        if(thumbPoDao.deleteThumbRecord(goodsId,userId)  > 0){
            if(reduceThumb(utilsDao.getGoodsSellerIdByGoodsId(goodsId)) == true){
                return true;
            }
        }
        return false;
    }


    /*
    * 判断添加操作是否成功
    * */
    private boolean justifyOperation(Integer userId,Integer followId) throws Exception{
        if (attentionPoDao.followUser(userId,followId) > 0
                && fansPoDao.addFans(followId,userId) > 0){
            return true;
        }else {
            throw new UnSynchronizationException("粉丝表和关注未同步更新，操作错误");
        }
    }

    /*
    * 判断数据是否已经存在
    * */
    private boolean checkExisted(Integer userId,Integer followId){
        return utilsDao.judgeHaveAttentionOrNot(userId,followId) != null
                && utilsDao.judgeHaveFansOrNot(followId,userId) != null;
    }

    /*
    * 根据opnId查询用户是否存在
    * */
    private UserPo checkUserIfExistByOpenId(String openId){
        return userPoDao.selectUserByOpenId(openId);
    }

    /*
    * 根据user的学校Id查找学校的名称
    * */
    private String searchSchoolById(Integer schoolId){
        return userPoDao.searchSchoolById(schoolId);
    }

    /*
     * 根据前端传的schoolName找到学校Id
     * */
    private Integer searchSchoolIdBySchoolName(String schoolName){
        return userPoDao.searchSchoolIdBySchoolName(schoolName);
    }

    /*
    * 修改点赞数
    * */
    //增加
    private boolean addThumb(Integer userId){
        return thumbPoDao.addThumb(userId) > 0;
    }
    //减少
    private boolean reduceThumb(Integer userId){
        return thumbPoDao.reduceThumb(userId) > 0;
    }
    //设置用户信息
    public void setUserPo(UserPo userPo){
        userPo.setUser_school(utilsDao.getSchoolByUserId(userPo.getUser_id()));
        userPo.setUser_gender(userPo.getGender());
        userPo.setUser_nickname(userPo.getNick_name());
        userPo.setUser_avatarUrl(userPo.getAvatar_url());
    }
}
