package fr.herman.criteria.criterion.objects.booleans;

import fr.herman.criteria.Criterion;
import fr.herman.criteria.CriterionVisitor;

public class AndCriterion implements Criterion<Boolean>
{

    public <RESULT, PARAM> RESULT accept(CriterionVisitor<RESULT, PARAM> visitor, PARAM param)
    {
        return visitor.visit(this, param);
    }

}
