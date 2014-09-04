package fr.herman.criteria.parameter;

public abstract class Reference<OBJECT, VALUE> implements Parameter<VALUE>
{
    public abstract VALUE value();

    public abstract String path();

    public <RESULT, PARAM> RESULT accept(ParameterVisitor<RESULT, PARAM, VALUE> visitor, PARAM param)
    {
        return visitor.visit(this, param);
    }
}
