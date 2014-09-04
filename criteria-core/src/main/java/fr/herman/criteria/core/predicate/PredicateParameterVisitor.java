package fr.herman.criteria.core.predicate;

import fr.herman.criteria.core.parameter.ParameterVisitor;
import fr.herman.criteria.core.parameter.Reference;
import fr.herman.criteria.core.parameter.StaticValue;

public class PredicateParameterVisitor<T, PARAM> extends ParameterVisitor<T, PARAM, T>
{

    @Override
    public T visit(StaticValue<T> staticValue, PARAM param)
    {
        return staticValue.value();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <OBJECT> T visit(Reference<OBJECT, T> reference, PARAM param)
    {
        return reference.value((OBJECT) param);
    }

}
