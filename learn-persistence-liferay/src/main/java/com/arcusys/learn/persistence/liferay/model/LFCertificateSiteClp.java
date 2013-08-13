package com.arcusys.learn.persistence.liferay.model;

import com.arcusys.learn.persistence.liferay.service.LFCertificateSiteLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LFCertificateSiteClp extends BaseModelImpl<LFCertificateSite>
    implements LFCertificateSite {
    private long _id;
    private Integer _certificateID;
    private Integer _siteID;
    private Integer _arrangementIndex;
    private BaseModel<?> _lfCertificateSiteRemoteModel;

    public LFCertificateSiteClp() {
    }

    public Class<?> getModelClass() {
        return LFCertificateSite.class;
    }

    public String getModelClassName() {
        return LFCertificateSite.class.getName();
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
        attributes.put("certificateID", getCertificateID());
        attributes.put("siteID", getSiteID());
        attributes.put("arrangementIndex", getArrangementIndex());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long id = (Long) attributes.get("id");

        if (id != null) {
            setId(id);
        }

        Integer certificateID = (Integer) attributes.get("certificateID");

        if (certificateID != null) {
            setCertificateID(certificateID);
        }

        Integer siteID = (Integer) attributes.get("siteID");

        if (siteID != null) {
            setSiteID(siteID);
        }

        Integer arrangementIndex = (Integer) attributes.get("arrangementIndex");

        if (arrangementIndex != null) {
            setArrangementIndex(arrangementIndex);
        }
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public Integer getCertificateID() {
        return _certificateID;
    }

    public void setCertificateID(Integer certificateID) {
        _certificateID = certificateID;
    }

    public Integer getSiteID() {
        return _siteID;
    }

    public void setSiteID(Integer siteID) {
        _siteID = siteID;
    }

    public Integer getArrangementIndex() {
        return _arrangementIndex;
    }

    public void setArrangementIndex(Integer arrangementIndex) {
        _arrangementIndex = arrangementIndex;
    }

    public BaseModel<?> getLFCertificateSiteRemoteModel() {
        return _lfCertificateSiteRemoteModel;
    }

    public void setLFCertificateSiteRemoteModel(
        BaseModel<?> lfCertificateSiteRemoteModel) {
        _lfCertificateSiteRemoteModel = lfCertificateSiteRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LFCertificateSiteLocalServiceUtil.addLFCertificateSite(this);
        } else {
            LFCertificateSiteLocalServiceUtil.updateLFCertificateSite(this);
        }
    }

    @Override
    public LFCertificateSite toEscapedModel() {
        return (LFCertificateSite) Proxy.newProxyInstance(LFCertificateSite.class.getClassLoader(),
            new Class[] { LFCertificateSite.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LFCertificateSiteClp clone = new LFCertificateSiteClp();

        clone.setId(getId());
        clone.setCertificateID(getCertificateID());
        clone.setSiteID(getSiteID());
        clone.setArrangementIndex(getArrangementIndex());

        return clone;
    }

    public int compareTo(LFCertificateSite lfCertificateSite) {
        long primaryKey = lfCertificateSite.getPrimaryKey();

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

        LFCertificateSiteClp lfCertificateSite = null;

        try {
            lfCertificateSite = (LFCertificateSiteClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = lfCertificateSite.getPrimaryKey();

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
        StringBundler sb = new StringBundler(9);

        sb.append("{id=");
        sb.append(getId());
        sb.append(", certificateID=");
        sb.append(getCertificateID());
        sb.append(", siteID=");
        sb.append(getSiteID());
        sb.append(", arrangementIndex=");
        sb.append(getArrangementIndex());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append(
            "com.arcusys.learn.persistence.liferay.model.LFCertificateSite");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>certificateID</column-name><column-value><![CDATA[");
        sb.append(getCertificateID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>siteID</column-name><column-value><![CDATA[");
        sb.append(getSiteID());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>arrangementIndex</column-name><column-value><![CDATA[");
        sb.append(getArrangementIndex());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
