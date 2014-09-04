package fr.herman.criteria.core.criterion.objects.booleans;

import java.util.List;
import fr.herman.criteria.core.Criterion;
import fr.herman.criteria.core.CriterionVisitor;
import fr.herman.criteria.core.criterion.HasExpressionList;

public class AndCriterion extends HasExpressionList<Criterion<?>> implements Criterion<Boolean>
{

    public AndCriterion(List<Criterion<?>> expressions)
    {
        super(expressions);
    }

    @Override
    public <RESULT, PARAM> RESULT accept(CriterionVisitor<RESULT, PARAM> visitor, PARAM param)
    {
        return visitor.visit(this, param);
    }

}
