package fr.herman.criteria.core.parameter;

public abstract class Reference<OBJECT, VALUE> implements Parameter<VALUE>
{
    public abstract VALUE value(OBJECT object);

    public abstract String path();

    @Override
    public <RESULT, PARAM> RESULT accept(ParameterVisitor<RESULT, PARAM, VALUE> visitor, PARAM param)
    {
        return visitor.visit(this, param);
    }
}
