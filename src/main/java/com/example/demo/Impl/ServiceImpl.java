package com.example.demo.Impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.metier.Point;
import com.example.demo.service.ITraitement;

@Service
public class ServiceImpl implements ITraitement{

	public static boolean arrived;
	
	@Override
	public List<List<Point>> loadFileToVectors(String filePath) {
		FileReader fr;
		List<List<Point>> mat=null;
		try {
			fr = new FileReader(filePath);
	        BufferedReader br=new BufferedReader(fr); 
			mat = new ArrayList<List<Point>>();
	        String line;
	        try {
				while((line=br.readLine())!=null) {
					
					mat.add(new ArrayList<Point>());
					String[] data =line.split(" ");
					//System.out.println(Arrays.toString(data));
					for(String num : data) {
						mat.get(mat.size()-1).add(new Point(Integer.parseInt(num)));
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		System.out.println(mat.toString());
		return mat;
	}

	@Override
	public void searchForThePath(int distanceRavitaillment, List<List<Point>> mat) {
		// TODO Auto-generated method stub
		List<List<Boolean>> visited =new ArrayList<List<Boolean>>();
		arrived=false;
		
		for(int i=0;i<mat.size();i++) {
			visited.add(new ArrayList<Boolean>());
			for(int j=0;j<mat.get(0).size();j++)	visited.get(visited.size()-1).add(false);
		}
		
		recursiveSearchPath("(*)",mat, visited, distanceRavitaillment, 1, 0, 0);
		visited.clear();
	}

	@Override
	public boolean isFileWellConstructed(List<List<Point>> mat) {
		// TODO Auto-generated method stub
		if(mat.size()==0)	return false;
		int len,temp=mat.get(0).size();
		for(int i=1;i<mat.size();i++) {
			len=mat.get(i).size();
			if(len!=temp)	return false;
			temp=len;
		}
		return true;
	}
	
	@Override
	public void afficherParcours(List<List<Point>> mat) {
		for(int i=0;i<mat.size();i++) {
			for(int j=0;j<mat.get(0).size();j++)	System.out.print("("+i+","+j+")->"+"(Rav/IsPath)=("+mat.get(i).get(j).isRavitaillement()+"/"+mat.get(i).get(j).isInPath()+") ||");
			System.out.println("");
		}
	}
	
	private void recursiveSearchPath(String chemin,List<List<Point>> mat,List<List<Boolean>> visited,int distRavitaill,int indexPath,int row,int col) {
		
		if(row<0 || row>=mat.size() || col<0 || col>=mat.get(0).size())	return;
		if(visited.get(row).get(col))	return;
		
		if(mat.get(row).get(col).getPoint()==1) {
			mat.get(row).get(col).setInPath(false);
			mat.get(row).get(col).setRavitaillement(false);
			return;
		}
		if(row==mat.size()-1 && col==mat.get(0).size()-1)	{arrived=true;}
		System.out.print(chemin+" ");
		visited.get(row).set(col, true);
		mat.get(row).get(col).setInPath(true);
		
		if(indexPath==distRavitaill) {
			mat.get(row).get(col).setRavitaillement(true);
			indexPath=0;
		}
		else	mat.get(row).get(col).setRavitaillement(false);
		
		indexPath++;
		recursiveSearchPath("->",mat, visited, distRavitaill, indexPath, row, col+1);
		recursiveSearchPath("<-",mat, visited, distRavitaill, indexPath, row, col-1);
		recursiveSearchPath("|B",mat, visited, distRavitaill, indexPath, row+1, col);
		recursiveSearchPath("|H",mat, visited, distRavitaill, indexPath, row-1, col);
		
	}

	@Override
	public List<List<Point>> loadFileToVectors(InputStream file) {
		// TODO Auto-generated method stub
		BufferedReader reader=null;
		List<List<Point>> mat=null;
		reader=new BufferedReader(new InputStreamReader(file)); 
		mat = new ArrayList<List<Point>>();
		String line;
		try {
			while((line=reader.readLine())!=null) {
				
				mat.add(new ArrayList<Point>());
				String[] data =line.split(" ");
				//System.out.println(Arrays.toString(data));
				for(String num : data) {
					if(Integer.parseInt(num)!=0 && Integer.parseInt(num)!=1) return null;
					mat.get(mat.size()-1).add(new Point(Integer.parseInt(num)));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
		System.out.println(mat.toString());
		return mat;
	}
	
	
	
}

