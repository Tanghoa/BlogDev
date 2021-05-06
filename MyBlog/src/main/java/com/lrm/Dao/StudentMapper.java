package com.lrm.Dao;

import com.lrm.bean.Student;
import com.lrm.bean.StudentExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface StudentMapper {
	long countByExample(StudentExample example);

	int deleteByExample(StudentExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Student record);

	int insertSelective(Student record);


	List<Student> selectByExamplewithDEP(StudentExample example);

	Student selectByPrimaryKeywithDEP(Integer id);

	List<Student> selectByExample(StudentExample example);

	Student selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

	int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);
}