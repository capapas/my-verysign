package org.esgi.dao;

import org.esgi.dao.impl.AbstractDao;
import org.esgi.model.Certificat;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CertificatDao extends AbstractDao<Certificat> {

    /**
     * @return
     */
    @SuppressWarnings("unchecked")
    public final List<Certificat> findAll() {
        return getCurrentSession().createQuery("FROM Certificat ORDER BY certName")
                .list();
    }

    /**
     * @return
     */
    public final int countAll() {
        return findAll().size();
    }

    /**
     * @param certName
     * @return
     */
    @SuppressWarnings("unchecked")
    public final Certificat findByName(String certName) {
        List<Certificat> certificats = getCurrentSession().createQuery(
                "FROM Certificat WHERE certName = '" + certName + "'").list();
        return certificats.get(0);
    }

    /**
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
    public final Certificat findById(int id) {
        List<Certificat> certificats = getCurrentSession().createQuery(
                "FROM Certificat WHERE id = " + id).list();
        return certificats.get(0);
    }
}