package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFTincanLrsSubStatementLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFTincanLrsSubStatementClp extends BaseModelImpl<LFTincanLrsSubStatement>
    implements LFTincanLrsSubStatement {
    private long _id;
    private Integer _actorID;
    private String _verbID;
    private String _verbDisplay;
    private String _objType;
    private Integer _objID;
    private BaseModel<?> _lfTincanLrsSubStatementRemoteModel;

    public LFTincanLrsSubStatementClp() {
    }

    public Class<?> getModelClass() {
        return LFTincanLrsSubStatement.class;
    }

    public String getModelClassName() {
        return LFTincanLrsSubStatement.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("id", getId());
        attributes.put("actorID", getActorID());
        attributes.put("verbID", getVerbID());
        attributes.put("verbDisplay", getVerbDisplay());
        attributes.put("objType", getObjType());
        attributes.put("objID", getObjID());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer actorID = (Integer) attributes.get("actorID");

        if (actorID != null) {
            setActorID(actorID);
        }

        String verbID = (String) attributes.get("verbID");

        if (verbID != null) {
            setVerbID(verbID);
        }

        String verbDisplay = (String) attributes.get("verbDisplay");

        if (verbDisplay != null) {
            setVerbDisplay(verbDisplay);
        }

        String objType = (String) attributes.get("objType");

        if (objType != null) {
            setObjType(objType);
        }

        Integer objID = (Integer) attributes.get("objID");

        if (objID != null) {
            setObjID(objID);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getActorID() {
        return _actorID;
    }

    public void setActorID(Integer actorID) {
        _actorID = actorID;
    }

    public String getVerbID() {
        return _verbID;
    }

    public void setVerbID(String verbID) {
        _verbID = verbID;
    }

    public String getVerbDisplay() {
        return _verbDisplay;
    }

    public void setVerbDisplay(String verbDisplay) {
        _verbDisplay = verbDisplay;
    }

    public String getObjType() {
        return _objType;
    }

    public void setObjType(String objType) {
        _objType = objType;
    }

    public Integer getObjID() {
        return _objID;
    }

    public void setObjID(Integer objID) {
        _objID = objID;
    }

    public BaseModel<?> getLFTincanLrsSubStatementRemoteModel() {
        return _lfTincanLrsSubStatementRemoteModel;
    }

    public void setLFTincanLrsSubStatementRemoteModel(
        BaseModel<?> lfTincanLrsSubStatementRemoteModel) {
        _lfTincanLrsSubStatementRemoteModel = lfTincanLrsSubStatementRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFTincanLrsSubStatementLocalServiceUtil.addLFTincanLrsSubStatement(this);
        } else {
            LFTincanLrsSubStatementLocalServiceUtil.updateLFTincanLrsSubStatement(this);
        }
    }

    @Override
    public LFTincanLrsSubStatement toEscapedModel() {
        return (LFTincanLrsSubStatement) Proxy.newProxyInstance(LFTincanLrsSubStatement.class.getClassLoader(),
            new Class[] { LFTincanLrsSubStatement.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFTincanLrsSubStatementClp clone = new LFTincanLrsSubStatementClp();

        clone.setId(getId());
        clone.setActorID(getActorID());
        clone.setVerbID(getVerbID());
        clone.setVerbDisplay(getVerbDisplay());
        clone.setObjType(getObjType());
        clone.setObjID(getObjID());

        return clone;
    }

    public int compareTo(LFTincanLrsSubStatement lfTincanLrsSubStatement) {
        long primaryKey = lfTincanLrsSubStatement.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        LFTincanLrsSubStatementClp lfTincanLrsSubStatement = null;

        try {
            lfTincanLrsSubStatement = (LFTincanLrsSubStatementClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfTincanLrsSubStatement.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", actorID=");
        sb.append(getActorID());
        sb.append(", verbID=");
        sb.append(getVerbID());
        sb.append(", verbDisplay=");
        sb.append(getVerbDisplay());
        sb.append(", objType=");
        sb.append(getObjType());
        sb.append(", objID=");
        sb.append(getObjID());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFTincanLrsSubStatement");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>actorID</column-name><column-value><![CDATA[");
        sb.append(getActorID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>verbID</column-name><column-value><![CDATA[");
        sb.append(getVerbID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>verbDisplay</column-name><column-value><![CDATA[");
        sb.append(getVerbDisplay());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objType</column-name><column-value><![CDATA[");
        sb.append(getObjType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>objID</column-name><column-value><![CDATA[");
        sb.append(getObjID());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
