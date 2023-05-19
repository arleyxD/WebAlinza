package com.co.tiendas.indy.ccolombia.persisten;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.co.tiendas.indy.ccolombia.model.ComponenteModel;

@Repository
public interface ComponentePersisten extends JpaRepository<ComponenteModel, Long>{
}
