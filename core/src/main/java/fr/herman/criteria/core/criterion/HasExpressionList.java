package fr.herman.criteria.core.criterion;

import java.util.List;

public class HasExpressionList<T>
{
    private final List<T> list;

    public HasExpressionList(List<T> expressions)
    {
        list = expressions;
    }

    public List<T> getList()
    {
        return list;
    }
}
