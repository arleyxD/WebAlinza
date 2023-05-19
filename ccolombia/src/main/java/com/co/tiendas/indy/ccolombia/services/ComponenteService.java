package com.co.tiendas.indy.ccolombia.services;

import java.util.List;

import com.co.tiendas.indy.ccolombia.model.ComponenteModel;

public interface ComponenteService {
	List<ComponenteModel> fetchComponenteList();
	
	ComponenteModel saveComponente(ComponenteModel componentemodel);
	
	// Update operation
	ComponenteModel updateComponente(ComponenteModel componentemodel,
                                Long componenteId);
 
    // Delete operation
    void deleteComponenteById(Long componenteId);
}
