package tk.ddvudo.Mybatis.UseAnnotation;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import tk.ddvudo.Mybatis.JavaBeans.Roletable;
import tk.ddvudo.Mybatis.JavaBeans.RoletableExample;

public interface RoletableDao {
    long countByExample(RoletableExample example);

    int deleteByExample(RoletableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Roletable record);

    int insertSelective(Roletable record);

    List<Roletable> selectByExample(RoletableExample example);

    Roletable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Roletable record, @Param("example") RoletableExample example);

    int updateByExample(@Param("record") Roletable record, @Param("example") RoletableExample example);

    int updateByPrimaryKeySelective(Roletable record);

    int updateByPrimaryKey(Roletable record);
}