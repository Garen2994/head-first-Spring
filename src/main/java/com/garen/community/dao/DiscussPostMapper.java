package com.garen.community.dao;

import com.garen.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPosts(int userId,int offset, int limit); //userId is dynamic
    //page-divide
    //@Param用于给参数取别名
    //如果只有一个参数，并在<if>里使用，则必须加别名
    int selectDiscussPostRows(@Param("userId") int userId);
    
}
