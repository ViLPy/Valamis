package com.liferay.portal.tools.servicebuilder;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.SAXReader;
import com.liferay.portal.model.ModelHints;
import com.liferay.portal.model.ModelHintsConstants;
import com.liferay.portal.xml.SAXReaderImpl;
import com.liferay.util.PwdGenerator;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class ModelHintsLoader implements ModelHints {

    public ModelHintsLoader(String source) {
        _hintCollections = new HashMap<String, Map<String, String>>();
        _defaultHints = new HashMap<String, Map<String, String>>();
        _modelFields = new HashMap<String, Object>();
        _models = new TreeSet<String>();
        _saxReader = new SAXReaderImpl();
        _source = source;
        try {
            read(_source);
        }
        catch (Exception e) {
            _log.error(e, e);
        }
    }

    @Override
    public String buildCustomValidatorName(String validatorName) {
        return validatorName.concat(StringPool.UNDERLINE).concat(
            PwdGenerator.getPassword(PwdGenerator.KEY3, 4));
    }

    @Override
    public Map<String, String> getDefaultHints(String model) {
        return _defaultHints.get(model);
    }

    @Override
    public Element getFieldsEl(String model, String field) {
        Map<String, Object> fields = (Map<String, Object>)_modelFields.get(model);

        if (fields == null) {
            return null;
        }
        else {
            Element fieldsEl = (Element)fields.get(field + _ELEMENTS_SUFFIX);

            if (fieldsEl == null) {
                return null;
            }
            else {
                return fieldsEl;
            }
        }
    }

    @Override
    public Map<String, String> getHints(String model, String field) {
        Map<String, Object> fields = (Map<String, Object>)_modelFields.get(model);

        if (fields == null) {
            return null;
        }
        else {
            return (Map<String, String>)fields.get(field + _HINTS_SUFFIX);
        }
    }

    @Override
    public int getMaxLength(String model, String field) {
        Map<String, String> hints = getHints(model, field);

        if (hints == null) {
            return Integer.MAX_VALUE;
        }

        int maxLength = GetterUtil.getInteger(
                ModelHintsConstants.TEXT_MAX_LENGTH);

        maxLength = GetterUtil.getInteger(hints.get("max-length"), maxLength);

        return maxLength;
    }

    @Override
    public List<String> getModels() {
        return ListUtil.fromCollection(_models);
    }

    @Override
    public Tuple getSanitizeTuple(String model, String field) {
        Map<String, Object> fields = (Map<String, Object>)_modelFields.get(model);

        if (fields == null) {
            return null;
        }
        else {
            return (Tuple)fields.get(field + _SANITIZE_SUFFIX);
        }
    }

    @Override
    public List<Tuple> getSanitizeTuples(String model) {
        Map<String, Object> fields = (Map<String, Object>)_modelFields.get(model);

        if (fields == null) {
            return Collections.emptyList();
        }

        List<Tuple> sanitizeTuples = new ArrayList<Tuple>();

        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            String key = entry.getKey();

            if (key.endsWith(_SANITIZE_SUFFIX)) {
                Tuple sanitizeTuple = (Tuple)entry.getValue();

                sanitizeTuples.add(sanitizeTuple);
            }
        }

        return sanitizeTuples;
    }

    @Override
    public String getType(String model, String field) {
        Map<String, Object> fields = (Map<String, Object>)_modelFields.get(model);

        if (fields == null) {
            return null;
        }
        else {
            return (String)fields.get(field + _TYPE_SUFFIX);
        }
    }

    @Override
    public List<Tuple> getValidators(String model, String field) {
        Map<String, Object> fields = (Map<String, Object>)_modelFields.get(model);

        if ((fields == null) ||
                (fields.get(field + _VALIDATORS_SUFFIX) == null)) {

            return null;
        }
        else {
            return (List<Tuple>)fields.get(field + _VALIDATORS_SUFFIX);
        }
    }

    @Override
    public String getValue(
            String model, String field, String name, String defaultValue) {

        Map<String, String> hints = getHints(model, field);

        if (hints == null) {
            return defaultValue;
        }

        return GetterUtil.getString(hints.get(name), defaultValue);
    }

    @Override
    public boolean hasField(String model, String field) {
        Map<String, Object> fields = (Map<String, Object>)_modelFields.get(
                model);

        if (fields == null) {
            return false;
        }

        return fields.containsKey(field + _ELEMENTS_SUFFIX);
    }

    @Override
    public boolean isCustomValidator(String validatorName) {
        if (validatorName.equals("custom")) {
            return true;
        }

        return false;
    }

    @Override
    public boolean isLocalized(String model, String field) {
        Map<String, Object> fields = (Map<String, Object>)_modelFields.get(model);

        if (fields == null) {
            return false;
        }

        Boolean localized = (Boolean)fields.get(field + _LOCALIZATION_SUFFIX);

        if (localized != null) {
            return localized;
        }
        else {
            return false;
        }
    }

    @Override
    public void read(ClassLoader classLoader, String source) throws Exception {
        read(_source);
    }

    @Override
    public String trimString(String model, String field, String value) {
        if (value == null) {
            return value;
        }

        Map<String, String> hints = getHints(model, field);

        if (hints == null) {
            return value;
        }

        int maxLength = GetterUtil.getInteger(
                ModelHintsConstants.TEXT_MAX_LENGTH);

        maxLength = GetterUtil.getInteger(hints.get("max-length"), maxLength);

        if (value.length() > maxLength) {
            return value.substring(0, maxLength);
        }
        else {
            return value;
        }
    }


    public void read(String source) throws Exception {
        InputStream is = new FileInputStream(source);

        if (is == null) {
            if (_log.isWarnEnabled()) {
                _log.warn("Cannot load " + source);
            }

            return;
        }
        else {
            if (_log.isDebugEnabled()) {
                _log.debug("Loading " + source);
            }
        }

        Document doc = _saxReader.read(is);

        Element root = doc.getRootElement();

        Iterator<Element> itr1 = root.elements("hint-collection").iterator();

        while (itr1.hasNext()) {
            Element hintCollection = itr1.next();

            String name = hintCollection.attributeValue("name");

            Map<String, String> hints = _hintCollections.get(name);

            if (hints == null) {
                hints = new HashMap<String, String>();

                _hintCollections.put(name, hints);
            }

            Iterator<Element> itr2 = hintCollection.elements("hint").iterator();

            while (itr2.hasNext()) {
                Element hint = itr2.next();

                String hintName = hint.attributeValue("name");
                String hintValue = hint.getText();

                hints.put(hintName, hintValue);
            }
        }

        itr1 = root.elements("model").iterator();

        while (itr1.hasNext()) {
            Element model = itr1.next();

            String name = model.attributeValue("name");

            Map<String, String> defaultHints = new HashMap<String, String>();

            _defaultHints.put(name, defaultHints);

            Element defaultHintsEl = model.element("default-hints");

            if (defaultHintsEl != null) {
                Iterator<Element> itr2 = defaultHintsEl.elements(
                        "hint").iterator();

                while (itr2.hasNext()) {
                    Element hint = itr2.next();

                    String hintName = hint.attributeValue("name");
                    String hintValue = hint.getText();

                    defaultHints.put(hintName, hintValue);
                }
            }

            Map<String, Object> fields = (Map<String, Object>)_modelFields.get(name);

            if (fields == null) {
                fields = new LinkedHashMap<String, Object>();

                _modelFields.put(name, fields);
            }

            _models.add(name);

            Iterator<Element> itr2 = model.elements("field").iterator();

            while (itr2.hasNext()) {
                Element field = itr2.next();

                String fieldName = field.attributeValue("name");
                String fieldType = field.attributeValue("type");
                boolean fieldLocalized = GetterUtil.getBoolean(
                        field.attributeValue("localized"));

                Map<String, String> fieldHints = new HashMap<String, String>();

                fieldHints.putAll(defaultHints);

                Iterator<Element> itr3 = field.elements(
                        "hint-collection").iterator();

                while (itr3.hasNext()) {
                    Element hintCollection = itr3.next();

                    Map<String, String> hints = _hintCollections.get(
                            hintCollection.attributeValue("name"));

                    fieldHints.putAll(hints);
                }

                itr3 = field.elements("hint").iterator();

                while (itr3.hasNext()) {
                    Element hint = itr3.next();

                    String hintName = hint.attributeValue("name");
                    String hintValue = hint.getText();

                    fieldHints.put(hintName, hintValue);
                }

                Tuple fieldSanitize = null;

                Element sanitize = field.element("sanitize");

                if (sanitize != null) {
                    String contentType = sanitize.attributeValue(
                            "content-type");
                    String modes = sanitize.attributeValue("modes");

                    fieldSanitize = new Tuple(fieldName, contentType, modes);
                }

                Map<String, Tuple> fieldValidators =
                        new TreeMap<String, Tuple>();

                itr3 = field.elements("validator").iterator();

                while (itr3.hasNext()) {
                    Element validator = itr3.next();

                    String validatorName = validator.attributeValue("name");

                    if (Validator.isNull(validatorName)) {
                        continue;
                    }

                    String validatorErrorMessage = GetterUtil.getString(
                            validator.attributeValue("error-message"));
                    String validatorValue = GetterUtil.getString(
                            validator.getText());
                    boolean customValidator = isCustomValidator(validatorName);

                    if (customValidator) {
                        validatorName = buildCustomValidatorName(validatorName);
                    }

                    Tuple fieldValidator = new Tuple(
                            fieldName, validatorName, validatorErrorMessage,
                            validatorValue, customValidator);

                    fieldValidators.put(validatorName, fieldValidator);
                }

                fields.put(fieldName + _ELEMENTS_SUFFIX, field);
                fields.put(fieldName + _TYPE_SUFFIX, fieldType);
                fields.put(fieldName + _LOCALIZATION_SUFFIX, fieldLocalized);
                fields.put(fieldName + _HINTS_SUFFIX, fieldHints);

                if (fieldSanitize != null) {
                    fields.put(fieldName + _SANITIZE_SUFFIX, fieldSanitize);
                }

                if (!fieldValidators.isEmpty()) {
                    fields.put(
                            fieldName + _VALIDATORS_SUFFIX,
                            ListUtil.fromMapValues(fieldValidators));
                }
            }
        }
    }

    public ModelHints getModelHints() {
        return this;
    }

    private static final String _ELEMENTS_SUFFIX = "_ELEMENTS";

    private static final String _HINTS_SUFFIX = "_HINTS";

    private static final String _LOCALIZATION_SUFFIX = "_LOCALIZATION";

    private static final String _SANITIZE_SUFFIX = "_SANITIZE_SUFFIX";

    private static final String _TYPE_SUFFIX = "_TYPE";

    private static final String _VALIDATORS_SUFFIX = "_VALIDATORS";

    private static Log _log = LogFactoryUtil.getLog(ModelHintsLoader.class);

    private Map<String, Map<String, String>> _defaultHints;
    private Map<String, Map<String, String>> _hintCollections;
    private Map<String, Object> _modelFields;
    private Set<String> _models;
    private SAXReader _saxReader;
    private String _source;
}