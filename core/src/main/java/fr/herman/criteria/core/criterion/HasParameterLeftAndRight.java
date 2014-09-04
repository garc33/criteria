package fr.herman.criteria.core.criterion;

import fr.herman.criteria.core.parameter.Parameter;

public class HasParameterLeftAndRight<T>
{
    private final Parameter<T> left, right;

    public HasParameterLeftAndRight(Parameter<T> left, Parameter<T> right)
    {
        this.left = left;
        this.right = right;
    }

    public Parameter<T> getLeft()
    {
        return left;
    }

    public Parameter<T> getRight()
    {
        return right;
    }
}
