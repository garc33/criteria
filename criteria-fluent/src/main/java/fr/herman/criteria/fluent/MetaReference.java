package fr.herman.criteria.fluent;

import fr.herman.criteria.core.parameter.Reference;
import fr.herman.metatype.model.MetaProperty;
import fr.herman.metatype.model.method.Getter;

public class MetaReference<OBJECT, VALUE, T extends MetaProperty<OBJECT, VALUE> & Getter<OBJECT, VALUE>> extends Reference<OBJECT, VALUE>
{

    private final T property;

    public MetaReference(T property)
    {
        this.property = property;
    }

    @Override
    public String path()
    {
        return null;
    }

    public T getProperty()
    {
        return property;
    }

    @Override
    public VALUE value(OBJECT object)
    {
        return property.getValue(object);
    }

}
