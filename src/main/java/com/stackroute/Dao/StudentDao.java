package com.stackroute.Dao;

import com.stackroute.Model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDao {
    //declaring jdbc template
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    //inserting values into a table

    public int saveStudent(Student e) {
        String query = "insert into Student values( '" + e.getId() + "','" + e.getName() + "','" + e.getGender() + "','" + e.getAge() + "')";
        return jdbcTemplate.update(query);


    }
    //updating values

    public int updateStudent(Student e) {
        String query = "update Student set name='" + e.getName() + "',age='" + e.getAge() + "' where id='" + e.getId() + "' ";
        return jdbcTemplate.update(query);
    }
    //deleting values

    public int deleteStudent(Student e) {
        String query = "delete from Student where id='" + e.getId() + "' ";
        return jdbcTemplate.update(query);
    }
    //displaying list of students
   /* public List<Student> getAllStudents() {
        String sql = "select * from Student";
        return jdbcTemplate.query(sql, new RowMapper<Student>()
        {
            @Override

            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setGender(resultSet.getString(3));
                student.setAge(resultSet.getInt(4));
                return student;
            }
        });*/
    public Student getStudentById(int id){
        String sql="select * from Student where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Student>(Student.class));
    }
    public List<Student> getAllStudents(){
        return jdbcTemplate.query("select * from Student",new RowMapper<Student>(){
            public Student mapRow(ResultSet resultSet, int row) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setName(resultSet.getString(2));
                student.setGender(resultSet.getString(3));
                student.setAge(resultSet.getInt(4));
                return student;
            }
        });



    }
}