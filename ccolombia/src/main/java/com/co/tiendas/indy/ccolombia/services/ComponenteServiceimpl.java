package com.co.tiendas.indy.ccolombia.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.tiendas.indy.ccolombia.model.ComponenteModel;
import com.co.tiendas.indy.ccolombia.persisten.ComponentePersisten;

@Service
public class ComponenteServiceimpl implements ComponenteService {

	@Autowired
	private ComponentePersisten componentepersisten;

	@Override
	public List<ComponenteModel> fetchComponenteList() {
		// TODO Auto-generated method stub
		return (List<ComponenteModel>) componentepersisten.findAll();
	}

	@Override
	public ComponenteModel saveComponente(ComponenteModel componentemodel) {
		// TODO Auto-generated method stub
		return componentepersisten.save(componentemodel);
	}

	@Override
	public ComponenteModel updateComponente(ComponenteModel componentemodel, Long componenteId) {
		// TODO Auto-generated method stub
		ComponenteModel componente = componentepersisten.findById(componenteId).get();
		if (Objects.nonNull(componente.getSharedKey()) && !"".equalsIgnoreCase(componente.getSharedKey())) {
			componente.setSharedKey(componentemodel.getSharedKey());
		}if (Objects.nonNull(componente.getBusinessID()) && !"".equalsIgnoreCase(componente.getBusinessID())) {
			componente.setBusinessID(componentemodel.getBusinessID());
		}if (Objects.nonNull(componente.getEmail()) && !"".equalsIgnoreCase(componente.getEmail())) {
			componente.setEmail(componentemodel.getEmail());
		}if (Objects.nonNull(componente.getPhone()) && !"".equalsIgnoreCase(componente.getPhone())) {
			componente.setPhone(componentemodel.getBusinessID());
		}if (Objects.nonNull(componente.getStarDate())) {
			componente.setStarDate(componentemodel.getStarDate());
		}if (Objects.nonNull(componente.getStarend())) {
			componente.setStarend(componentemodel.getStarend());
		}
		return componentepersisten.save(componente);
	}

	@Override
	public void deleteComponenteById(Long componenteId) {
		// TODO Auto-generated method stub
		componentepersisten.deleteById(componenteId);

	}

}
