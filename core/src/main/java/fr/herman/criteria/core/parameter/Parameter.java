package fr.herman.criteria.parameter;

import fr.herman.criteria.Expression;

public interface Parameter<T> extends Expression<T>
{
    <RESULT, PARAM> RESULT accept(ParameterVisitor<RESULT, PARAM, T> visitor, PARAM param);
}
