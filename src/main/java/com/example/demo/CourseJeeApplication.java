package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.Impl.ServiceImpl;
import com.example.demo.metier.Point;

@SpringBootApplication
public class CourseJeeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(CourseJeeApplication.class, args);
		/*System.out.println("Hello");
		ServiceImpl answersLogic = new ServiceImpl();
		List<List<Point>> mat = answersLogic.loadFileToVectors("src\\main\\resources\\static\\test.txt");
		System.out.println("Well = "+answersLogic.isFileWellConstructed(mat));
		answersLogic.searchForThePath(2, mat);
		System.out.println("arrived "+answersLogic.arrived);
		answersLogic.afficherParcours(mat);
		 */
	}
}
