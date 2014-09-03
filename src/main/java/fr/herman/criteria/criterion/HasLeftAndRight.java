package fr.herman.criteria.criterion;

import fr.herman.criteria.parameter.Parameter;

public class HasLeftAndRight<T>
{
    private final Parameter<T> left, right;

    public HasLeftAndRight(Parameter<T> left, Parameter<T> right)
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
