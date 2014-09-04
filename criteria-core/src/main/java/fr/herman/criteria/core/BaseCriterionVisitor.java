package fr.herman.criteria.core;

import static java.lang.String.format;
import fr.herman.criteria.core.criterion.objects.EqualCriterion;
import fr.herman.criteria.core.criterion.objects.SameCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.AndCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.NotCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.OrCriterion;
import fr.herman.criteria.core.criterion.objects.comparable.GreaterCriterion;
import fr.herman.criteria.core.criterion.objects.comparable.LesserCriterion;

public class BaseCriterionVisitor<RESULT, PARAM> extends CriterionVisitor<RESULT, PARAM>
{

    public RESULT visit(Criterion<?> criterion, PARAM param)
    {
        throw notImplemented(criterion, param);
    }

    @Override
    public <T> RESULT visit(SameCriterion<T> criterion, PARAM param)
    {
        throw notImplemented(criterion, param);
    }

    @Override
    public <T> RESULT visit(EqualCriterion<T> criterion, PARAM param)
    {
        throw notImplemented(criterion, param);
    }

    @Override
    public RESULT visit(NotCriterion criterion, PARAM param)
    {
        throw notImplemented(criterion, param);
    }

    @Override
    public RESULT visit(AndCriterion criterion, PARAM param)
    {
        throw notImplemented(criterion, param);
    }

    @Override
    public RESULT visit(OrCriterion criterion, PARAM param)
    {
        throw notImplemented(criterion, param);
    }

    @Override
    public <T extends Comparable<T>> RESULT visit(LesserCriterion<T> criterion, PARAM param)
    {
        throw notImplemented(criterion, param);
    }

    @Override
    public <T extends Comparable<T>> RESULT visit(GreaterCriterion<T> criterion, PARAM param)
    {
        throw notImplemented(criterion, param);
    }

    protected final UnsupportedOperationException notImplemented(Criterion<?> criterion, PARAM param)
    {
        return new UnsupportedOperationException(format("%s can't visit %s", getClass().getName(), criterion.getClass().getName()));
    }
}
