package fr.herman.criteria.criterion.objects.comparable;

import fr.herman.criteria.Criterion;
import fr.herman.criteria.CriterionVisitor;
import fr.herman.criteria.criterion.HasParameterLeftAndRight;
import fr.herman.criteria.parameter.Parameter;

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
