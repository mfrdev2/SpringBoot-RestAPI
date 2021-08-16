package com.example.demo.services;

import com.example.demo.dao.CourseDao;
import com.example.demo.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CourseServiceImp implements CourseService{
 //   private List<Course> list;
    @Autowired
    private CourseDao courseDao;

    public CourseServiceImp() {
        /*  list = new ArrayList<>();
        list.add(new Course(145,"Java Core Course","This course contain basic of Java"));
        list.add(new Course(146,"Spring Boot Course","Creating restAPI using spring boot"));*/

    }

    @Override
    public List<Course> getCourses() {
       // return list;
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {
 /*       Course course = null;
        for(Course course1: list){
            if(course1.getId() == courseId){
                course = course1;
            }
        }
        return course;*/
        return courseDao.getOne(courseId);

    }

    @Override
    public Course addCourse(Course course) {
       /* list.add(course);
        return course;*/
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
/*        Course course1 = null;
        for(Course c: list){
            if(c.getId() == course.getId()){
                c.setTitle(course.getTitle());
                c.setDescription(course.getDescription());
                course1 = c;
            }
        }
        return course1;*/
        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
/*        Course course;
        for(Course c: list){
            if(c.getId() == courseId){
                list.remove(c);
            }
        }*/
        Course entity = courseDao.getOne(courseId);
        courseDao.delete(entity);
    }
}
