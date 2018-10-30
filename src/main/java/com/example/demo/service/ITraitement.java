package com.example.demo.service;

import java.io.InputStream;
import java.util.List;

import com.example.demo.metier.Point;

public interface ITraitement {
	
	public List<List<Point>> loadFileToVectors(String filePath);
	
	public List<List<Point>> loadFileToVectors(InputStream file);
	
	public void searchForThePath(int distanceRavitaillment,List<List<Point>> mat); 
	
	public boolean isFileWellConstructed(List<List<Point>> mat);
	
	public void afficherParcours(List<List<Point>> mat);
}
