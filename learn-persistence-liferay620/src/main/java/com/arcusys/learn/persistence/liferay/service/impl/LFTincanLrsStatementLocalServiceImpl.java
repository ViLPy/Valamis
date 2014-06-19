package com.arcusys.learn.persistence.liferay.service.impl;

import com.arcusys.learn.persistence.liferay.NoSuchLFTincanLrsStatementException;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsContext;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatement;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsStatementRef;
import com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementRefLocalServiceUtil;
import com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsStatementLocalServiceBaseImpl;
import com.arcusys.learn.persistence.liferay.service.persistence.LFTincanLrsStatementPersistence;
import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.ArrayList;
import java.util.Date;

/**
 * The implementation of the l f tincan lrs statement local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arcusys.learn.persistence.liferay.service.base.LFTincanLrsStatementLocalServiceBaseImpl
 * @see com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalServiceUtil
 */
public class LFTincanLrsStatementLocalServiceImpl
    extends LFTincanLrsStatementLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arcusys.learn.persistence.liferay.service.LFTincanLrsStatementLocalServiceUtil} to access the l f tincan lrs statement local service.
     */

    public void removeAll() throws SystemException {
        lfTincanLrsStatementPersistence.removeAll();
    }

    public LFTincanLrsStatement createLFTincanLrsStatement() throws SystemException {
        return createLFTincanLrsStatement(counterLocalService.increment(LFTincanLrsStatement.class.getName()));
    }

    public java.util.List<LFTincanLrsStatement> findByActorID(Integer actorID) throws SystemException{
        return lfTincanLrsStatementPersistence.findByActorID(actorID);
    }

    public java.util.List<LFTincanLrsStatement> findByVerbID(String verbID) throws SystemException{
        return lfTincanLrsStatementPersistence.findByVerbID(verbID);
    }

    public java.util.List<LFTincanLrsStatement> findByObjTypeAndObjID(String objType, Integer objID) throws SystemException{
        return lfTincanLrsStatementPersistence.findByObjTypeAndObjID(objType, objID);
    }

    public LFTincanLrsStatement findByTincanID(String tincanID) throws SystemException, NoSuchLFTincanLrsStatementException {
        return lfTincanLrsStatementPersistence.findByTincanID(tincanID);
    }

    public java.util.List<LFTincanLrsStatement> findBy(String statementID,
                                                       String voidedStatementID,
                                                       Integer actorID,
                                                       String verbID,
                                                       Integer objID,
                                                       String registration,
                                                       Date since,
                                                       Date until,
                                                       Boolean related_activities,
                                                       Boolean related_agents,
                                                       Boolean ascending,
                                                       Integer limit) throws SystemException, NoSuchLFTincanLrsStatementException {

        DynamicQuery childQuery = DynamicQueryFactoryUtil.forClass(LFTincanLrsStatement.class, "voidedStatement")
                .setProjection(ProjectionFactoryUtil.property("voidedStatement.objID"))
                .add(PropertyFactoryUtil.forName("voidedStatement.verbID").eq("http://adlnet.gov/expapi/verbs/voided"))
                .add(PropertyFactoryUtil.forName("voidedStatement.objType").eq("StatementRef"));

        DynamicQuery strefQuery = DynamicQueryFactoryUtil.forClass(LFTincanLrsStatementRef.class, "statementRef")
                .setProjection(ProjectionFactoryUtil.property("statementRef.uuid"))
                .add(PropertyFactoryUtil.forName("statementRef.id").in(childQuery));

        // return by stetement id
        // voided
        if (voidedStatementID != null) {
            DynamicQuery voidedQuery = DynamicQueryFactoryUtil.forClass(LFTincanLrsStatement.class, "statement")
                .add(PropertyFactoryUtil.forName("statement.tincanID").in(strefQuery))
                .add(PropertyFactoryUtil.forName("statement.tincanID").eq(voidedStatementID));
            java.util.List<LFTincanLrsStatement> requestList = LFTincanLrsStatementLocalServiceUtil.dynamicQuery(voidedQuery);
            return requestList;
        }
        // not voided
        if(statementID != null){
            DynamicQuery statementQuery = DynamicQueryFactoryUtil.forClass(LFTincanLrsStatement.class, "statement")
                    .add(PropertyFactoryUtil.forName("statement.tincanID").notIn(strefQuery))
                    .add(PropertyFactoryUtil.forName("statement.tincanID").eq(statementID));
            java.util.List<LFTincanLrsStatement> requestList = LFTincanLrsStatementLocalServiceUtil.dynamicQuery(statementQuery);
            return requestList;
        }
        // other cases
        DynamicQuery statementQuery = DynamicQueryFactoryUtil.forClass(LFTincanLrsStatement.class, "statement")
                .add(PropertyFactoryUtil.forName("statement.tincanID").notIn(strefQuery));

        if(actorID != null){
            Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
            Criterion criterion = RestrictionsFactoryUtil.eq("statement.actorID", actorID);
            disjunction.add(criterion);

            if(related_agents){
                // subquery for relative agents
                // object = actor
                Criterion objcriterion = RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("statement.objType", "Agent"), RestrictionsFactoryUtil.eq("statement.objType", "Group"));
                disjunction.add(RestrictionsFactoryUtil.and(RestrictionsFactoryUtil.eq("statement.objID", actorID), objcriterion));

                // authority actor
                disjunction.add(RestrictionsFactoryUtil.eq("statement.authorityID", actorID));

                // SubStatement actor
                DynamicQuery substmQuery = DynamicQueryFactoryUtil.forClass(LFTincanLrsSubStatement.class, "subStatement")
                        .setProjection(ProjectionFactoryUtil.property("subStatement.id"))
                        .add(PropertyFactoryUtil.forName("subStatement.actorID").eq(actorID));
                disjunction.add(RestrictionsFactoryUtil.conjunction().add(PropertyFactoryUtil.forName("statement.objID").in(substmQuery))
                        .add(PropertyFactoryUtil.forName("statement.objType").eq("SubStatement")));

                // context instructor and team
                DynamicQuery contextQuery = DynamicQueryFactoryUtil.forClass(LFTincanLrsContext.class, "context")
                        .setProjection(ProjectionFactoryUtil.property("context.id"));
                Criterion subcriterion = RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("context.instructorID", actorID), RestrictionsFactoryUtil.eq("context.teamID", actorID));
                contextQuery.add(subcriterion);
                disjunction.add(PropertyFactoryUtil.forName("statement.contextID").in(contextQuery));
            }
            statementQuery.add(disjunction);
        }

        if(verbID != null)
            statementQuery.add(PropertyFactoryUtil.forName("statement.verbID").eq(verbID));
        if(objID != null){
            Disjunction disjunction = RestrictionsFactoryUtil.disjunction();
            Criterion criterion = null;
            criterion = RestrictionsFactoryUtil.eq("statement.objType", "Activity");
            criterion =  RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("statement.objID", objID));

            disjunction.add(criterion);
