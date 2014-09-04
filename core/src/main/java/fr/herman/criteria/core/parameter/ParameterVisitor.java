package fr.herman.criteria.core.parameter;

public abstract class ParameterVisitor<RESULT, PARAM, T>
{
    public abstract RESULT visit(StaticValue<T> staticValue, PARAM param);

    public abstract <OBJECT> RESULT visit(Reference<OBJECT, T> reference, PARAM param);

}
