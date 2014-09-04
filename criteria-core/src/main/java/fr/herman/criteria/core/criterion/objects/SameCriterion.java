package fr.herman.criteria.core.criterion.objects;

import fr.herman.criteria.core.Criterion;
import fr.herman.criteria.core.CriterionVisitor;
import fr.herman.criteria.core.criterion.HasParameterLeftAndRight;
import fr.herman.criteria.core.parameter.Parameter;

public class SameCriterion<T extends Object> extends HasParameterLeftAndRight<T> implements Criterion<T>
{

    public SameCriterion(Parameter<T> left, Parameter<T> right)
    {
        super(left, right);
    }

    @Override
    public <RESULT, PARAM> RESULT accept(CriterionVisitor<RESULT, PARAM> visitor, PARAM param)
    {
        return visitor.visit(this, param);
    }

}
