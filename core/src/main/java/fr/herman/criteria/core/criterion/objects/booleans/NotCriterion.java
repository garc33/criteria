package fr.herman.criteria.core.criterion.objects.booleans;

import fr.herman.criteria.core.Criterion;
import fr.herman.criteria.core.CriterionVisitor;

public class NotCriterion implements Criterion<Boolean>
{
    private final Criterion<?> subCriterion;

    public NotCriterion(Criterion<?> subCriterion)
    {
        super();
        this.subCriterion = subCriterion;
    }

    @Override
    public <RESULT, PARAM> RESULT accept(CriterionVisitor<RESULT, PARAM> visitor, PARAM param)
    {
        return visitor.visit(this, param);
    }

    public Criterion<?> getSubCriterion()
    {
        return subCriterion;
    }

}
