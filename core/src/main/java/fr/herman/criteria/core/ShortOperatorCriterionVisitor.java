package fr.herman.criteria.core;

import fr.herman.criteria.core.criterion.objects.EqualCriterion;
import fr.herman.criteria.core.criterion.objects.SameCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.AndCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.NotCriterion;
import fr.herman.criteria.core.criterion.objects.booleans.OrCriterion;
import fr.herman.criteria.core.criterion.objects.comparable.GreaterCriterion;
import fr.herman.criteria.core.criterion.objects.comparable.LesserCriterion;

public class ShortOperatorCriterionVisitor extends CriterionVisitor<String, Void>
{

    public String visit(Criterion<?> criterion, Void param)
    {
        return "?";
    }

    @Override
    public <T> String visit(SameCriterion<T> criterion, Void param)
    {
        return "==";
    }

    @Override
    public <T> String visit(EqualCriterion<T> criterion, Void param)
    {
        return "eq";
    }

    @Override
    public String visit(NotCriterion criterion, Void param)
    {
        return "not";
    }

    @Override
    public String visit(AndCriterion criterion, Void param)
    {
        return "and";
    }

    @Override
    public String visit(OrCriterion criterion, Void param)
    {
        return "or";
    }

    @Override
    public <T extends Comparable<T>> String visit(LesserCriterion<T> criterion, Void param)
    {
        return "<";
    }

    @Override
    public <T extends Comparable<T>> String visit(GreaterCriterion<T> criterion, Void param)
    {
        return ">";
    }

}
