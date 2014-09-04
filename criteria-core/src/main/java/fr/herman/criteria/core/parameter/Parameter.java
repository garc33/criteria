package fr.herman.criteria.core.parameter;

import fr.herman.criteria.core.Expression;

public interface Parameter<T> extends Expression<T>
{
    <RESULT, PARAM> RESULT accept(ParameterVisitor<RESULT, PARAM, T> visitor, PARAM param);
}
