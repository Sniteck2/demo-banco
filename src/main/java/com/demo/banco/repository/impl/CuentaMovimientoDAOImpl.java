package com.demo.banco.repository.impl;

import com.demo.banco.repository.CuentaMovimientoDAO;
import com.demo.banco.repository.model.CuentaMovimiento;
import com.demo.banco.repository.model.CuentaUsuario;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CuentaMovimientoDAOImpl implements CuentaMovimientoDAO {

  private final EntityManager em;

  @Autowired
  public CuentaMovimientoDAOImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public List<CuentaMovimiento> buscarMovimiento(CuentaUsuario cuentaUsuario) {
    TypedQuery<CuentaMovimiento> query = em.createQuery("FROM CuentaMovimiento cm WHERE cm.cuentaUsuario =:cuentaUsuario", CuentaMovimiento.class);
    query.setParameter("cuentaUsuario", cuentaUsuario);
    return query.getResultList().isEmpty() ? Collections.emptyList() : query.getResultList();
  }

  @Override
  @Transactional
  public CuentaMovimiento agregarMovimiento(CuentaMovimiento cuentaMovimiento) {
    em.persist(cuentaMovimiento);
    return cuentaMovimiento;
  }
}
