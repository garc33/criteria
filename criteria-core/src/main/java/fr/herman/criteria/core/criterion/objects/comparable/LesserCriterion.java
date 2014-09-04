package fr.herman.criteria.core.criterion.objects.comparable;

import fr.herman.criteria.core.Criterion;
import fr.herman.criteria.core.CriterionVisitor;
import fr.herman.criteria.core.criterion.HasParameterLeftAndRight;
import fr.herman.criteria.core.parameter.Parameter;

public class LesserCriterion<T extends Comparable<T>> extends HasParameterLeftAndRight<T> implements Criterion<T>
{

    public LesserCriterion(Parameter<T> left, Parameter<T> right)
    {
        super(left, right);
    }

    @Override
    public <RESULT, PARAM> RESULT accept(CriterionVisitor<RESULT, PARAM> visitor, PARAM param)
    {
        return visitor.visit(this, param);
    }

}
