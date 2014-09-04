package fr.herman.criteria.core.parameter;

public class StaticValue<T> implements Parameter<T>
{
    private final T value;

    public StaticValue(T value)
    {
        this.value = value;
    }

    public T value()
    {
        return value;
    }

    public <RESULT, PARAM> RESULT accept(ParameterVisitor<RESULT, PARAM, T> visitor, PARAM param)
    {
        return visitor.visit(this, param);
    }
}
