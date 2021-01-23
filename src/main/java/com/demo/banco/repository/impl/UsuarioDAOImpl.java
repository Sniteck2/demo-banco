package com.demo.banco.repository.impl;

import com.demo.banco.repository.UsuarioDAO;
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
public class UsuarioDAOImpl implements UsuarioDAO {

  private final Log logger = LogFactory.getLog("Usuario");
  private final EntityManager em;

  @Autowired
  public UsuarioDAOImpl(EntityManager em) {
    this.em = em;
  }

  @Override
  public Usuario buscarId(Long id) {
    return em.find(Usuario.class, id);
  }

  @Override
  public Usuario buscarUsuario(String rut, String password) {
    Usuario usuario = new Usuario();
    try {
      if (rut != null && password != null) {
        TypedQuery<Usuario> query = em
            .createQuery("FROM Usuario u WHERE u.rut =:rut AND u.password =:password",
                Usuario.class);
        query.setParameter("rut", rut);
        query.setParameter("password", password);
        usuario = query.getSingleResult();
      }
    } catch (NoResultException result) {
      usuario = new Usuario();
      usuario.setId(-1L);
      logger.warn("Error: " + result.getLocalizedMessage());
    }
    return usuario;
  }

  @Override
  @Transactional
  public Usuario agregarUsuario(Usuario usuario) {
    em.persist(usuario);
    return usuario;
  }

  @Override
  public Usuario buscarUsuarioRut(String rut) {
    Usuario usuario = new Usuario();
    try {
      if (rut != null) {
        TypedQuery<Usuario> query = em
            .createQuery("FROM Usuario u WHERE u.rut =:rut",
                Usuario.class);
        query.setParameter("rut", rut);
        usuario = query.getSingleResult();
      }
    } catch (NoResultException result) {
      usuario = new Usuario();
      usuario.setId(-1L);
      logger.warn("Error: " + result.getLocalizedMessage());
    }
    return usuario;
  }
}
