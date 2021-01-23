package com.demo.banco.repository.impl;

import com.demo.banco.repository.CuentaUsuarioDAO;
import com.demo.banco.repository.model.CuentaUsuario;
import com.demo.banco.repository.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CuentaUsuarioDAOImpl implements CuentaUsuarioDAO {

  private final Log logger = LogFactory.getLog("CuentaUsuario");
  private final EntityManager em;

  @Autowired
  public CuentaUsuarioDAOImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public CuentaUsuario buscarId(Long id) {
    return em.find(CuentaUsuario.class, id);
  }

  @Override
  public CuentaUsuario buscarCuenta(Usuario usuario) {
    CuentaUsuario cuentaUsuario = new CuentaUsuario();
    try{
      Usuario user = new Usuario();
      user.setId(usuario.getId());
      TypedQuery<CuentaUsuario> query = em.createQuery("FROM CuentaUsuario cu WHERE cu.usuario =:usuario", CuentaUsuario.class);
      query.setParameter("usuario", user);
      cuentaUsuario = query.getSingleResult();
    }catch(NoResultException resultException){
      cuentaUsuario.setId(-1L);
      logger.warn("Error: " + resultException.getLocalizedMessage());
    }
    return cuentaUsuario;
  }

  @Override
  @Transactional
  public CuentaUsuario agregarCuenta(CuentaUsuario cuentaUsuario) {
    em.persist(cuentaUsuario);
    return cuentaUsuario;
  }
}
