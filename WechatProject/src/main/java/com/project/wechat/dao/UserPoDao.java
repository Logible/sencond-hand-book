package com.project.wechat.dao;

import com.project.wechat.mbg.pojo.SuPo;
import com.project.wechat.mbg.pojo.UserPo;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserPoDao {
    //返回所有用户
    public List<UserPo> selectAllUser();

    //封禁用户
    public Integer banUser(@Param("userId") Integer userId);

    //删除用户
    public Integer deleteUser(@Param("userId") Integer userId);

    //添加用户
    public Integer addUser(UserPo userPo);

    //验证管理员是否存在
    public SuPo monitorIsExist(@Param("su_id") String su_id, @Param("su_password") String su_password);

    //查找用户
    /*
     * 支持用户名，user_id,open_id查询
     * TODO 弄个页面给他们填对应的信息
     * */
    public UserPo searchUser(UserPo userPo);

    //更新用户信息
    public Integer updateUser(UserPo userPo);

    //TODO 重置用户密码
    /*
     * 根据主键查找用户
     * */
    public UserPo selectUserByPK(@Param("userId") Integer userId);

    /*
     * 查找用户所有数据个数
     * */
    public Integer selectUserCounts();

    /*
     * 通过openId查找用户是否存在
     * */
    public UserPo selectUserByOpenId(@Param("openId") String openId);

    /*
     * 根据User里的学校id查询学校名称
     * */
    public String searchSchoolById(@Param("schoolId") Integer schoolId);

    /*
     * 根据前端传的schoolName找到学校Id
     * */
    public Integer searchSchoolIdBySchoolName(@Param("schoolName") String schoolName);

    /*
     * 得到用户状态
     * */
    public Integer getUserStatus(@Param("userId") Integer userId);

    /*
     * 将用户设置为在线
     * */
    public Integer setUserOnline(@Param("userId") Integer userId);

    /*
     * 将用户设置为离线
     * */
    public Integer setUserNotOnline(@Param("userId") Integer userId);

    /*
     * 返回一个user的粉丝集合
     * */
    public List<UserPo> getUserByIdList(List<Integer> userId);

    /*
     * 通过userId得到粉丝的Id
     * */
    public List<Integer> getFansIdById(@Param("userId") Integer userId);
    /*
    * 通过userId得到关注的id
    * */
    public List<Integer> getAttentionById(@Param("userId") Integer userId);

    //判断是否为我的关注
    public Integer isMyAttention(@Param("userId") Integer userId,@Param("oppoId") Integer OppId);

    //返回用户的点赞数
    public Integer getUserThumbs(@Param("userId") Integer userId);
}

