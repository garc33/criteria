package fr.herman.criteria.predicate;

import fr.herman.criteria.parameter.ParameterVisitor;
import fr.herman.criteria.parameter.Reference;
import fr.herman.criteria.parameter.StaticValue;

public class PredicateParameterVisitor<T> extends ParameterVisitor<T, Void, T>
{

    @Override
    public T visit(StaticValue<T> staticValue, Void param)
    {
        return staticValue.value();
    }

    @Override
    public <OBJECT> T visit(Reference<OBJECT, T> reference, Void param)
    {
        return reference.value();
    }

}
