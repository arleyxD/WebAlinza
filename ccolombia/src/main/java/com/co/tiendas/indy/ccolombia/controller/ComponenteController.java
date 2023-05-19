package com.co.tiendas.indy.ccolombia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.tiendas.indy.ccolombia.model.ComponenteModel;
import com.co.tiendas.indy.ccolombia.services.ComponenteServiceimpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ComponenteController {
	
	@Autowired
	private ComponenteServiceimpl componenteserviceimpl;
	
	// Read operation
    @GetMapping("/componente")
    public List<ComponenteModel> fetchDepartmentList()
    {
        return componenteserviceimpl.fetchComponenteList();
    }
    
    @PostMapping("/componente")
    public ComponenteModel saveComponente(@RequestBody ComponenteModel componente) {
    	return componenteserviceimpl.saveComponente(componente);
    }
    
    @PutMapping("/componente/{id}")
    public ComponenteModel updateComponente(@RequestBody ComponenteModel componente,
                     @PathVariable("id") Long ComponenteId)
    {
        return componenteserviceimpl.updateComponente(componente, ComponenteId);
    }
 
    // Delete operation
    @DeleteMapping("/componente/{id}")
    public String deleteDepartmentById(@PathVariable("id")
                                       Long ComponenteId)
    {
        componenteserviceimpl.deleteComponenteById(ComponenteId);
        return "Deleted Successfully";
    }

}
