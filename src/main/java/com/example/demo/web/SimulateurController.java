package com.example.demo.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.metier.Point;
import com.example.demo.service.ITraitement;

@Controller
@RequestMapping("/simulateur")
public class SimulateurController {
	
	@Autowired
	private ITraitement traitement;
	
	@RequestMapping(method=RequestMethod.GET)
	public String pageAccueil() {
		return "Test"; 
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String result(Model model, @RequestParam("file") MultipartFile uploadingFiles,@RequestParam("valeur") String val) {
		try {
			 List<List<Point>> mat = traitement.loadFileToVectors(uploadingFiles.getInputStream());
			 if(mat==null || !traitement.isFileWellConstructed(mat)) {
				 model.addAttribute("fileRemarque", "Veuillez taper un fichier valide");
			 }
			 else {
				 System.out.println(mat.get(0).size()+"/"+mat.get(0).size());
				 traitement.searchForThePath(Integer.parseInt(val), mat);
				 traitement.afficherParcours(mat);
				 //model.addAttribute("distance",	Integer.parseInt(val));
				 model.addAttribute("matrice", mat);
			 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "simulateur";
	}
}
