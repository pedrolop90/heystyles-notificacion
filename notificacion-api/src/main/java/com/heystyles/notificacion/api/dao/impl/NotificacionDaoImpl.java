package com.heystyles.notificacion.api.dao.impl;

import com.heystyles.common.types.Page;
import com.heystyles.notificacion.api.dao.NotificacionCustomDao;
import com.heystyles.notificacion.api.entity.NotificacionEntity;
import com.heystyles.notificacion.core.filter.NotificacionFilter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional(readOnly = true)
public class NotificacionDaoImpl implements NotificacionCustomDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<NotificacionEntity> getPage(NotificacionFilter filter) {
        Session session = entityManager.unwrap(org.hibernate.Session.class);

        Criteria totalCriteria = session.createCriteria(NotificacionEntity.class);

        Criteria pageCriteria = session.createCriteria(NotificacionEntity.class);

        applyWhere(totalCriteria, filter);
        applyWhere(pageCriteria, filter);

        applySort(totalCriteria, filter);
        applySort(pageCriteria, filter);

        queryCount(totalCriteria);
        queryPage(pageCriteria, filter.getPageNumber(), filter.getPageSize());

        Long total = (Long) totalCriteria.uniqueResult();
        List<NotificacionEntity> entities = pageCriteria.list();

        return new Page<>(total, entities);
    }

    private void applyWhere(Criteria criteria, NotificacionFilter filter) {
        if (filter.getCargoId() != null) {
            criteria.add(Restrictions.eq(NotificacionEntity.Attributes.CARGO, filter.getCargoId()));
        }
        if (filter.getEstado() != null) {
            criteria.add(Restrictions.eq(NotificacionEntity.Attributes.ESTADO, filter.getEstado()));
        }
        if (filter.getFechaInicial() != null) {
            criteria.add(Restrictions.ge(
                    NotificacionEntity.Attributes.CREATED_DATE, filter.getFechaInicial()));
        }
        if (filter.getFechaFinal() != null) {
            criteria.add(Restrictions.le(
                    NotificacionEntity.Attributes.CREATED_DATE, filter.getFechaFinal()));
        }
    }

    private void applySort(Criteria criteria, NotificacionFilter filter) {
        if (filter.getFechaAscending() != null) {
            if (filter.getFechaAscending()) {
                criteria.addOrder(Order.asc(NotificacionEntity.Attributes.CREATED_DATE));
            }
            else {
                criteria.addOrder(Order.desc(NotificacionEntity.Attributes.CREATED_DATE));
            }
        }
    }

    private void queryCount(Criteria criteria) {
        criteria.setProjection(Projections.count(NotificacionEntity.Attributes.ID));
    }

    private void queryPage(Criteria criteria, Integer pageNumber, Integer pageSize) {
        if (pageNumber != null && pageSize != null) {
            criteria.setFirstResult(pageNumber * pageSize);
            criteria.setMaxResults(pageSize);
        }
    }
}
