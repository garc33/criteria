package fr.herman.criteria.core;

import fr.herman.criteria.core.criterion.objects.EqualCriterion;
import fr.herman.criteria.core.criterion.objects.SameCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.AndCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.NotCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.OrCriterion;
import fr.herman.criteria.core.criterion.objects.comparable.GreaterCriterion;
import fr.herman.criteria.core.criterion.objects.comparable.LesserCriterion;

public class EmptyCriterionVisitor<RESULT, PARAM> extends CriterionVisitor<RESULT, PARAM>
{

    @Override
    public <T> RESULT visit(SameCriterion<T> criterion, PARAM param)
    {
        return null;
    }

    @Override
    public <T> RESULT visit(EqualCriterion<T> criterion, PARAM param)
    {
        return null;
    }

    @Override
    public RESULT visit(NotCriterion criterion, PARAM param)
    {
        return null;
    }

    @Override
    public RESULT visit(AndCriterion criterion, PARAM param)
    {
        return null;
    }

    @Override
    public RESULT visit(OrCriterion criterion, PARAM param)
    {
        return null;
    }

    @Override
    public <T extends Comparable<T>> RESULT visit(LesserCriterion<T> criterion, PARAM param)
    {
        return null;
    }

    @Override
    public <T extends Comparable<T>> RESULT visit(GreaterCriterion<T> criterion, PARAM param)
    {
        return null;
    }


}