//            statementQuery.add(PropertyFactoryUtil.forName("statement.objtype").eq("Activity"))
//                          .add(PropertyFactoryUtil.forName("statement.objid").eq(objID));
            if(related_activities){
                // subquery for relative activities
                DynamicQuery substmQuery = DynamicQueryFactoryUtil.forClass(LFTincanLrsSubStatement.class, "subStatement")
                        .setProjection(ProjectionFactoryUtil.property("subStatement.id"))
                        .add(PropertyFactoryUtil.forName("subStatement.objType").eq("Activity"))
                        .add(PropertyFactoryUtil.forName("subStatement.objID").eq(objID));

                disjunction.add(
                        RestrictionsFactoryUtil.conjunction().add(PropertyFactoryUtil.forName("statement.objID").in(substmQuery))
                                .add(PropertyFactoryUtil.forName("statement.objType").eq("SubStatement"))
                );
                //criterion =  RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.in("statement.objID", substmQuery.));
            }
            statementQuery.add(disjunction);
        }
        if(registration != null){
            DynamicQuery contextQuery = DynamicQueryFactoryUtil.forClass(LFTincanLrsContext.class, "context")
                    .setProjection(ProjectionFactoryUtil.property("context.id"))
                    .add(PropertyFactoryUtil.forName("context.registration").eq(registration));
            statementQuery.add(PropertyFactoryUtil.forName("statement.contextID").eq(contextQuery));
        }
        if(since != null)
            statementQuery.add(PropertyFactoryUtil.forName("statement.timestamp").ge(since));
        if(until != null)
            statementQuery.add(PropertyFactoryUtil.forName("statement.timestamp").le(until));

        if(limit != null && limit != 0){
            // Maximum number of Statements to return. 0 indicates return the maximum the server will allow.
            statementQuery.setLimit(0,limit);
        }

        if(ascending){
            // If true, return results in ascending order of stored time
            statementQuery.addOrder(OrderFactoryUtil.asc("statement.stored"));
        }


        java.util.List<LFTincanLrsStatement> requestList = LFTincanLrsStatementLocalServiceUtil.dynamicQuery(statementQuery);
        return requestList;
    }
}
