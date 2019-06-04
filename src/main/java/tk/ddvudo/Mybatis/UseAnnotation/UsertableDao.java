package tk.ddvudo.Mybatis.UseAnnotation;

import org.apache.ibatis.annotations.Param;
import tk.ddvudo.Mybatis.JavaBeans.Usertable;
import tk.ddvudo.Mybatis.JavaBeans.UsertableExample;

import java.util.List;

public interface UsertableDao {
    long countByExample(UsertableExample example);

    int deleteByExample(UsertableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Usertable record);

    int insertSelective(Usertable record);

    List<Usertable> selectByExample(UsertableExample example);

    Usertable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Usertable record, @Param("example") UsertableExample example);

    int updateByExample(@Param("record") Usertable record, @Param("example") UsertableExample example);

    int updateByPrimaryKeySelective(Usertable record);

    int updateByPrimaryKey(Usertable record);
}